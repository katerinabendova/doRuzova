package mistnosti;

import hra.Inventar;
import postavy.Kai;
import postavy.Peadyn;
import predmety.KnihaMistnosti;
import java.util.Random;
import java.util.Scanner;

public class CernocernaTma extends MistnostSBojemAPredmetem{

    private Kai kai;
    private Peadyn peadyn;
    private Inventar inventar;


    public CernocernaTma(String nazev) {
        super(nazev);
        this.kai = new Kai("hod lanem", "Kai", 7);
        this.pridatPostavu(kai);
        //this.peadyn = new Peadyn("boj s dykou", "Peadyn");
    }

    public void bojSHracem() {
        System.out.println("POTKAVAS KAIE! MUSIS HO PORAZIT V SOUBOJI VYRESENIM 3 MATEMATICKYCH PRIKLADU.");
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int bodHrace = 0;
        int bodKaie = 0;

        if (inventar.obsahujePredmet("baterka")){
            System.out.println("DIKY BATERCE VIDIS NA CESTU A MUZES POKRACOVAT DAL!");
            while (peadyn.getZivoty() > 0) {

                while (bodHrace < 3 && bodKaie < 3) {
                    int a = rd.nextInt(30) + 1;
                    int b = rd.nextInt(30) + 1;
                    System.out.println("KOLIK JE " + a + "+" + b + "?");
                    int odpoved = sc.nextInt();

                    if (odpoved == a + b) {
                        bodHrace++;
                        System.out.println("SPRAVNE! ZISKAVAS BOD.");
                    } else {
                        bodKaie++;
                        System.out.println("SPATNE! BOD ZISKAVA KAI.");
                    }
                }
                if (bodHrace == 3) {
                    System.out.println("PORAZIL JSI KAIE!");
                } else {
                    System.out.println("KAI TE PORAZIL, ZKUS TO ZNOVU. MAS JESTE " + peadyn.getZivoty() + " ZIVOTU.");
                }
            } if (peadyn.getZivoty() == 0){
                System.out.println("PROHRAL JSI, HRA PRO TEBE KONCI");
                System.exit(0);
            }
        }else {
            System.out.println("NEMUZES POKRACOVAT DAL, NEMAS VE SVEM INVENTARI BATERKU");
        }
    }

    public void najdiPredmet(){
        this.pridatPredmet(new KnihaMistnosti("kniha mistnosti"));
        System.out.println("NASEL JSI KNIHU MISTNOSTI");
    }
}
