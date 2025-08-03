package com.example.uslessgg.models.matchHistory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoDto {
    @JsonProperty("gameCreation")
    private long gameCreation;
    @JsonProperty("gameDuration")
    private long gameDuration;
    @JsonProperty("gameMode")
    private String gameMode;
    @JsonProperty("participants")
    private List<ParticipantDto> participants;

    public long getGameCreation() {
        return gameCreation;
    }

    public long getGameDuration() {
        return gameDuration;
    }

    public String getGameMode() {
        return gameMode;}

    public List<ParticipantDto> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return "InfoDto{" +
                "gameCreation=" + gameCreation +
                ", gameDuration=" + gameDuration +
                ", gameMode='" + gameMode + '\'' +
                ", participants=" + participants +
                '}';
    }
}
