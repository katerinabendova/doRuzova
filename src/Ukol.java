import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ukol {
    private String nazev;
    private String popis;
    public Ukol(String soubor) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader(soubor));
        this.nazev = rd.readLine();
        this.nazev = rd.readLine();
        rd.close();
    }

    public void zobrazUkol(){
        System.out.println("Ukol: " + nazev);
        System.out.println(popis);
    }
}
