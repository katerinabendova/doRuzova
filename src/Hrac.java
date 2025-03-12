import postavy.Postava;


public class Hrac extends Postava {
    private Inventar inventar;


    public Hrac(int zivoty, String schopnost, String jmeno) {
        super(zivoty, schopnost, jmeno);
        this.inventar = new Inventar();
    }

    public Inventar getInventar(){
        return inventar;
    }
}
