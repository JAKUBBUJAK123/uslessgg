package com.example.uslessgg.models.matchHistory;

import com.example.uslessgg.models.SummonerSpells;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {
    @JsonProperty("puuid")
    private String puuid;
    @JsonProperty("riotIdGameName")
    private String riotIdGameName;
    @JsonProperty("riotIdTagline")
    private String riotIdTagline;
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
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;

    private int summoner1Id;
    private int summoner2Id;
    private SummonerSpells summonerSpells = new SummonerSpells();




    @Override
    public String toString() {
        return "ParticipantDto{" +
                "puuid='" + puuid + '\'' +
                ", win=" + win +
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
    public String getRiotIdGameName() {
        return riotIdGameName;
    }

    public int getsummoner1Id() {
        return summoner1Id;
    }

    public int getsummoner2Id() {
        return summoner2Id;
    }
    public String getRiotIdTagline() {
        return riotIdTagline;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }

    public String getChampionName() {
        if(this.championName.equals("FiddleSticks")){
            return "Fiddlesticks";
        }else{
            return championName;
        }

    }

    public int getObjectivesStolen() {
        return objectivesStolen;
    }
    public int getItem0() {
        return item0;
    }

    public int getItem1() {
        return item1;
    }

    public int getItem2() {
        return item2;
    }

    public int getItem3() {
        return item3;
    }

    public int getItem4() {
        return item4;
    }

    public int getItem5() {
        return item5;
    }

    public int getItem6() {
        return item6;
    }

    public SummonerSpells getSummonerSpells() {
        return summonerSpells;
    }
}
