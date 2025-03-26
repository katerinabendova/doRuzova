package mistnosti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokojSeptajicichHlasuTest {

    private PokojSeptajicichHlasu pokojSeptajicichHlasu;

    @BeforeEach
    void setUp() {
        pokojSeptajicichHlasu = new PokojSeptajicichHlasu("Pokoj Šeptajících Hlasů");
    }

    @Test
    void testSpravnaOdpoved() {
        List<String> radky = List.of("slovo hledane", "text hledane");

        String input = "hledane\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        pokojSeptajicichHlasu.ukol();

        assertTrue(outContent.toString().contains("spravne"));
    }

    @Test
    void testSpatnaOdpoved() {
        List<String> radky = List.of("slovo hledane", "text hledane");

        String input = "spatne\nhledane\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        pokojSeptajicichHlasu.ukol();

        assertTrue(outContent.toString().contains("spatne zkus to znovu"));
        assertTrue(outContent.toString().contains("spravne"));
    }
}
