package com.example.uslessgg.services;

import com.example.uslessgg.models.AccountDto;
import com.example.uslessgg.models.SummonerDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
                // The URI path should be relative to the base URL configured for summonerWebClient
                // The base URL for summonerWebClient is riot.api.base-url.summoner (e.g., https://euw1.api.riotgames.com)
                .uri("/lol/summoner/v4/summoners/by-puuid/{puuid}", puuid)
                .retrieve()
                .bodyToMono(SummonerDto.class) // Expecting a SummonerDto
                .doOnError(error -> System.err.println("Error fetching summoner by PUUID: " + error.getMessage()));
    }
}
