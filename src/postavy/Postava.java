package postavy;

import mistnosti.Mistnost;

public abstract class Postava {
    protected String jmeno;
    protected String schopnost;


    public Postava(String schopnost, String jmeno) {
        this.schopnost = schopnost;
        this.jmeno = jmeno;
    }

    public void predstavSe(){
        System.out.println("Ahoj! Jmenuji se: " + jmeno + ", má schopnost je: " + schopnost);
    }

    public abstract void komunikuj();

}
