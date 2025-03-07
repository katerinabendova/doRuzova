package mistnosti;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mistnost {
    protected String nazev;
    protected Map<String, Mistnost> vychody;

    public Mistnost(String nazev) {
        this.nazev = nazev;
        this.vychody = new HashMap<>();
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
}
