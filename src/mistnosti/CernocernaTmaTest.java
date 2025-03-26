package mistnosti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CernocernaTmaTest {
    private CernocernaTma cernocernaTma;
    @BeforeEach
    void setUp() {
        cernocernaTma = new CernocernaTma("cernocerna tma");
    }

    @Test
    void bojSHracem() {
        String input = "5\n10\n15\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        cernocernaTma.bojSHracem();

        assertTrue(outContent.toString().contains("Porazil jsi Kaie!"));
    }

}
