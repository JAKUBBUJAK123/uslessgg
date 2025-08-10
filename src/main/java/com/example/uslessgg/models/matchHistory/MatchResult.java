package com.example.uslessgg.models.matchHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.plaf.synth.Region;

@Data
@NoArgsConstructor
public class MatchResult {
    private String matchId;
    private boolean won;
    private ParticipantDto participant;
    private InfoDto info;
    private String region;
    private String uslessScore;

    public MatchResult(String matchId, boolean won, ParticipantDto participant, InfoDto info, String region, String uslessScore) {
        this.matchId = matchId;
        this.won = won;
        this.participant = participant;
        this.info = info;
        this.region = region;
        this.uslessScore = uslessScore;
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

    public String getUslessScore() {
        return uslessScore;
    }

    public String getRegion() {
        return region;
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
