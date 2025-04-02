package postavy;

import hra.Inventar;
import mistnosti.Mistnost;
import predmety.Predmet;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Peadyn extends Postava {
    private Inventar inventar;
    private int zivoty;
    private List<Predmet> predmety;
    private Mistnost aktualniMistnost;
    private Set<Mistnost> mistnostUkolHotov;

    public Peadyn(String schopnost, String jmeno) {
        super(schopnost, jmeno);
        inventar = new Inventar();
        zivoty = 3;
        predmety = new ArrayList<>();
        mistnostUkolHotov = new HashSet<>();
     //   mistnostUkolHotov.add(new Mistnost("krajina"));

    }

    public Peadyn(Mistnost vychoziMistnost) {
        super("boj s dykou", "Peadyn");
        inventar = new Inventar();
        zivoty = 3;
        predmety = new ArrayList<>();
        mistnostUkolHotov = new HashSet<>();
     //   mistnostUkolHotov.add(new Mistnost("krajina"));
        setAktualniMistnost(vychoziMistnost);

    }

    public Inventar getInventar() {
        return inventar;
    }

    public int getZivoty() {
        return zivoty;
    }

    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

 public void setAktualniMistnost(Mistnost mistnost) {
        try {
            this.aktualniMistnost = mistnost;

            if (!mistnostUkolHotov.contains(mistnost)) {
                System.out.println("VSTUPUJES DO NOVE MISTNOSTI: " + mistnost.getNazev());

                mistnost.nactiUkol();
                mistnostUkolHotov.add(mistnost);
                System.out.println("ÚKOL V TÉTO MÍSTNOSTI BYL ZKONTROLOVÁN.");
            } else {
                System.out.println("V TÉTO MÍSTNOSTI UŽ JSI BYL(A), ÚKOL NENÍ TŘEBA ŘEŠIT.");
            }
        } catch (NullPointerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

/*
    private void spustUkol() {
        aktualniMistnost.maUkol();
        aktualniMistnost.getUkol();
        mistnostUkolHotov.add(aktualniMistnost);
        System.out.println("UKOL SPLNEN, UZ HO NEMUSIS RESIT.");
    }

 */

    public List<Predmet> getPredmety() {
        return predmety;
    }

    public void pridatPredmet(Predmet predmet) {
        predmety.add(predmet);
        System.out.println("PREDMET " + predmet.getNazev() + " BYL PRIDAN DO INVENTARE");
    }

    public void odebratPredmet(Predmet predmet) {
        if (predmety.contains(predmet)) {
            predmety.remove(predmet);
            System.out.println("PREDMET" + predmet.getNazev() + " BYL ODEBRAN Z INVENTARE");
        } else {
            System.out.println("TENTO PREDMET SE V INVENTARI NENACHAZI");
        }
    }

    @Override
    public void komunikuj() {
        System.out.println("JSEM HLAVNI POSTAVA ZA KTEROU HRAJES.");
    }
}
