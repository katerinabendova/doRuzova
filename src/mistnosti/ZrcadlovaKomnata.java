package mistnosti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ZrcadlovaKomnata extends MistnostSUkolem{

    public ZrcadlovaKomnata(String nazev) {
        super(nazev);
    }

    public void ukol() throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader("znaky.txt"))){
            String radek = br.readLine();
            if (radek != null){
                String[] cast = radek.split(" ");
                String textovyRetezec = cast[0];
                String spravnaOdpoved = cast[1];

                System.out.println("V textovemk retezci najdi jiny znak: " + textovyRetezec);
                System.out.println("Zadej svou odpoved: ");
                Scanner sc = new Scanner(System.in);
                String odpoved = sc.nextLine().trim();
                if (odpoved.equalsIgnoreCase(spravnaOdpoved)){
                    System.out.println("Spravne ziskavas 3 zivoty navic!");
                } else {
                    System.out.println("Spatne! zadal jsi spatnou odpoved");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
