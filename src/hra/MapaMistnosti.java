package hra;

import mistnosti.*;
import postavy.Peadyn;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapaMistnosti {
    protected Map<String, Mistnost> mistnosti;
    protected Mistnost aktualniMistnost;
    private Peadyn peadyn = new Peadyn("boj s dykou", "Peadyn");;

    /**
     * nacte mapu mistnosti ze souboru a nastavi vychozi mistnost
     * @param soubor nazev souboru obsahujici mistnosti
     * @throws IOException pokud dojde k chybe pri nacitani souboru
     */
    public MapaMistnosti(String soubor) throws IOException {
        mistnosti = new HashMap<>();
        nactiZeSouboru();
       // Mistnost vychoziMistnost = mistnosti.getOrDefault("krajina", mistnosti.values().iterator().next());
        Mistnost vychoziMistnost = getStartovaciMistnost();
        this.aktualniMistnost = vychoziMistnost;
        this.peadyn.setAktualniMistnost(vychoziMistnost);

    }

    /**
     * nacte seznam mistnosti a jejich propojeni ze souboru "mistnosti.txt"
     * @throws IOException pokud dojde k chybe pri nacitani souboru
     */
    private void nactiZeSouboru() throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader("mistnosti.txt"));
        String radek;

        while ((radek = rd.readLine()) != null) {
            String[] cast = radek.split(" ");
            String nazev = cast[0];
            mistnosti.putIfAbsent(nazev, new Mistnost(nazev));

            for (int i = 1; i < cast.length; i ++) {
                String cil = cast[i];
                mistnosti.putIfAbsent(cil, new Mistnost(cil));
                mistnosti.get(nazev).pridatVychod(cil, mistnosti.get(cil));
            }
        }
        rd.close();
    }

    /**
     * vraci sttartovaci mistnost ve hre
     * @return startovaci mistnost ve hre
     */
    public Mistnost getStartovaciMistnost() {
        return mistnosti.getOrDefault("krajina", mistnosti.values().iterator().next());
    }

    /**
     * presun hrace do zadane mistnosti
     * @param cil nazev mistnosti, do ktere se chce hrac dostat
     */
    public void jdi(String cil) {
        Mistnost nova = aktualniMistnost.getVychod(cil);
        if (nova != null) {
            if (nova.muzeVstoupit(peadyn.getInventar())) {
                aktualniMistnost = nova;
                peadyn.setAktualniMistnost(nova);
                zobrazAktualniMistnost();
            } else {
                System.out.println("NEMUZES VSTOUPIT DO TETO MISTNOSTI.\n");
            }
        } else {
            System.out.println("TIMTO SMEREM SE VYDAT NEMUZES\n");
        }
    }

    /**
     * zobrazi informace o akrualni mistnosti
     */
    public void zobrazAktualniMistnost() {
        System.out.println("JSI V: " + aktualniMistnost.getNazev());
        System.out.println("MUZES JIT DO: " + String.join(", ", aktualniMistnost.getMozneVychody()) + "\n");
    }

    /**
     * @return vrati pocet mistnosti krome "unikove mistnosti
     */
    //chat GPT
    public int pocetMistnosti() {
        return (int) mistnosti.keySet().stream()
                .filter(nazev -> !nazev.equalsIgnoreCase("unikova mistnost"))
                .count();
    }
    //konec chat GPT


    public Mistnost getAktualniMistnost(){
        return aktualniMistnost;
    }


    public boolean nastavAktualniMistnost(String nazev) {
        if (nazev == null || !mistnosti.containsKey(nazev)) {
            System.out.println("CHYBA: Tato místnost neexistuje.");
            return false;
        }

        aktualniMistnost = mistnosti.get(nazev);
        peadyn.setAktualniMistnost(aktualniMistnost);

        zobrazAktualniMistnost();
        return true;

    }

}
