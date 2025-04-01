package mistnosti;

import hra.Inventar;

import java.util.Set;


public class UnikovaMistnost extends Mistnost{

    public UnikovaMistnost(String nazev) {
        super(nazev);
    }

    public void pokusOdemknout(Inventar inventar, Set<String> navstiveneMistnosti, int pocetMistnosti) {
        if (inventar.odemkni(navstiveneMistnosti, pocetMistnosti)) {
            System.out.println("PROBOUZIS SE VYSPINKANA DO RUZOVA! GRATULUJI TI K USPESNEMU DOKONCENI HRY.");
            System.exit(0);
        } else {
            System.out.println("ZATIM NEMUZES ODEMKNOUT UNIKOVOU MISTNOST. NESPLNILA JSI VSECHNY UKOLY.");
        }
    }
}

