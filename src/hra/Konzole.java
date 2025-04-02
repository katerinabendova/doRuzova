package hra;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import mistnosti.Mistnost;
import postavy.Peadyn;


public class Konzole {
    private Scanner sc;
    private Peadyn peadyn;
    private MapaMistnosti mapa;
    private Map<String, Command> prikazy;

    /**
     * konstruktor
     * @throws IOException pokud nastane problem pri nacitani souboru
     */
    public Konzole() throws IOException {
        sc = new Scanner(System.in);
        mapa = new MapaMistnosti("mistnosti.txt");
        Mistnost vychoziMistnost = mapa.getStartovaciMistnost();
        mapa.nastavAktualniMistnost(vychoziMistnost.getNazev());
        peadyn = new Peadyn(mapa.getAktualniMistnost());
        prikazy = new HashMap<>();
        inicializujPrikazy();
    }

    /**
     * inicializuje mapu prikazu pro hru
     */
    public void inicializujPrikazy(){
        prikazy.put("jdi", new Jdi(mapa, peadyn));
        prikazy.put("ukaz mapu", new UkazMapu());
        prikazy.put("uloz", new Uloz(peadyn));
        prikazy.put("vypravej", new Vypravej());
    }

    /**
     * spusteni herni smycky
     */
    public void spustit() throws FileNotFoundException {
        System.out.println("VITEJ VE HRE DORUZOVA!\n");

        UkazMapu ukazMapu = new UkazMapu();
        ukazMapu.proved();

        if (mapa == null || mapa.getAktualniMistnost() == null) {
            System.out.println("CHYBA, MAPA MISTNOSTI SE NACETLA NESPRAVNE.");
            return;
        }

        boolean konecHry = false;

        while (!konecHry) {
            System.out.println("NACHAZIS SE V MISTNOSTI: " + peadyn.getAktualniMistnost().getNazev());
            peadyn.getAktualniMistnost().nactiUkol(); //tohle by mi melo nacit ukol, ale proc to sakra nefunguje!?

            System.out.println("CO CHCES DELAT? MAS NA VYBER Z PRIKAZU: 'jdi', 'uloz', 'vypravej', 'ukaz mapu', 'konec'");
            String prikaz = sc.nextLine().trim().toLowerCase();

                if (prikaz.equals("konec")) {
                    System.out.println("HRA BYLA UKONCENA");
                    konecHry = true;
                } else {
                    if (prikazy.containsKey(prikaz)) {
                        prikazy.get(prikaz).proved();

                        if (prikazy.get(prikaz) instanceof Jdi) {
                            peadyn.setAktualniMistnost(((Jdi) prikazy.get(prikaz)).getAktualniMistnost());
                            peadyn.getAktualniMistnost().nactiUkol();
                        }
                    } else {
                        System.out.println("NEPLATNY PRIKAZ");
                    }
                }
        }
    }

    /**
     * vypise zpravu do konzole
     * @param zprava textova zprava, ktera ma byt zobrazena
     */
    public static void vypis(String zprava) {
        System.out.println(zprava);
    }

}