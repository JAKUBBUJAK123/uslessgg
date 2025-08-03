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
import java.util.Map;

@Service
public class RiotApiService {
    private final WebClient ddragonWebClient;
    private final WebClient riotWebClient;
    private String latestDdragonVersion;

    private static final Map<String, String> PLATFORM_MAP = Map.of(
            "EUW", "euw1.api.riotgames.com", "EUNE", "eun1.api.riotgames.com", "NA", "na1.api.riotgames.com"
    );
    private static final Map<String, String> REGION_MAP = Map.of(
            "EUW", "europe.api.riotgames.com", "EUNE", "europe.api.riotgames.com", "NA", "americas.api.riotgames.com"
    );

    public RiotApiService(

            @Qualifier("riotWebClient") WebClient riotWebClient,
            @Qualifier("ddragonWebClient") WebClient ddragonWebClient){

        this.riotWebClient = riotWebClient;
        this.ddragonWebClient = ddragonWebClient;

        fetchLatestDdragonVersion().subscribe(version -> {
            this.latestDdragonVersion = version;
        });
    }

    public Mono<AccountDto> getAccountByRiotId(String gameName, String tagLine, String region){
        String regionalHost = REGION_MAP.get(region.toUpperCase());
        return riotWebClient.get()
                .uri("https://{region}/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}", regionalHost,gameName, tagLine)
                .retrieve()
                .bodyToMono(AccountDto.class);
    }
    public Mono<SummonerDto> getSummonerByPuuid(String platform, String puuid) {
        String platformHost = PLATFORM_MAP.get(platform.toUpperCase());
        return riotWebClient.get()
                .uri("https://{platform}/lol/summoner/v4/summoners/by-puuid/{puuid}", platformHost,puuid)
                .retrieve()
                .bodyToMono(SummonerDto.class);
    }

    public Mono<List<String>> getMatchHistoryByPuuid(String puuid, String region){
        String regionalHost = REGION_MAP.get(region.toUpperCase());
        return riotWebClient.get()
                .uri("https://{region}/lol/match/v5/matches/by-puuid/{puuid}/ids" , regionalHost,puuid)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {
                });
    }

    public Mono<List<EntriesDto>> getEntriesByPuuid(String encryptedPuuid, String platform){
        String platformHost = PLATFORM_MAP.get(platform.toUpperCase());
        return riotWebClient.get()
                .uri("https://{platform}/lol/league/v4/entries/by-puuid/{encryptedSummonerId}", platformHost,encryptedPuuid)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EntriesDto>>() {
                });
    }

    public Mono<MatchDto> getMatchById(String matchId, String region){
        String regionalHost = REGION_MAP.get(region.toUpperCase());
        return riotWebClient.get()
                .uri("https://{region}/lol/match/v5/matches/{matchId}", regionalHost,matchId)
                .retrieve()
                .bodyToMono(MatchDto.class);
    }

    public Mono<String> fetchLatestDdragonVersion() {
        return ddragonWebClient.get()
                .uri("/api/versions.json")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {})
                .map(versions -> versions.get(0));
    }

    public String getLatestDdragonVersion() {
        if (latestDdragonVersion == null) {
            try {
                latestDdragonVersion = fetchLatestDdragonVersion().block();
            } catch (Exception e) {
                latestDdragonVersion = "14.14.1";
            }
        }
        return latestDdragonVersion;
    }
}
