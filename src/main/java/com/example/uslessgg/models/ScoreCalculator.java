package com.example.uslessgg.models;

import com.example.uslessgg.models.matchHistory.ParticipantDto;

public class ScoreCalculator {
    public static double calculateJungleScore(ParticipantDto participant){
        int objectivesStolen = participant.getObjectivesStolen();
        int kills = participant.getKills();
        int deaths = participant.getDeaths();
        int assists = participant.getAssists();
        int dragonKills = participant.getDragonKills();
        int visionScore = participant.getVisionScore();
        int goldEarned = participant.getGoldEarned();
        boolean isfb = participant.isFirstBloodKill();
        boolean isfba = participant.isFirstBloodAssist();
        int enemyCampsStolen = participant.getTotalEnemyJungleMinionsKilled();
        double score = (objectivesStolen * 1500) +
                (dragonKills * 500) +
                ((kills + assists) * 40) +
                (enemyCampsStolen * 20) +
                (visionScore * 15) -
                (deaths * 50) +
                (goldEarned / 100.0);
        if (isfb) {
            score += 300;
        }
        if (isfba) {
            score += 150;
        }
        return score;
    };
    public static double calculateAdcScore(ParticipantDto participant){
        int kills = participant.getKills();
        int deaths = participant.getDeaths();
        int assists = participant.getAssists();
        int goldEarned = participant.getGoldEarned();
        int doubleKills= participant.getDoubleKills();
        int killingSprees = participant.getKillingSprees();
        int largestSpree = participant.getLargestKillingSpree();
        int totalDmg = participant.getTotalDamageDealtToChampions();
        int totalDeadTime = participant.getTotalTimeSpentDead();
        int largestMultiKill = participant.getLargestMultiKill();
        int totalMinionsKilled = participant.getTotalMinionsKilled();

        double score = (totalDmg / 100.0) +
                (totalMinionsKilled * 10) +
                ((kills + assists) * 30) +
                (doubleKills * 100) +
                (largestMultiKill * 200) +
                (killingSprees * 50) +
                (largestSpree * 75) +
                (goldEarned / 200.0) -
                (deaths * 60) -
                (totalDeadTime / 5.0);
        return score;
    };
}
