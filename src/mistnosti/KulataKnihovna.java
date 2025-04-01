package mistnosti;

import postavy.Peadyn;
import postavy.Verity;

import java.util.Random;
import java.util.Scanner;

public class KulataKnihovna extends MistnostSBojem{

    private Verity verity;
    private Peadyn peadyn;

    public KulataKnihovna(String nazev) {
        super(nazev);
        this.verity = new Verity("niceni pomoci slov", "Verity", 7);
        this.pridatPostavu(verity);
        this.peadyn = new Peadyn( this);
    }

    public void boj() {
        System.out.println("VERITY TE VYZIVA DO CISELNEHO SOUBOJE! MUSIS ZADAT VETSI CISLO NEZ ONA.");
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        while (peadyn.getZivoty() != 0) {
            while (true) {
                int veritinoCislo = rd.nextInt(100) + 1;
                System.out.println("ZADEJ SVE CISLO: ");
                int tveCislo = sc.nextInt();
                System.out.println("VERITY ZADALA CISLO: " + veritinoCislo);

                if (tveCislo > veritinoCislo) {
                    System.out.println("VYHRAL JSI NAD VERITY");
                    break;
                } else {
                    System.out.println("VERITY TE PORAZILA, ZKUS TO JESTE JEDNOU. ZBYVA TI " + peadyn.getZivoty() + " ZIVOTU.");
                }
            }
        } if (peadyn.getZivoty() == 0){
            System.out.println("VERITY TE PORAZILA, HRA PRO TEBE KONCI.");
            System.exit(0);
        }
    }

}
