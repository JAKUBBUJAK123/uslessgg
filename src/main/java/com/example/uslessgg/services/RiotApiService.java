package com.example.uslessgg.services;

import com.example.uslessgg.models.AccountDto;
import com.example.uslessgg.models.EntriesDto;
import com.example.uslessgg.models.SummonerDto;
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

    public RiotApiService(
            @Qualifier("summonerWebClient") WebClient summonerWebClient,
            @Qualifier("accountWebClient") WebClient accountWebClient){
        this.summonerWebClient = summonerWebClient;
        this.accountWebClient = accountWebClient;
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
}
