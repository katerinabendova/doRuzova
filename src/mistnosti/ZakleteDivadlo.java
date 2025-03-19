package mistnosti;

import java.util.Random;
import java.util.Scanner;

public class ZakleteDivadlo extends MistnostSUkolem{
    public ZakleteDivadlo(String nazev) {
        super(nazev);
    }
    public void ukol(){
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int a = rd.nextInt(10)+1;
        int b = rd.nextInt(10)+1;
        boolean spravne;

        while (spravne = true) {
            System.out.println("Vyres priklad: " + a + " * " + b + " = ");
            int odpoved = sc.nextInt();
            if (odpoved == a * b) {
                spravne = true;
                System.out.println("Spravne! Dostavas diamantovy klic");
            } else {
                spravne = false;
                System.out.println("Spatne! Zkus to znovu");

            }
        }
    }

}