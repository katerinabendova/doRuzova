package mistnosti;

import hra.Inventar;
import postavy.Postava;
import predmety.Predmet;

import java.io.FileNotFoundException;
import java.util.*;

public class Mistnost {
    protected String nazev;
    protected Map<String, Mistnost> vychody;
    protected List<Postava> postavy;
    protected List<Predmet> predmety;
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

    /**
     * overuje, zda hrac muze vstoupit do mistnosti
     * @param inventar inventar hrace, ktery obsahuje seznam predmetu
     * @return 'true', pokud hrac muze vstoupit, jinak 'false'
     */
    public boolean muzeVstoupit(Inventar inventar) {
        if (nazev.equals("knihovna") && !inventar.obsahujePredmet("Veritin denik")) {
            System.out.println("NEMUZES VSTOUPIT BEZ VERITINA DENIKU.");
            return false;
        }
        return true;
    }

    public void nactiUkol() throws FileNotFoundException {
    }

}
