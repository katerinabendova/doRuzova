package mistnosti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;

class ZakleteDivadloTest {

    private ZakleteDivadlo zakleteDivadlo;

    @BeforeEach
    void setUp() {
        zakleteDivadlo = new ZakleteDivadlo("Zaklete divadlo");
    }

    @Test
    void ukol() {
        int a = 3;
        int b = 4;
        int spravnaOdpoved = a * b; // 12

        String vstup = "10\n" + spravnaOdpoved + "\n";
        InputStream in = new ByteArrayInputStream(vstup.getBytes());
        System.setIn(in);

        zakleteDivadlo.ukol();

    }
}