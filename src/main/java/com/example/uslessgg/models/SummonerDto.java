package com.example.uslessgg.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummonerDto {
    private String id;
    private String puuid;
    private int profileIconId;
    private long revisionDate;
    private int summonerLevel;

    public String getId() {
        return id;
    }

    public String getPuuid() {
        return puuid;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    @Override
    public String toString() {
        return "SummonerDto{" +
                "puuid='" + puuid + '\'' +
                ", profileIconId=" + profileIconId +
                ", revisionDate=" + revisionDate +
                ", summonerLevel=" + summonerLevel +
                '}';
    }
}
