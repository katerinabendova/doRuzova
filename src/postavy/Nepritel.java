package postavy;

public class Nepritel extends Postava{
    private int sila;

    public Nepritel(String schopnost, String jmeno, int sila) {
        super(schopnost, jmeno);
        this.sila = sila;
    }

    public void bojuj(){
        System.out.println(jmeno + " S TEBOU CHCE BOJOVAT, SILA: " + sila);
    }

    @Override
    public void komunikuj() {
        bojuj();
    }
}
