package mistnosti;

import hra.Inventar;
import hra.Ukol;
import postavy.Postava;
import predmety.Predmet;

import java.util.*;

public class Mistnost {
    protected String nazev;
    protected Map<String, Mistnost> vychody;
    protected List<Postava> postavy;
    protected List<Predmet> predmety;
    protected Ukol ukol;
    protected boolean specialniPodminka;

    public Mistnost(String nazev) {
        this.nazev = nazev;
        this.vychody = new HashMap<>();
        this.postavy = new ArrayList<>();
        this.predmety = new ArrayList<>();
        this.specialniPodminka = false;
    }

    public void pridatVychod(String smer, Mistnost mistnost) {
        vychody.put(smer, mistnost);
    }

    public Mistnost getVychod(String smer) {
        return vychody.get(smer);
    }

    public String getNazev() {
        return nazev;
    }
    public Ukol getUkol() {
        return ukol;
    }


    public Set<String> getMozneVychody(){
        return vychody.keySet();
    }

    public void pridatPostavu(Postava postava){
        postavy.add(postava);
    }
    public void pridatPredmet(Predmet predmet){
        predmety.add(predmet);
    }

    public List<Postava> getPostavy() {
        return postavy;
    }

    public Map<String, Mistnost> getVychody() {
        return vychody;
    }
    public void odeberPredmet(Predmet predmet) {
        if (predmety.contains(predmet)) {
            predmety.remove(predmet);
            System.out.println("PREDMET " + predmet.getNazev() + " BYL ODEBRAN Z MISTNOSTI.");
        } else {
            System.out.println("TENTO PREDMET NENI V MISTNOSTI.");
        }
    }

    public boolean muzeVstoupit(Inventar inventar) {
        if (nazev.equals("knihovna") && !inventar.obsahujePredmet("Veritin denik")) {
            System.out.println("NEMUZES VSTOUPIT BEZ VERITINA DENIKU.");
            return false;
        }
        return true;
    }
    public void zobrazMistnost() {
        System.out.println("NACHAZIS SE V MISTNOSTI: " + nazev);
        if (ukol != null) {
            ukol.zobrazUkol();
            Scanner sc = new Scanner(System.in);
            System.out.println("ZADEJ SVOU ODPOVED:");
            String odpoved = sc.nextLine();
            spustitUkol(odpoved);
        }  else {
            System.out.println("V TETO MISTNOSTI NENI ZADNY UKOL.");
        }
            for (Postava postava : postavy) {
                System.out.println("POTKAVAS: " + postava.getJmeno());
                postava.komunikuj();
            }
        }

    public void spustitUkol(String odpoved) {
        if (ukol != null && ukol.overOdpoved(odpoved)) {
            System.out.println("UKOL SPLNEN");
        } else {
            System.out.println("SPATNE, HRA PRO TEBE KONCI.");
            System.exit(0);
        }
    }

    public boolean maUkol() {
        return ukol != null;
    }
    public List<Predmet> getPredmety() {
        return predmety;
    }



}
