package hra;
import java.io.IOException;
import java.util.*;

import mistnosti.Mistnost;
import postavy.Peadyn;


public class Konzole {
    private Scanner sc;
    private Set<String> navstiveneMistnosti;
    private Peadyn peadyn;
    private MapaMistnosti mapa;
    private Mistnost aktualniMistnost;
    private Map<String, Command> prikazy;

    public Konzole() throws IOException {
        sc = new Scanner(System.in);
        mapa = new MapaMistnosti("mistnosti.txt");
        mapa.setAktualniMistnost(new Mistnost("krajina"));
        peadyn = new Peadyn(mapa.getAktualniMistnost());
        prikazy = new HashMap<>();
        inicializujPrikazy();
    }

    public void inicializujPrikazy(){
        prikazy.put("jdi", new Jdi(peadyn));
        prikazy.put("ukaz mapu", new UkazMapu());
        prikazy.put("uloz", new Uloz(peadyn));
        prikazy.put("vypravej", new Vypravej());
    }


    public void spustit() {
        System.out.println("VITEJ VE HRE DORUZOVA!\n");
        if (mapa == null || mapa.getAktualniMistnost() == null) {
            System.out.println("CHYBA, MAPA MISTNOSTI SE NACETLA NESPRAVNE.");
            return;
        }
        boolean konecHry = false;
        while (!konecHry) {
                mapa.zobrazAktualniMistnost();
                System.out.println("CO CHCES DELAT? MAS NA VYBER Z PRIKAZU: 'jdi', 'uloz', 'vypravej', 'ukaz mapu', 'konec'");
                String prikaz = sc.nextLine().trim().toLowerCase();

                if (prikaz.equals("konec")) {
                    System.out.println("HRA BYLA UKONCENA");
                    konecHry = true;
                } else {
                    if (prikazy.containsKey(prikaz)) {
                        prikazy.get(prikaz).proved();
                        aktualniMistnost = mapa.getAktualniMistnost();
                    } else {
                        System.out.println("NEPLATNY PRIKAZ");
                    }
                    aktualniMistnost = mapa.getAktualniMistnost();
                }
        }
    }
    public void zpracujPrikaz(String prikaz) {
        prikaz = prikaz.trim().toLowerCase();

        if (prikaz.equals("jdi")) {
            System.out.println("KAM SE CHCES PRESUNOUT? ");
            String cil = sc.nextLine().trim().toLowerCase();
            mapa.jdi(cil);
            peadyn.setAktualniMistnost(mapa.getAktualniMistnost());
        } else if (prikaz.equals("konec")) {
            System.out.println("HRA BYLA UKONCENA.");
            System.exit(0);
        } else if (prikazy.containsKey(prikaz)) {
            prikazy.get(prikaz).proved();
            aktualniMistnost = mapa.getAktualniMistnost();
        } else {
            System.out.println("NAZNAMY PRIKAZ.");
        }
    }

    public static void vypis(String zprava) {
        System.out.println(zprava);
    }

}