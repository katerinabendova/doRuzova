package hrac;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import postavy.Peadyn;


public class Konzole {

    private Scanner sc;
    private Set<String> navstiveneMistnosti;
    private boolean unikovaMistnostNactena;
    private Peadyn peadyn;
    private MapaMistnosti mapa;


    public Konzole() throws IOException {
        this.sc = new Scanner(System.in);
        this.navstiveneMistnosti = new HashSet<>();
        this.unikovaMistnostNactena = false;
        this.mapa = new MapaMistnosti("mistnosti.txt");
    }


    public void spustit(){
        System.out.println("Vitej ve hre Do ruzova!");
        if (mapa == null || mapa.getAktualniMistnost() == null ){
            System.out.println("Chyba. mapa mistnosti se nenacetla spravne");
            return;
        }

        while (true){
            mapa.zobrazAktualniMistnost();
            System.out.println("zadej prikaz");
            String prikaz = sc.nextLine().trim().toLowerCase();
            if (prikaz.equals("konec")){
                System.out.println("hra ukoncena");
                break;
            }
            mapa.jdi(prikaz);
        }
    }

    public static void vypis(String zprava){
        System.out.println(zprava);
    }


    public void zaznamenejMistnost(String nazev){
        navstiveneMistnosti.add(nazev);
        if (navstiveneMistnosti.size() == mapa.pocetMistnosti() -1){
            unikovaMistnostNactena = true;
            vypis("vyborne! konecne vidis cestu k unikove mistnosti!");
        }
    }
}
