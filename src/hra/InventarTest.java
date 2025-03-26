package hra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InventarTest {

    private Inventar inventar;
    private Set<String> navstiveneMistnosti;

    @BeforeEach
    void setUp() {
        inventar = new Inventar();
        navstiveneMistnosti = new HashSet<>();
    }

    @Test
    void testOdemkniUnikovouMistnost() {
        inventar.pridejPredmet("diamantovy klic");

        navstiveneMistnosti.add("mistnost1");
        navstiveneMistnosti.add("mistnost2");
        navstiveneMistnosti.add("mistnost3");
        navstiveneMistnosti.add("mistnost4");
        navstiveneMistnosti.add("mistnost5");


        assertTrue(inventar.odemkni(navstiveneMistnosti, 5));
    }

    @Test
    void testOdemkniBezDiamantovehoKlice() {
        assertFalse(inventar.odemkni(navstiveneMistnosti, 5));
    }

    @Test
    void testOdemkniNevsechnyMistnosti() {
        inventar.pridejPredmet("diamantovy klic");

        navstiveneMistnosti.add("mistnost1");
        navstiveneMistnosti.add("mistnost2");

        assertFalse(inventar.odemkni(navstiveneMistnosti, 5));
    }
}
