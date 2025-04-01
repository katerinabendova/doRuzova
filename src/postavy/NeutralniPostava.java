package postavy;

public class NeutralniPostava extends Postava{
    private String predmet;
    public NeutralniPostava(String schopnost, String jmeno, String predmet) {
        super(schopnost, jmeno);
        this.predmet = predmet;
    }

    public void dejPredmet(){
        System.out.println(jmeno + " TI DAVA PREDMET " + predmet);
    }

    @Override
    public void komunikuj() {
        dejPredmet();
    }
}
