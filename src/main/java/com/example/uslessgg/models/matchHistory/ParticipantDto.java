package com.example.uslessgg.models.matchHistory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {
    @JsonProperty("puuid")
    private String puuid;
    @JsonProperty("win")
    private boolean win;
    @JsonProperty("kills")
    private int kills;
    @JsonProperty("deaths")
    private int deaths;
    @JsonProperty("assists")
    private int assists;
    @JsonProperty("championName")
    private String championName;
    @JsonProperty("objectivesStolen")
    private int objectivesStolen;

    @Override
    public String toString() {
        return "ParticipantDto{" +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", assists=" + assists +
                ", championName='" + championName + '\'' +
                ", objectivesStolen=" + objectivesStolen +
                '}';
    }

    public String getPuuid() {
        return puuid;
    }

    public boolean isWin() {
        return win;
    }

    public String getChampionName() {
        return championName;
    }

    public int getAssists() {
        return assists;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getKills() {
        return kills;
    }
}
