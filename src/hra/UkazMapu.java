package hra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UkazMapu extends Command{

    @Override
    public String proved() {
        StringBuilder pribeh = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                pribeh.append(radek).append("\n");
            }
        } catch (IOException e) {
            return "NEPODARILO SE NACIST MAPU.";
        }
        return pribeh.toString();
    }

    @Override
    public boolean konec() {
        return false;
    }
}
