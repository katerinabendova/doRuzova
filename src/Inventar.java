import java.util.ArrayList;
import java.util.List;

public class Inventar {
    private List<String> predmety;
    private static final int kapacita = 5;

    public Inventar(){
        this.predmety = new ArrayList<>();
    }

    public void pridejPredmet(String predmet){
        if (predmety.size() < kapacita){
            predmety.add(predmet);
            Konzole.vypis("predmet " + predmet + "byl pridan do inventare.");
        } else {
            Konzole.vypis("Inventar je uplne plny!");
        }
    }

    public void vypisInventare(){
        Konzole.vypis("Inventar: " + String.join(", ", predmety));
    }
}
