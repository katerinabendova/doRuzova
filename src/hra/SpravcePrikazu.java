package hra;

import java.util.HashMap;
import java.util.Map;

public class SpravcePrikazu {
    private Map<String, Prikaz> prikazy;

    public SpravcePrikazu(){
        prikazy = new HashMap<>();
    }

    public void zapisPrikaz(String nazev, Prikaz prikaz){
        prikazy.put(nazev, prikaz);
    }

    public void provedPrikaz(String nazev){
        Prikaz prikaz = prikazy.get(nazev);
        if (prikaz != null){
            prikaz.proved();
        } else {
            System.out.println("PRIKAZ JE NEPLATNY.");
        }
    }
    public boolean maPrikaz(String nazev){
        return prikazy.containsKey(nazev);
    }
}
