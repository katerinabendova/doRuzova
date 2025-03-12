
public abstract class Postava {
    protected String jmeno;
    protected String schopnost;
    protected int zivoty;

    public Postava(int zivoty, String schopnost, String jmeno) {
        this.zivoty = zivoty;
        this.schopnost = schopnost;
        this.jmeno = jmeno;
    }

    public void predstavSe(){
        System.out.println("Ahoj! Jmenuji se: " + jmeno + ", má schopnost je: " + schopnost);
    }
}
