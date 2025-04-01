package postavy;

public class Pruvodce extends Postava {
    public Pruvodce( String schopnost, String jmeno) {
        super(schopnost, jmeno);
    }

    public void dejNapovedu(){
        System.out.println(jmeno + ": " + schopnost);
    }
    @Override
    public void komunikuj() {
        dejNapovedu();
    }
}
