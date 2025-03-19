package mistnosti;

import predmety.AtlasovaKouzelnaVarecka;
import predmety.AvinoFototalbum;
import predmety.StribrnaDyka;

public class OrchestrovaKuchyne extends MistnostSPredmetem{

    public OrchestrovaKuchyne(String nazev) {
        super(nazev);
    }

    public void najdiPredmet(){
        pridatPredmet(new StribrnaDyka("Stribrna dyka"));
        pridatPredmet(new AvinoFototalbum("Avino fotoalbum"));
        System.out.println("Nasel jsi stribrnou dyku a Avino fotoalbum!");
    }
}
