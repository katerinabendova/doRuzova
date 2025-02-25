import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapaMistnosti {
    private Map<String, Mistnost> mistnosti;
    private Mistnost aktualniMistnost;

    public MapaMistnosti(String soubor) throws IOException {
        mistnosti = new HashMap<>();
        nactiZeSouboru(soubor);
    }

    private void nactiZeSouboru(String soubor) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(soubor));
        String radek;
        while ((radek = br.readLine()) != null) {
            String[] casti = radek.split(",");
            String nazev = casti[0];
            mistnosti.putIfAbsent(nazev, new Mistnost(nazev));

            for (int i = 1; i < casti.length; i += 2) {
                String smer = casti[i];
                String cil = casti[i + 1];
                mistnosti.putIfAbsent(cil, new Mistnost(cil));
                mistnosti.get(nazev).pridatVychod(smer, mistnosti.get(cil));
            }
        }
        br.close();

        if (!mistnosti.isEmpty()) {
            aktualniMistnost = mistnosti.values().iterator().next();
        }
    }

    public void jdi(String smer) {
        Mistnost nova = aktualniMistnost.getVychod(smer);
        if (nova != null) {
            aktualniMistnost = nova;
            System.out.println("Přesouváš se do místnosti: " + nova.getNazev());
        } else {
            System.out.println("Tímhle směrem se vydat nemůžeš");
        }
    }

    public void zobrazAktualniMistnost() {
        System.out.println("Jsi v: " + aktualniMistnost.getNazev());
    }
}
