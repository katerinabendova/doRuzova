import mistnosti.Mistnost;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapaMistnosti {
    protected Map<String, Mistnost> mistnosti;
    protected Mistnost aktualniMistnost;

    public MapaMistnosti(String soubor) throws IOException {
        mistnosti = new HashMap<>();
        nactiZeSouboru(soubor);
    }

    private void nactiZeSouboru(String soubor) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader(soubor));
        String radek;
        while ((radek = rd.readLine()) != null) {
            String[] casti = radek.split(" ");
            String nazev = casti[0];
            mistnosti.putIfAbsent(nazev, new Mistnost(nazev));

            for (int i = 1; i < casti.length; i ++) {
                String cil = casti[i];
                mistnosti.putIfAbsent(cil, new Mistnost(cil));
                mistnosti.get(nazev).pridatVychod(cil, mistnosti.get(cil));
            }
        }
        rd.close();

        if (!mistnosti.isEmpty()) {
            aktualniMistnost = mistnosti.getOrDefault("krajina", mistnosti.values().iterator().next());
        }
    }

    public void jdi(String cil) {
        Mistnost nova = aktualniMistnost.getVychod(cil);
        if (nova != null) {
            aktualniMistnost = nova;
            zobrazAktualniMistnost();
        } else {
            System.out.println("Tímhle směrem se vydat nemůžeš");
        }
    }

    public void zobrazAktualniMistnost() {
        System.out.println("Jsi v: " + aktualniMistnost.getNazev());
        System.out.println("Muzes jit do: " + String.join(", ", aktualniMistnost.getMozneVychody()));
    }
}
