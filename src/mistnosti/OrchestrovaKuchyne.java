package mistnosti;

import predmety.AvinoFototalbum;
import predmety.StribrnaDyka;

public class OrchestrovaKuchyne extends MistnostSPredmetem{

    public OrchestrovaKuchyne(String nazev) {
        super(nazev);
    }

    public void najdiPredmet(){
        pridatPredmet(new StribrnaDyka("Stribrna dyka"));
        pridatPredmet(new AvinoFototalbum("Avino fotoalbum"));
        System.out.println("NASEL JSI STRIBRNOU DYKU A AVINO FOTOALBUM!");
    }
}
