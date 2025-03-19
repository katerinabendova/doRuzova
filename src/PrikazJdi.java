import hrac.MapaMistnosti;

import java.util.Scanner;

public class PrikazJdi implements Prikaz{
    private MapaMistnosti mapa;

    public PrikazJdi(MapaMistnosti mapa) {
        this.mapa = mapa;
    }

    @Override
    public void proved() {
        System.out.println("Do jake mistnosti se chces presunout?");
        Scanner sc = new Scanner(System.in);
        String cil = sc.nextLine().trim().toLowerCase();
        mapa.jdi(cil);
    }
}
