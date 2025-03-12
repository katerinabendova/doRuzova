import java.util.Scanner;

public class PrikazVezmi implements Prikaz{
    private Hrac hrac;

    public PrikazVezmi(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public void proved() {
        System.out.println("Jaky predmet chces sebrat?");
        Scanner sc = new Scanner(System.in);
        String predmet = sc.nextLine().trim().toLowerCase();
        hrac.getInventar().pridejPredmet(predmet);

    }
}
