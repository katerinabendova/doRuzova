package postavy;

public abstract class Postava {
    protected String jmeno;
    protected String schopnost;
    protected String predmet;
    protected int zivoty;

    public Postava(int zivoty, String schopnost, String predmet, String jmeno) {
        this.zivoty = zivoty;
        this.schopnost = schopnost;
        this.predmet = predmet;
        this.jmeno = jmeno;
    }

    public void predstavSe(){
        System.out.println("Ahoj! Jmenuji se: " + jmeno + ", má schopnost je: " + schopnost + "a můj předmět je: " + predmet);
    }
}
