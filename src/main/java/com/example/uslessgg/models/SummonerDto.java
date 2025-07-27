package com.example.uslessgg.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummonerDto {
    private int id;
    private String puuid;
    private int profileIconId;
    private long revisionDate;
    private int summonerLevel;

    public int getProfileIconId() {
        return profileIconId;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public String getPuuid() {
        return puuid;
    }

    public long getSummonerLevel() {
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
