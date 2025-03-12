import java.io.IOException;
import java.util.Scanner;

public class Konzole {

    private Scanner sc;
    private MapaMistnosti mapa;
    private Hrac hrac;
    private SpravcePrikazu spravce;

    public Konzole() {
        this.sc = new Scanner(System.in);
    }


    public void spustit(){
        try{
            mapa = new MapaMistnosti("mistnosti.txt");
            hrac = new Hrac(10, "boj s dykou",  "Peadyn");
            spravce = new SpravcePrikazu();
            herniSmycka();
            inicializujPrikaz();

        } catch (IOException e) {
            vypis("Chyba pri nacitani mistnosti: " + e.getMessage());
        }
    }

    private void inicializujPrikaz(){
        spravce.zapisPrikaz("jdi", new PrikazJdi(mapa));
        spravce.zapisPrikaz("vezmi", new PrikazVezmi(hrac));
    }

    private void herniSmycka(){
        while (true){
            mapa.zobrazAktualniMistnost();
            vypis("Zadej prikaz: ");
            String prikaz = nactiVstup();
            if (prikaz.equals("konec")) break;;
            spravce.provedPrikaz(prikaz);
        }
    }

    public static void vypis(String zprava){
        System.out.println(zprava);
    }

    public String nactiVstup(){
        return sc.nextLine().trim().toLowerCase();
    }
}
