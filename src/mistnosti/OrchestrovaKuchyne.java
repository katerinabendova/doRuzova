package mistnosti;

import predmety.AvinoFototalbum;
import predmety.StribrnaDyka;

public class OrchestrovaKuchyne extends Mistnost {

    public OrchestrovaKuchyne(String nazev) {
        super(nazev);
    }

    /**
     * nacita ukol v aktualni mistnosti a spusti hleddani predmetu
     */
    @Override
    public void nactiUkol() {
        najdiPredmet();
    }

    /**
     * prida do inventare 2 nove predmety
     */
    public void najdiPredmet(){
        pridatPredmet(new StribrnaDyka("Stribrna dyka"));
        pridatPredmet(new AvinoFototalbum("Avino fotoalbum"));
        System.out.println("NASEL JSI STRIBRNOU DYKU A AVINO FOTOALBUM!");
    }
}
