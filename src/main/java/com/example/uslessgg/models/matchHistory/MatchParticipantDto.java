package com.example.uslessgg.models.matchHistory;

public class MatchParticipantDto {
    private String puuid;
    private String summonerName;
    private String championName;
    private String lane;
    private double jungleScore;
    private double bottomScore;
    private double topScore;
    private double midScore;
    private double supportScore;

    public String getPuuid() {
        return puuid;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public String getChampionName() {
        return championName;
    }

    public String getLane() {
        return lane;
    }

    public double getJungleScore() {
        return jungleScore;
    }

    public double getBottomScore() {
        return bottomScore;
    }

    public double getTopScore() {
        return topScore;
    }

    public double getMidScore() {
        return midScore;
    }

    public double getSupportScore() {
        return supportScore;
    }


}
