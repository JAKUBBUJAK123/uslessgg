package com.example.uslessgg.models.matchHistory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InfoDto {
    @JsonProperty("gameCreation")
    private long gameCreation;
    @JsonProperty("gameDuration")
    private long gameDuration;
    @JsonProperty("gameMode")
    private String gameMode;
    @JsonProperty("gameType")
    private String gameType;
    @JsonProperty("participants")
    private List<ParticipantDto> participants;
    @Override
    public String toString() {
        return "InfoDto{" +
                "gameCreation=" + gameCreation +
                ", gameDuration=" + gameDuration +
                ", gameMode='" + gameMode + '\'' +
                ", gameType='" + gameType + '\'' +
                ", participants=" + participants +
                '}';
    }

    public List<ParticipantDto> getParticipants() {
        return participants;
    }
}
