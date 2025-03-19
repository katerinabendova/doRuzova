package mistnosti;

import predmety.AtlasovaKouzelnaVarecka;
import predmety.VeritinDenik;

public class CernyAtelier extends MistnostSPredmetem{

    public CernyAtelier(String nazev) {
        super(nazev);
    }

    public void najdiPredmet(){
        pridatPredmet(new VeritinDenik("Veritin denik"));
        pridatPredmet(new AtlasovaKouzelnaVarecka("Atlasova kouzelna varecka"));
        System.out.println("Nasel jsi Veritin denik a Atlasovu varecku!");
    }
}
