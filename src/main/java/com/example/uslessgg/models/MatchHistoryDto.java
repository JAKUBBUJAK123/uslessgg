package com.example.uslessgg.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchHistoryDto {
    private List<String> History;

    @Override
    public String toString() {
        return "MatchHistoryDto{" +
                "History=" + History +
                '}';
    }
}
