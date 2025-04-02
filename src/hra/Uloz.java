package hra;

import postavy.Peadyn;
import predmety.Predmet;

import java.util.Scanner;

public class Uloz extends Command{
    private Peadyn peadyn;
    private Inventar inventar;

    public Uloz (Peadyn peadyn) {
        this.peadyn = peadyn;
        inventar = new Inventar();
    }

    /**
     * ulozi predmet do inventare
     * @return informace o ulozeni
     */
    @Override
    public String proved() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("JAKY PREDMET CHCES ULOZIT?");
        String nazevPredmetu = scanner.nextLine().trim().toLowerCase();

        for (Predmet predmet : peadyn.getPredmety()) {
            if (predmet.getNazev().equalsIgnoreCase(nazevPredmetu)) {
                peadyn.pridatPredmet(predmet);
                return "ULOZILA JSI PREDMET: " + predmet.getNazev();
            }
        }
        return "TENTO PREDMET NEMAS V INVENTARI";
    }

    /**
     * urcuje, jestli hra konci nebo pokracuje
     * @return 'flase', pokud hra stale pokracuje
     */
    @Override
    public boolean konec() {
        return false;
    }
}
