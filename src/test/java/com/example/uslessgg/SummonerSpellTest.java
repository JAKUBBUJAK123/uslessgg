package com.example.uslessgg;

import com.example.uslessgg.models.SummonerSpells;
import com.example.uslessgg.models.matchHistory.ParticipantDto;
import org.junit.jupiter.api.Test;

public class SummonerSpellTest {


    @Test
    void isSpellsLoad(){
        SummonerSpells summonerSpells = new SummonerSpells();
        System.out.println(summonerSpells.getNameById(3));
    }

    @Test
    void isParticipantWorking(){
        ParticipantDto participantDto = new ParticipantDto();
        System.out.println(participantDto.getSummonerSpells().getNameById(1));
    }
}
