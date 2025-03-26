package mistnosti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class KulataKnihovnaTest {
    private KulataKnihovna kulataKnihovna;

    @BeforeEach
    void setUp() {
        kulataKnihovna = new KulataKnihovna("Kulata Knihovna");
    }

    @Test
    void testBojVyhra() {
        String input = "101\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        kulataKnihovna.boj();

        assertTrue(outContent.toString().contains("Vyhral jsi nad Verity"));
    }

    @Test
    void testBojProhra() {
        String input = "50\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        kulataKnihovna.boj();

        assertTrue(outContent.toString().contains("Prohral jsi."));
    }
}
