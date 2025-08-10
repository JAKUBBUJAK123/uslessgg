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
    @JsonProperty("goldEarned")
    private int goldEarned;
    @JsonProperty("individualPosition")
    private String individualPosition;
    @JsonProperty("totalMinionsKilled")
    private int totalMinionsKilled;

    //Jungle Stats
    @JsonProperty("objectivesStolen")
    private int objectivesStolen;
    @JsonProperty("dragonKills")
    private int dragonKills;
    @JsonProperty("firstBloodKill")
    private boolean firstBloodKill;
    @JsonProperty("firstBloodAssist")
    private boolean firstBloodAssist;
    @JsonProperty("totalEnemyJungleMinionsKilled")
    private int totalEnemyJungleMinionsKilled;
    @JsonProperty("visionScore")
    private int visionScore;

    //Top Stats
    @JsonProperty("damageDealtToTurrets")
    private int damageDealtToTurrets;
    @JsonProperty("totalDamageTaken")
    private int totalDamageTaken;
    @JsonProperty("turretKills")
    private int turretKills;


    //Supp Stats
    @JsonProperty("timeCCingOthers")
    private int timeCCingOthers;
    @JsonProperty("totalDamageShieldedOnTeammates")
    private int totalDamageShieldedOnTeammates;
    @JsonProperty("totalHealsOnTeammates")
    private int totalHealsOnTeammates;


    //Adc Statsd
    @JsonProperty("doubleKills")
    private int doubleKills;
    @JsonProperty("killingSprees")
    private int killingSprees;
    @JsonProperty("largestKillingSpree")
    private int largestKillingSpree;
    @JsonProperty("totalDamageDealtToChampions")
    private int totalDamageDealtToChampions;
    @JsonProperty("totalTimeSpentDead")
    private int totalTimeSpentDead;
    @JsonProperty("largestMultiKill")
    private int largestMultiKill;

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

    public int getLargestMultiKill() {
        return largestMultiKill;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public int getTurretKills() {
        return turretKills;
    }

    public int getTimeCCingOthers() {
        return timeCCingOthers;
    }

    public int getTotalDamageShieldedOnTeammates() {
        return totalDamageShieldedOnTeammates;
    }

    public int getTotalHealsOnTeammates() {
        return totalHealsOnTeammates;
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

    public int getDoubleKills() {
        return doubleKills;
    }

    public int getKillingSprees() {
        return killingSprees;
    }

    public int getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public int getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public int getTotalTimeSpentDead() {
        return totalTimeSpentDead;
    }

    public int getDeaths() {
        return deaths;
    }

    public String getIndividualPosition() {
        return individualPosition;
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

    public int getGoldEarned() {
        return goldEarned;
    }

    public int getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public int getDragonKills() {
        return dragonKills;
    }

    public boolean isFirstBloodKill() {
        return firstBloodKill;
    }

    public boolean isFirstBloodAssist() {
        return firstBloodAssist;
    }

    public int getTotalEnemyJungleMinionsKilled() {
        return totalEnemyJungleMinionsKilled;
    }

    public int getVisionScore() {
        return visionScore;
    }

    public int getDamageDealtToTurrets() {
        return damageDealtToTurrets;
    }
}
