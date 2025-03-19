package postavy;

import hrac.Inventar;
import mistnosti.Mistnost;

public class Peadyn extends Postava{
    private Inventar inventar;

    public Inventar getInventar(){
        return inventar;
    }
    @Override
    public void komunikuj() {
        System.out.println("Jsem hlavní postava Peadyn a procházím tímto snem.");
    }


    public Peadyn(String schopnost, String jmeno){
        super("boj s dykou", "Peadyn");
        this.inventar = new Inventar();
    }
}
