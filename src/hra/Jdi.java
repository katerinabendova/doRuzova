package hra;

import mistnosti.Mistnost;
import postavy.Peadyn;

import java.util.Scanner;

public class Jdi extends Command {
    private Peadyn peadyn;

    public Jdi(MapaMistnosti mapa, Peadyn peadyn) {
        this.peadyn = peadyn;
    }

    /**
     * presun hrace do jine mistnosti
     * @return informuje hrace o presunu
     */
    @Override
    public String proved() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DO JAKE MISTNOSTI CHCES JIT?");
        String nazevMistnosti = scanner.nextLine().trim().toLowerCase();

        Mistnost novaMistnost = peadyn.getAktualniMistnost().getVychod(nazevMistnosti);
        if (novaMistnost != null) {
            peadyn.setAktualniMistnost(novaMistnost);
            return "PRESUNULA JSI SE DO MISTNOSTI " + novaMistnost.getNazev();
        }
        return "TATO MISTNOST NEEXISTUJE NEBO NENI PRISTUPNA.";
    }
    public Mistnost getAktualniMistnost() {
        return peadyn.getAktualniMistnost();
    }

    @Override
    public boolean konec() {
        return false;
    }
}
