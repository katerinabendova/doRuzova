package hra;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Vypravej extends Command{

    /**
     * urcuje, jestli hra konci nebo pokracuje
     * @return 'flase', pokud hra stale pokracuje
     */
    @Override
    public boolean konec() {
        return false;
    }

    /**
     * nacita vypraveni z textoveho souboru
     * @return vypraveni
     */
    @Override
    public String proved() {
            StringBuilder pribeh = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader("vypraveni.txt"))) {
                String radek;
                while ((radek = br.readLine()) != null) {
                    pribeh.append(radek).append("\n");
                }
            } catch (IOException e) {
                return "NEPODARILO SE NACIST VYPRAVENI.";
            }
            return pribeh.toString();
    }
}
