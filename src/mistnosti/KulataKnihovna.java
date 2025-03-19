package mistnosti;

import postavy.Verity;

import java.util.Random;
import java.util.Scanner;

public class KulataKnihovna extends MistnostSBojem{

    private Verity verity;

    public KulataKnihovna(String nazev) {
        super(nazev);
        this.verity = new Verity("niceni pomoci slov", "Verity", 7);
        this.pridatPostavu(verity);
    }

    public void boj(){
        System.out.println("Verity te vyziva do ciselneho boje");
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        while (true){
            int veritinoCislo = rd.nextInt(100)+1;
            System.out.println("Zadej sve cislo: ");
            int tveCislo = sc.nextInt();
            System.out.println("Verity zadala cislo: " + veritinoCislo);

            if (tveCislo > veritinoCislo){
                System.out.println("Vyhral jsi nad Verity");
                break;
            } else {
                System.out.println("Prohral jsi.");
                System.exit(0);
            }
        }
    }

}
