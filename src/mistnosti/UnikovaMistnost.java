package mistnosti;

import hra.Inventar;

import java.io.FileNotFoundException;
import java.util.Set;


public class UnikovaMistnost extends Mistnost{

    public UnikovaMistnost(String nazev) {
        super(nazev);
    }

    /**
     * nacita ukol v aktualni mistnosti a spusti pokus o odemknuti mistnosti
     */
    @Override
    public void nactiUkol() throws FileNotFoundException {
      //  pokusOdemknout();
    }

    /**
     *  pokusi se odemknou unikovou mistnost na zaklade stavu inventare a splnenych ukolu
     * @param inventar inventar hrace, musi obsahovat potrebne predmety
     * @param navstiveneMistnosti vsechny ukoly v mistnostech musi byt splnene
     * @param pocetMistnosti vsechny mistnosti musi byt navstivene
     */
    public void pokusOdemknout(Inventar inventar, Set<String> navstiveneMistnosti, int pocetMistnosti) {
        if (inventar.odemkni(navstiveneMistnosti, pocetMistnosti)) {
            System.out.println("PROBOUZIS SE VYSPINKANA DO RUZOVA! GRATULUJI TI K USPESNEMU DOKONCENI HRY.");
            System.exit(0);
        } else {
            System.out.println("ZATIM NEMUZES ODEMKNOUT UNIKOVOU MISTNOST. NESPLNILA JSI VSECHNY UKOLY.");
        }
    }
}

