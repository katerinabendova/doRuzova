import postavy.Peadyn;

import java.util.Scanner;

public class PrikazPust implements Prikaz{
    private Peadyn peadyn;
    private String predmet;

    public PrikazPust(Peadyn peadyn, String predmet) {
        this.peadyn = peadyn;
        this.predmet = predmet;
    }

    @Override
    public void proved() {
        peadyn.getInventar().odeberPredmet(predmet);
    }
}
