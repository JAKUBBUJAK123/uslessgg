package com.example.uslessgg.controllers;

import com.example.uslessgg.models.AccountDto;
import com.example.uslessgg.models.EntriesDto;
import com.example.uslessgg.models.SummonerDto;
import com.example.uslessgg.models.matchHistory.MatchDto;
import com.example.uslessgg.models.matchHistory.MatchResult;
import com.example.uslessgg.models.matchHistory.ParticipantDto;
import com.example.uslessgg.services.RiotApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private final RiotApiService riotApiService;

    public HomeController(RiotApiService riotApiService) {
        this.riotApiService = riotApiService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("message", "Ready to search for summoners");
        return "index";
    }

    @GetMapping("/search-summoner")
    public String searchSummoner(
            @RequestParam("gameName") String gameName,
            @RequestParam("tagLine") String tagLine,
            @RequestParam("region") String region,
            Model model) {
        try {
            // Get account information
            Mono<AccountDto> accountMono = riotApiService.getAccountByRiotId(gameName, tagLine, region);
            Mono<SummonerDto> summonerMono = accountMono
                    .flatMap(account -> riotApiService.getSummonerByPuuid(region,account.getPuuid()));
            SummonerDto summoner = summonerMono.block();

            // Get match history
            Mono<List<String>> matchHistoryMono = summonerMono
                    .flatMap(summonerDto -> riotApiService.getMatchHistoryByPuuid(summonerDto.getPuuid(), region));
            List<String> matchHistory = matchHistoryMono.block();

            // Get league entries
            Mono<List<EntriesDto>> entriesMono = summonerMono
                    .flatMap(summonerDto -> riotApiService.getEntriesByPuuid(summonerDto.getPuuid(), region));
            List<EntriesDto> entries = entriesMono.block();

            // Process match results
            List<MatchResult> matchResults = new ArrayList<>();
            if (summoner != null && matchHistory != null) {
                String currentSummonerPuuid = summoner.getPuuid();
                for (String matchId : matchHistory) {
                    MatchDto matchDto = riotApiService.getMatchById(matchId, region).block();
                    if (matchDto != null && matchDto.getInfo() != null
                            && matchDto.getInfo().getParticipants() != null) {
                        ParticipantDto summonerParticipant = matchDto.getInfo().getParticipants().stream()
                                .filter(participant -> currentSummonerPuuid.equals(participant.getPuuid()))
                                .findFirst()
                                .orElse(null);

                        if (summonerParticipant != null) {
                            boolean won = summonerParticipant.isWin();
                            matchResults.add(new MatchResult(matchId, won, summonerParticipant, matchDto.getInfo(), region));
                        }
                    }
                }
            }

            // Add attributes to model
            model.addAttribute("summoner", summoner);
            model.addAttribute("entries", entries);
            model.addAttribute("history", matchHistory);
            model.addAttribute("matchResults", matchResults);
            model.addAttribute("account", gameName + "#" + tagLine);
            model.addAttribute("message", "Summoner found!");
            return "search-summoner";
        } catch (Exception e) {
            System.err.println("Error finding summoner: " + e.getMessage());
            model.addAttribute("message",
                    "Error finding summoner: " + e.getMessage() + ". Please check Game Name and Tag Line.");
            return "index";
        }
    }
}
