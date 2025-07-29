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

    @Override
    public String toString() {
        return "ParticipantDto{" +
                "puuid='" + puuid + '\'' +
                ", win=" + win +
                '}';
    }

    public String getPuuid() {
        return puuid;
    }

    public boolean isWin() {
        return win;
    }
}
