package hra;

import mistnosti.Mistnost;
import postavy.Peadyn;
import predmety.Predmet;

import java.util.Scanner;

public class Uloz extends Command{
    private Peadyn peadyn;

    public Uloz (Peadyn peadyn) {
        this.peadyn = peadyn;
    }

    @Override
    public String proved() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("JAKY PREDMET CHCES ULOZIT?");
        String nazevPredmetu = scanner.nextLine().trim().toLowerCase();

        for (Predmet predmet : peadyn.getPredmety()) {
            if (predmet.getNazev().equalsIgnoreCase(nazevPredmetu)) {
                peadyn.odebratPredmet(predmet);
                return "ULAOZILA JSI PREDMET: " + predmet.getNazev();
            }
        }
        return "TENTO PREDMET NEMAS V INVENTARI";
    }

    @Override
    public boolean konec() {
        return false;
    }
}

//kdyz vezmu predmet tak se automaticky ulozi do inventare