import hrac.Konzole;
import hrac.MapaMistnosti;
import postavy.Peadyn;

import java.util.Scanner;

public class Hra {
    protected MapaMistnosti mapa;
    private Peadyn peadyn;
    private SpravcePrikazu spravce;

    public Hra(MapaMistnosti mapa) {
        this.mapa = mapa;
        this.spravce = new SpravcePrikazu();
    }

    public void spustit() {
        Scanner scanner = new Scanner(System.in);
        String prikaz;

        while (true) {
            mapa.zobrazAktualniMistnost();
            System.out.print("Kam chceš jít? (zadej název místnosti) nebo 'konec': ");
            prikaz = scanner.nextLine().trim().toLowerCase();
            if (prikaz.equals("konec")) break;
            mapa.jdi(prikaz);
        }
    }
    public void vstupDoMistnosti(){
        Konzole.vypis("Nachazis se v mistnosti: ");
    }
    public void presunHrace(){

    }
}
