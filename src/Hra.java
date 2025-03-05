import java.util.Scanner;

public class Hra {
    protected MapaMistnosti mapa;

    public Hra(MapaMistnosti mapa) {
        this.mapa = mapa;
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

    }
    public void presunHrace(){

    }
}
