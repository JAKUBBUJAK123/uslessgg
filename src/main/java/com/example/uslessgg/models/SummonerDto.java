package com.example.uslessgg.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummonerDto {
    private String id;
    private String accountId;
    private String puuid;
    private String name;
    private int profileIconId;
    private long summonerLevel;
    private long revisionDate;

    public String getName() {
        return name;
    }
}
