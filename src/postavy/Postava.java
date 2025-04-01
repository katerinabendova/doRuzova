package postavy;

public abstract class Postava {
    protected String jmeno;
    protected String schopnost;


    public Postava(String schopnost, String jmeno) {
        this.schopnost = schopnost;
        this.jmeno = jmeno;
    }

    public void predstavSe(){
        System.out.println("AHOJ! ME JMENO JE: " + jmeno + ", MA SCHOPNOST JE: " + schopnost);
    }

    public String getJmeno() {
        return jmeno;
    }

    public abstract void komunikuj();
}
