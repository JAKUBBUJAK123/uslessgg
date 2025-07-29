package com.example.uslessgg.models.matchHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MatchResult {
    private String matchId;
    private boolean won;

    public MatchResult(String matchId , boolean won) {
        this.matchId = matchId;
        this.won = won;
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "matchId='" + matchId + '\'' +
                ", won=" + won +
                '}';
    }
}
