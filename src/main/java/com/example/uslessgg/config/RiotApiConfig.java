package com.example.uslessgg.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RiotApiConfig {
    @Value("${riot.api.key}")
    private String apiKey;
    @Bean(name = "riotWebClient")
    public WebClient riotWebClient() {
        return WebClient.builder()
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



