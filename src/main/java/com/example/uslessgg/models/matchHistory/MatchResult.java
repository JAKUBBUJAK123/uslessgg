package com.example.uslessgg.models.matchHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MatchResult {
    private String matchId;
    private boolean won;
    private ParticipantDto participant;
    private InfoDto info;

    public MatchResult(String matchId, boolean won, ParticipantDto participant, InfoDto info) {
        this.matchId = matchId;
        this.won = won;
        this.participant = participant;
        this.info = info;
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "matchId='" + matchId + '\'' +
                ", won=" + won +
                ", participant=" + participant +
                '}';
    }

    public String getMatchId() {
        return matchId;
    }

    public boolean isWon() {
        return won;
    }

    public ParticipantDto getParticipant() {
        return participant;
    }

    public InfoDto getInfo() {
        return info;
    }
}
