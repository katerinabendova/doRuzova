import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ukol {
    private String nazev;
    private String popis;
    private String odpoved;

    public Ukol(String soubor) throws IOException {
        List<String> radky = new ArrayList<>();
        try(BufferedReader rd = new BufferedReader(new FileReader(soubor))) {
            String radek;
            while ((radek = rd.readLine()) != null){
                radky.add(radek);
            }
        }
        int nahodnyIndex = new Random().nextInt(radky.size() / 2) * 2;
        this.nazev = radky.get(nahodnyIndex);
        this.popis = radky.get(nahodnyIndex + 1);
        this.odpoved = radky.get(nahodnyIndex + 2);
    }

    public boolean overOdpoved(String vstup){
        return vstup.equalsIgnoreCase(odpoved);
    }

    public void zobrazUkol(){
        System.out.println("Ukol: " + nazev);
        System.out.println(popis);
    }
}
