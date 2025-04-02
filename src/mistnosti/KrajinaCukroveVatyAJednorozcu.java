package mistnosti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class KrajinaCukroveVatyAJednorozcu extends Mistnost {

    public KrajinaCukroveVatyAJednorozcu(String nazev) {
        super(nazev);
    }

    /**
     * nacita ukol v aktualni mistnosti a spusti vypraveni
     */
    @Override
    public void nactiUkol() throws FileNotFoundException {
        vypraveni();
    }

    /**
     * zobrazuje vypraveni pomoci nacitani ze souboru
     * @throws FileNotFoundException pokud soubor 'vypraveni.txt' neni nalezen
     */
    public void vypraveni() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("POKUD CHCES UKAZAT VYPRAVENI NAPIS 'vypraveni'.");
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