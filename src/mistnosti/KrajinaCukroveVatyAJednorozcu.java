package mistnosti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class KrajinaCukroveVatyAJednorozcu extends NeutralniMistnost {

    public KrajinaCukroveVatyAJednorozcu(String nazev) {
        super(nazev);
    }

    public void vypraveni() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("pokud chces zobrazit vypraveni napis 'vypraveni'");
        String vstup = sc.nextLine().trim().toLowerCase();

        if (vstup.equals("vypraveni")) {
            try (BufferedReader br = new BufferedReader(new FileReader("vypraveni.txt"))) {
                String radek;
                while ((radek = br.readLine()) != null) {
                    System.out.println(radek);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}