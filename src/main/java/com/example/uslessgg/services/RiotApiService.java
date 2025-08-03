package com.example.uslessgg.services;

import com.example.uslessgg.models.AccountDto;
import com.example.uslessgg.models.EntriesDto;
import com.example.uslessgg.models.SummonerDto;
import com.example.uslessgg.models.matchHistory.MatchDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;

@Service
public class RiotApiService {
    private final WebClient summonerWebClient;
    private final WebClient accountWebClient;
    private final WebClient ddragonWebClient;
    private String latestDdragonVersion;

    public RiotApiService(
            @Qualifier("summonerWebClient") WebClient summonerWebClient,
            @Qualifier("accountWebClient") WebClient accountWebClient,
            @Qualifier("ddragonWebClient") WebClient ddragonWebClient){
        this.summonerWebClient = summonerWebClient;
        this.accountWebClient = accountWebClient;
        this.ddragonWebClient = ddragonWebClient;
        fetchLatestDdragonVersion().subscribe(version -> {
            this.latestDdragonVersion = version;
        });
    }

    public Mono<AccountDto> getAccountByRiotId(String gameName, String tagLine){
        return accountWebClient.get()
                .uri("/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}", gameName, tagLine)
                .retrieve()
                .bodyToMono(AccountDto.class) // Expecting an AccountDto
                .doOnError(error -> System.err.println("Error fetching account by Riot ID: " + error.getMessage()));
    }
    public Mono<SummonerDto> getSummonerByPuuid(String puuid) {
        return summonerWebClient.get()
                .uri("/lol/summoner/v4/summoners/by-puuid/{puuid}", puuid)
                .retrieve()
                .bodyToMono(SummonerDto.class) // Expecting a SummonerDto
                .doOnError(error -> System.err.println("Error fetching summoner by PUUID: " + error.getMessage()));
    }

    public Mono<List<String>> getMatchHistoryByPuuid(String puuid){
        return accountWebClient.get()
                .uri("/lol/match/v5/matches/by-puuid/{puuid}/ids" , puuid)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {
                });
    }

    public Mono<List<EntriesDto>> getEntriesByPuuid(String encryptedPuuid){
        return summonerWebClient.get()
                .uri("/lol/league/v4/entries/by-puuid/{encryptedSummonerId}", encryptedPuuid)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EntriesDto>>() {
                });
    }

    public Mono<MatchDto> getMatchById(String matchId){
        return accountWebClient.get()
                .uri("/lol/match/v5/matches/{matchId}", matchId)
                .retrieve()
                .bodyToMono(MatchDto.class);
    }

    public Mono<String> fetchLatestDdragonVersion() {
        return ddragonWebClient.get()
                .uri("/api/versions.json")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {})
                .map(versions -> versions.get(0)); // Get the first (latest) version
    }

    public String getLatestDdragonVersion() {
        if (latestDdragonVersion == null) {
            try {
                latestDdragonVersion = fetchLatestDdragonVersion().block();
            } catch (Exception e) {
                latestDdragonVersion = "14.14.1"; // Fallback
            }
        }
        return latestDdragonVersion;
    }
}
