import hra.MapaMistnosti;
import hra.SpravcePrikazu;
import mistnosti.Mistnost;
import postavy.Peadyn;

public class Hra {

    protected MapaMistnosti mapa;
    private Peadyn peadyn;
    private SpravcePrikazu spravce;

     public Hra(MapaMistnosti mapa) {
         this.mapa = mapa;
         this.spravce = new SpravcePrikazu();
         if (mapa != null) {
             Mistnost startovniMistnost = mapa.getStartovaciMistnost();
             if (startovniMistnost != null) {
                 this.peadyn = new Peadyn( startovniMistnost);
                 this.peadyn.setAktualniMistnost(startovniMistnost);
             } else {
                 System.out.println("Chyba: Startovní místnost je null!");
             }
         } else {
             System.out.println("Chyba: MapaMistnosti je null!");
         }
    }
    public void nastavAktualniMistnost(Mistnost mistnost) {
        if (peadyn != null) {
            peadyn.setAktualniMistnost(mistnost);
        } else {
            System.out.println("Chyba: Peadyn nebyl inicializován!");
        }
    }
    public Peadyn getPeadyn() {
        return peadyn;
    }


}

