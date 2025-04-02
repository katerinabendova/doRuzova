package mistnosti;

import postavy.Peadyn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ZrcadlovaKomnata extends Mistnost {
    private Peadyn peadyn;

    public ZrcadlovaKomnata(String nazev) {
        super(nazev);
    }

    /**
     * nacita ukol v aktualni mistnosti a spusti ukol
     */
    @Override
    public void nactiUkol() throws FileNotFoundException {
        ukol();
    }

    /**
     * nacitani ukolu z textoveho souboru a nasledna kontrola spravne odpovedi
     * @throws FileNotFoundException pokud neni nalezen textovy soubor
     */
    public void ukol() throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader("znaky.txt"))) {
            String radek = br.readLine();
            boolean spravne;
            int zivoty = peadyn.getZivoty();

            while (spravne = true) {
                if (radek != null) {
                    String[] cast = radek.split(" ");
                    String textovyRetezec = cast[0];
                    String spravnaOdpoved = cast[1];

                    System.out.println("V TEXTOVEM RETEZCI NAJDI JINY ZNAK: " + textovyRetezec);
                    System.out.println("ZADEJ SVOU ODPOVED: ");
                    Scanner sc = new Scanner(System.in);
                    String odpoved = sc.nextLine().trim();
                    if (odpoved.equalsIgnoreCase(spravnaOdpoved)) {
                        zivoty ++;
                        spravne = true;
                        System.out.println("SPRAVNE, ZISKAVAS 3 ZIVOTY NAVIC!");
                    } else {
                        spravne = false;
                        System.out.println("SPATNE, ZKUS TO ZNOVU.");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
