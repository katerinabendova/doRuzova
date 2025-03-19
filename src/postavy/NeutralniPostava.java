package postavy;

import mistnosti.Mistnost;

public class NeutralniPostava extends Postava{
    private String predmet;
    public NeutralniPostava(String schopnost, String jmeno, String predmet) {
        super(schopnost, jmeno);
        this.predmet = predmet;
    }

    public void dejPredmet(){
        System.out.println(jmeno + "ti dava predmet" + predmet);
    }

    @Override
    public void komunikuj() {
        dejPredmet();
    }
}
