package com.example.uslessgg.models;

import java.util.HashMap;
import java.util.Map;

public class SummonerSpells {
    private Map<Integer,String> spellIdToName = new HashMap<>();

    @Override
    public String toString() {
        return "SummonerSpells{" +
                "spellIdToName=" + spellIdToName +
                '}';
    }

    public SummonerSpells(){
        spellIdToName.put(1, "SummonerBoost");
        spellIdToName.put(3, "SummonerExhaust");
        spellIdToName.put(4, "SummonerFlash");
        spellIdToName.put(6, "SummonerHaste");
        spellIdToName.put(7, "SummonerHeal");
        spellIdToName.put(11, "SummonerSmite");
        spellIdToName.put(12, "SummonerTeleport");
        spellIdToName.put(13, "SummonerMana");
        spellIdToName.put(14, "SummonerDot");
        spellIdToName.put(21, "SummonerBarrier");
        spellIdToName.put(2202, "SummonerCherryHold");
        spellIdToName.put(2201, "SummonerCherryFlash");
    }

    public Map<Integer, String> getSpellIdToName() {
        return spellIdToName;
    }

    public String getNameById(int SpellId){
        return this.spellIdToName.get(SpellId);
    }
}
