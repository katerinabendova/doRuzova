package mistnosti;

import postavy.Kai;
import predmety.KnihaMistnosti;
import java.util.Random;
import java.util.Scanner;

public class CernocernaTma extends MistnostSBojemAPredmetem{

    private Kai kai;


    public CernocernaTma(String nazev) {
        super(nazev);
        this.kai = new Kai("hod lanem", "Kai", 7);
        this.pridatPostavu(kai);
    }

    public void bojSHracem(){
        System.out.println("Potkavas Kaie! musis ho porazit vyresenim 3 matematickych prikladu.");
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int bodHrace = 0;
        int bodKaie = 0;

        while (bodHrace < 3 && bodKaie < 3){
            int a = rd.nextInt(30)+1;
            int b= rd.nextInt(30)+1;
            System.out.println("Kolik je " + a + "+" + b + "?");
            int odpoved = sc.nextInt();

            if (odpoved == a+b){
                bodHrace ++;
                System.out.println("Spravne! Ziskavas bod");
            } else {
                bodKaie ++;
                System.out.println("spatne! bod ziskava Kai");
            }
        }
        if (bodHrace == 3){
            System.out.println("Porazil jsi Kaie!");
        }
        else {
            System.out.println("Kai te porazil. hra pro tebe konci");
            System.exit(0);
        }
    }

    public void najdiPredmet(){
        this.pridatPredmet(new KnihaMistnosti("kniha mistnosti"));
        System.out.println("nasel jsi knihu mistnosti");
    }
}
