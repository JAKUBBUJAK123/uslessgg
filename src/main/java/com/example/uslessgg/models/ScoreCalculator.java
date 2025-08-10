package com.example.uslessgg.models;

import com.example.uslessgg.models.matchHistory.ParticipantDto;

public class ScoreCalculator {
    public static String calculateJungleScore(ParticipantDto participant, long gameDuration){
        double minutes = Math.max(1, gameDuration / 60.0);
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
        String useless = "";
        score = score / minutes;
        if(score < 50){
            useless = "\uD83D\uDC80-Cipeczka";
        }else if (score >=50 && score< 70){
            useless = "\uD83D\uDCA9-Klocek";
        } else if (score>=70 && score<90) {
            useless = "\uD83D\uDC74-Słabeuszek";
        } else if (score>=90 && score<140) {
            useless = "\uD83D\uDE0E-Cosik-tam-zagrał";
        } else if (score>=140) {
            useless = "\uD83D\uDD25-Kubus-godlike-tier";
        }

        return useless;
    };
    public static String calculateAdcScore(ParticipantDto participant, long gameDuration){
        double minutes = Math.max(1, gameDuration / 60.0);
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
        String useless = "";
        score = score / minutes;
        if(score < 60){
            useless = "\uD83D\uDC80-Cipeczka";
        }else if (score >=60 && score< 80){
            useless = "\uD83D\uDCA9-Klocek";
        } else if (score>=80 && score<100) {
            useless = "\uD83D\uDC74-Słabeuszek";
        } else if (score>=100 && score<150) {
            useless = "\uD83D\uDE0E-Cosik-tam-zagrał";
        } else if (score>=150) {
            useless = "\uD83D\uDD25-Kubus-godlike-tier";
        }

        return useless;
    };

    public static String calculateTopScore(ParticipantDto participant , long gameDuration){
        double minutes = Math.max(1, gameDuration / 60.0);
        int kills = participant.getKills();
        int deaths = participant.getDeaths();
        int assists = participant.getAssists();
        int damageDealtToTurrets = participant.getDamageDealtToTurrets();
        int totalDamageTaken = participant.getTotalDamageTaken();
        int turretKills = participant.getTurretKills();
        int goldEarned = participant.getGoldEarned();
        int totalMinionsKilled = participant.getTotalMinionsKilled();

        double score = (turretKills * 400) +
                (damageDealtToTurrets / 200.0) +
                (totalDamageTaken / 100.0) +
                ((kills + assists) * 35) +
                (totalMinionsKilled * 12) +
                (goldEarned / 250.0) -
                (deaths * 70);
        score = score / minutes;
        String useless = "";
        if(score < 60){
            useless = "\uD83D\uDC80-Cipeczka";
        }else if (score >=60 && score< 80){
            useless = "\uD83D\uDCA9-Klocek";
        } else if (score>=80 && score<100) {
            useless = "\uD83D\uDC74-Słabeuszek";
        } else if (score>=100 && score<150) {
            useless = "\uD83D\uDE0E-Cosik-tam-zagrał";
        } else if (score>=150) {
            useless = "\uD83D\uDD25-Kubus-godlike-tier";
        }

        return useless;
    };

    public static String calculateSuppScore(ParticipantDto participant , long gameDuration){
        double minutes = Math.max(1, gameDuration / 60.0);
        int deaths = participant.getDeaths();
        int assists = participant.getAssists();
        int visionScore = participant.getVisionScore();
        int timeCCingOthers = participant.getTimeCCingOthers();
        int totalDamageShieldedOnTeammates = participant.getTotalDamageShieldedOnTeammates();
        int totalHealsOnTeammates = participant.getTotalHealsOnTeammates();
        double score = (assists * 50) +
                (visionScore * 30) +
                (timeCCingOthers * 15) +
                (totalDamageShieldedOnTeammates / 100.0) +
                (totalHealsOnTeammates / 100.0) -
                (deaths * 40);

        score = score / minutes;
        String useless = "";
        if(score < 60){
            useless = "\uD83D\uDC80-Cipeczka";
        }else if (score >=60 && score< 80){
            useless = "\uD83D\uDCA9-Klocek";
        } else if (score>=80 && score<100) {
            useless = "\uD83D\uDC74-Słabeuszek";
        } else if (score>=100 && score<150) {
            useless = "\uD83D\uDE0E-Cosik-tam-zagrał";
        } else if (score>150) {
            useless = "\uD83D\uDD25-Kubus-godlike-tier";
        }

        return useless;
    }
}
