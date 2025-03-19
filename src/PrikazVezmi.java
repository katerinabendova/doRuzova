import postavy.Peadyn;

import java.util.Scanner;

public class PrikazVezmi implements Prikaz{
    private Peadyn peadyn;
    private String predmet;

    public PrikazVezmi(Peadyn peadyn, String predmet) {
        this.peadyn = peadyn;
        this.predmet = predmet;
    }

    @Override
    public void proved() {
        peadyn.getInventar().pridejPredmet(predmet);
    }
}
