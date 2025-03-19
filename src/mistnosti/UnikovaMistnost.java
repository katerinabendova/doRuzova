package mistnosti;

import hrac.Inventar;

import java.util.Set;


public class UnikovaMistnost extends Mistnost{

    public UnikovaMistnost(String nazev) {
        super(nazev);
    }
    public void pokusOdemknout(Inventar inventar, Set<String> navstiveneMistnosti, int pocetMistnosti) {
        if (inventar.odemkni(navstiveneMistnosti, pocetMistnosti)) {
            System.out.println("probouzis se vyspanej do ruzova! gratuluji k vyhre");
            System.exit(0);
        } else {
            System.out.println("zatim nemuzes odemknout unikovou mistnost. asi jsi nesplnil vsechny podminky");
        }
    }
}

