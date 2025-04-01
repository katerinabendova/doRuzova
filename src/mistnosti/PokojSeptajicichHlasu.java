package mistnosti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PokojSeptajicichHlasu extends MistnostSUkolem{
    public PokojSeptajicichHlasu(String nazev) {
        super(nazev);
    }
    public void ukol(){
        List<String> radky = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("had.txt"))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                radky.add(radek);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        if (radky.isEmpty()) {
            System.out.println("V SOUBORU NMIC NENI.");
            return;
        }

        Random rd = new Random();
        boolean splneno = false;

        while (!splneno) {
            String vybranyRadek = radky.get(rd.nextInt(radky.size()));
            String[] cast = vybranyRadek.split(" ");

            if (cast.length < 2) {
                continue;
            }

            String textovyRetezec = cast[0];
            String hledaneSlovo = cast[1];

            System.out.println("TEXTOVY RETEZEC: " + textovyRetezec);

            Scanner sc = new Scanner(System.in);
            System.out.println("ZAPIS NALEZENE SLOVO: ");
            String odpoved = sc.nextLine().trim();


            if (odpoved.equalsIgnoreCase(hledaneSlovo)) {
                System.out.println("spravne");
                splneno = true;
            } else {
                System.out.println("spatne zkus to znovu");
            }
        }
    }
}
