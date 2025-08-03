package com.example.uslessgg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntriesDto {
    @JsonProperty("leagueId")
    private String leagueId;
    @JsonProperty("queueType")
    private String queueType;
    @JsonProperty("tier")
    private String tier;
    @JsonProperty("rank")
    private String rank;
    @JsonProperty("puuid")
    private String puuid;
    @JsonProperty("leaguePoints")
    private Integer leaguePoints;
    @JsonProperty("wins")
    private Integer wins;
    @JsonProperty("losses")
    private Integer losses;
    @JsonProperty("veteran")
    private boolean veteran;
    @JsonProperty("inactive")
    private boolean inactive;
    @JsonProperty("freshBlood")
    private boolean freshBlood;
    @JsonProperty("hotStreak")
    private boolean hotStreak;

    @Override
    public String toString() {
        return "EntriesDto{" +
                "leagueId='" + leagueId + '\'' +
                ", queueType='" + queueType + '\'' +
                ", tier='" + tier + '\'' +
                ", rank='" + rank + '\'' +
                ", puuid='" + puuid + '\'' +
                ", leaguePoints=" + leaguePoints +
                ", wins=" + wins +
                ", losses=" + losses +
                ", veteran=" + veteran +
                ", inactive=" + inactive +
                ", freshBlood=" + freshBlood +
                ", hotStreak=" + hotStreak +
                '}';
    }

    public String getLeagueId() {
        return leagueId;
    }

    public String getQueueType() {
        return queueType;
    }

    public String getTier() {
        return tier;
    }

    public String getRank() {
        return rank;
    }

    public String getPuuid() {
        return puuid;
    }

    public Integer getLeaguePoints() {
        return leaguePoints;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public boolean isInactive() {
        return inactive;
    }

    public boolean isFreshBlood() {
        return freshBlood;
    }

    public boolean isHotStreak() {
        return hotStreak;
    }
}
