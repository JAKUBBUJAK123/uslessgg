package com.example.uslessgg.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RiotApiConfig {
    @Value("${riot.api.key}")
    private String apiKey;

    @Value("${riot.api.base-url.summoner}")
    private String summonerUrlTemplate;

    @Value("${riot.api.base-url.account}")
    private String accountBaseUrlTemplate;

    @Value("${riot.api.default-platform}")
    private String defaultPlatform;

    @Value("${riot.api.default-regional}")
    private String defaultRegional;

    @Bean(name = "summonerWebClient")
    public WebClient summonerWebClient() {
        String baseUrl = summonerUrlTemplate.replace("{platform}", defaultPlatform);
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("X-Riot-Token", apiKey)
                .build();
    }

    @Bean(name = "accountWebClient")
    public WebClient accountWebClient() {
        String baseUrl = accountBaseUrlTemplate.replace("{regional}", defaultRegional);
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("X-Riot-Token", apiKey)
                .build();
    }
    @Bean
    public WebClient ddragonWebClient() {
        return WebClient.builder()
                .baseUrl("https://ddragon.leagueoflegends.com")
                .build();
    }
}
