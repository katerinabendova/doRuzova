package mistnosti;

import hra.Inventar;
import postavy.Peadyn;
import predmety.AtlasovaKouzelnaVarecka;
import predmety.VeritinDenik;

public class CernyAtelier extends Mistnost {
    private Inventar inventar;
    private Peadyn peadyn;

    public CernyAtelier(String nazev) {
        super(nazev);
    }

    /**
     * nacita ukol v aktualni mistnosti a spusti hledani predmetu
     */
    @Override
    public void nactiUkol() {
        najdiPredmet();
    }

    /**
     * hrac najde predmety v mistnosti a prida je do inventare
     */
    public void najdiPredmet(){
        pridatPredmet(new VeritinDenik("Veritin denik"));
        pridatPredmet(new AtlasovaKouzelnaVarecka("Atlasova kouzelna varecka"));
        System.out.println("NASEL JSI VERITIN DENIK A ATLASOVU VARECKU!");

        int zivoty = peadyn.getZivoty();

        if (inventar.obsahujePredmet("fotoalbum")){
            zivoty --;
            System.out.println("MAS VE SVEM INVENTARI AVINO FOTOALBUM. ODECITA SE TI JEDEN ZIVOT");
        }
        if (peadyn.getZivoty() == 0){
            System.out.println("UZ NEMAS ZIVOTY, HRA PRO TEBE KONCI");
            System.exit(0);
        }
    }
}
