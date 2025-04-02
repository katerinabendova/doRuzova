package hra;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Inventar {
    private List<String> predmety;
    private static final int kapacita = 5;

    public Inventar(){
        this.predmety = new ArrayList<>();
    }

    /**
     * pokud neni invenat plny, prida do nej predmet
     * @param predmet nazev predmetu, ktery se ma do invenatre pridat
     */
    public void pridejPredmet(String predmet){
        if (predmety.size() < kapacita){
            predmety.add(predmet);
            Konzole.vypis("PREDMET '" + predmet + "' BYL PRIDAN DO INVENTARE.");
        } else {
            Konzole.vypis("INVENTAR JE PLNY!");
        }
    }

    /**
     * odebirani predmetu z invenatre
     * @param predmet nazev predmetu, ktery se ma z invenatre odebrat
     */
    public void odeberPredmet(String predmet){
        if (predmety.remove(predmet)){
            Konzole.vypis("PREDMET '" + predmet + "' BYL ODEBRAN Z INVENTARE.");
        }else {
            Konzole.vypis("TENTO PREDMET SE V INVENTARI NENACHAZI.");
        }
    }

    /**
     * vysype inventar
     */
    public void vysypatInvetar(){
        if (predmety.size() <= kapacita){
            predmety.clear();
        }
    }

    /**
     * vypis obsahu inventare
     */
    public void vypisInventare(){
        Konzole.vypis("OBSAH INVENTARE: " + String.join(", ", predmety));
    }

    public boolean obsahujePredmet(String nazev){
        return predmety.contains(nazev);
    }

    /**
     * odemknuti mistnosti na zaklade splnenzch podminek
     * @param navstiveneMistnosti jiz navstivene mistnosti
     * @param pocetMistnosti celkovy pocet mistnosti
     * @return pokud jsou splneny podminky, mistnost se odemkne
     */
    public boolean odemkni(Set<String> navstiveneMistnosti, int pocetMistnosti){
        if (!obsahujePredmet("diamantovy klic")){
            System.out.println("NEMAS DIAMANTOVY KLIC.");
            return false;
        } if (navstiveneMistnosti.size() < pocetMistnosti){
            System.out.println("JESTE JSI NENAVSTIVILA VSECHNY MISTNOSTI");
            return false;
        } else {
            System.out.println("UNIKOVA MISTNOST JE NACTENA.");
            return true;
        }

    }
}
