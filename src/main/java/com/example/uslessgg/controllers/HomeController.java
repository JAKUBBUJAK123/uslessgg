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

    public HomeController(RiotApiService riotApiService){
        this.riotApiService = riotApiService;
    }
    @GetMapping("/")
    public String homePage(Model model){
      model.addAttribute("message" , "Ready to search for summoners");
      return "index";
    };

    @GetMapping("/search-summoner")
    public String searchSummoner(
            @RequestParam("gameName") String gameName,
            @RequestParam("tagLine") String tagLine,
            Model model) {
        try {
            Mono<AccountDto> accountMono = riotApiService.getAccountByRiotId(gameName, tagLine);
            Mono<SummonerDto> summonerMono = accountMono.flatMap(account -> {
                return riotApiService.getSummonerByPuuid(account.getPuuid());
            });
            SummonerDto summoner = summonerMono.block();

            Mono<List<String>> matchHistoryMono = summonerMono.flatMap(s -> {
                return riotApiService.getMatchHistoryByPuuid(s.getPuuid());
            });
            List<String> matchHistory = matchHistoryMono.block();

            Mono<List<EntriesDto>> entriesDto = summonerMono.flatMap(e ->{
                return riotApiService.getEntriesByPuuid(e.getPuuid());
            });
            List<EntriesDto> entries = entriesDto.block();

            List<MatchResult> matchResults = new ArrayList<>();
            if (summoner != null && matchHistory != null){
                String currentSummoner = summoner.getPuuid();
                for(String matchId: matchHistory){
                    MatchDto matchDto = riotApiService.getMatchById(matchId).block();
                    boolean won = false;
                    if (matchDto != null && matchDto.getInfo() != null && matchDto.getInfo().getParticipants() != null){
                        ParticipantDto summonerParticipant = matchDto.getInfo().getParticipants().stream()
                                .filter(p -> currentSummoner.equals(p.getPuuid()))
                                .findFirst()
                                .orElse(null);
                        won = summonerParticipant.isWin();
                    }
                    matchResults.add(new MatchResult(matchId, won));
                }
            }

            model.addAttribute("summoner", summoner);
            model.addAttribute("entries" , entries);
            model.addAttribute("matchResults", matchResults);
            model.addAttribute("account", gameName + "#" + tagLine);
            model.addAttribute("message", "Summoner found!");
            return "search-summoner";
        } catch (Exception e) {
            System.err.println("Error finding summoner: " + e.getMessage());
            model.addAttribute("message", "Error finding summoner: " + e.getMessage() + ". Please check Game Name and Tag Line.");
            return "index";
        }
    }

}
