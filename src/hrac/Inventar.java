package hrac;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Inventar {
    private List<String> predmety;
    private static final int kapacita = 5;

    public Inventar(){
        this.predmety = new ArrayList<>();
    }

    public void pridejPredmet(String predmet){
        if (predmety.size() < kapacita){
            predmety.add(predmet);
            Konzole.vypis("predmet " + predmet + "byl pridan do inventare.");
        } else {
            Konzole.vypis("hrac.Inventar je uplne plny!");
        }
    }

    public void odeberPredmet(String predmet){
        if (predmety.remove(predmet)){
            Konzole.vypis("predmet: " + predmet + " bzl odebran z inventare.");
        }else {
            Konzole.vypis("Tento predmet se v inventari nenachazi");
        }
    }

    public void vysypatInvetar(){
        if (predmety.size() <= kapacita){
            predmety.clear();
        }
    }

    public void vypisInventare(){
        Konzole.vypis("hrac.Inventar: " + String.join(", ", predmety));
    }

    public boolean obsahujePredmet(String nazev){
        return predmety.contains(nazev);
    }

    public boolean odemkni(Set<String> navstiveneMistnosti, int pocetMistnosti){
        if (!obsahujePredmet("diamantovy klic")){
            System.out.println("Nemas diamantovy klic");
            return false;
        } if (navstiveneMistnosti.size() < pocetMistnosti){
            System.out.println("Jeste jsi nanevstivil vsechny mistnosti");
            return false;
        } else {
            System.out.println("Unikova mistnost je odemcena");
            return true;
        }

    }


}
