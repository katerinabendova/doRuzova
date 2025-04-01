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

    public MapaMistnosti(String soubor) throws IOException {
        mistnosti = new HashMap<>();
        nactiZeSouboru();
        Mistnost vychoziMistnost = mistnosti.getOrDefault("krajina", mistnosti.values().iterator().next());
        this.peadyn.setAktualniMistnost(vychoziMistnost);

    }

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

        /*if (!mistnosti.isEmpty()) {
            aktualniMistnost = mistnosti.getOrDefault("krajina", mistnosti.values().iterator().next());
            peadyn.setAktualniMistnost(aktualniMistnost);
        }*/

    }
    public Mistnost getStartovaciMistnost() {
        return mistnosti.getOrDefault("krajina", mistnosti.values().iterator().next());
    }

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

    public void zobrazAktualniMistnost() {
        System.out.println("JSI V: " + aktualniMistnost.getNazev());
        System.out.println("MUZES JIT DO: " + String.join(", ", aktualniMistnost.getMozneVychody()) + "\n");

    }



    //chat GPT
    public int pocetMistnosti() {
        return (int) mistnosti.keySet().stream()
                .filter(nazev -> !nazev.equalsIgnoreCase("unikova mistnost"))
                .count();
    }
    //konec chat GPT

    public Mistnost getMistnost(String nazev){
        return mistnosti.get(nazev);
    }

    public Mistnost getAktualniMistnost(){
        return aktualniMistnost;
    }

    public void setAktualniMistnost(Mistnost aktualniMistnost) {
        this.aktualniMistnost = aktualniMistnost;
    }

    public void jdi(String cil, Inventar inventar) {
        Mistnost nova = aktualniMistnost.getVychod(cil);
        if (nova != null) {
            if (nova.muzeVstoupit(inventar)) {
                aktualniMistnost = nova;
                aktualniMistnost.zobrazMistnost();

                if (aktualniMistnost.maUkol()) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("ZADEJ SVOU ODPOVED: ");
                    String odpoved = sc.nextLine();
                    aktualniMistnost.spustitUkol(odpoved);
                }
            } else {
                System.out.println("NEMUZES VSTOUPIT.");
            }
        } else {
            System.out.println("TIMTO SMEREM SE VYDAT NEMUZES.");
        }
    }
    public void zobrazUkolyVMistnostech() {
        System.out.println("\nSEZNAM MISTNOSTI A JEJICH UKOLU");
        for (Map.Entry<String, Mistnost> entry : mistnosti.entrySet()) {
            Mistnost mistnost = entry.getValue();
            System.out.print("- " + mistnost.getNazev() + ": ");

            if (mistnost.maUkol()) {
                System.out.println("UKOL JE DOSTUPNY");
            } else {
                System.out.println("MISTNOST BEZ UKOLU");
            }
        }

    }
}
