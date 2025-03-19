package mistnosti;

import postavy.Postava;
import predmety.Predmet;

import java.util.*;

public class Mistnost {
    protected String nazev;
    protected Map<String, Mistnost> vychody;
    protected List<Postava> postavy;
    protected List<Predmet> predmety;

    public Mistnost(String nazev) {
        this.nazev = nazev;
        this.vychody = new HashMap<>();
        this.postavy = new ArrayList<>();
        this.predmety = new ArrayList<>();
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
}
