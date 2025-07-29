package com.example.uslessgg.models.matchHistory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDto {
    @JsonProperty("info")
    private InfoDto info;

    @Override
    public String toString() {
        return "MatchDto{" +
                "info=" + info +
                '}';
    }

    public InfoDto getInfo() {
        return info;
    }
}
