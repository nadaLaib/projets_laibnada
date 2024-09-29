package zombiegame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import zombiegame.Actors.Survivor;

public class StreetTest {

	@Test
    public void testGetLetterNoSurvivors() {
        Street street = new Street();
        assertEquals("\u001B[37mS\u001B[0m", street.getLetter());
    }

    @Test
    public void testGetLetterWithSurvivors() {
        Street street = new Street();
        Town town = new Town();
        street.ajouterSurvivor(new Survivor("s1",2,3,town)); // Ajoute un survivant pour simuler
        assertEquals("\u001B[33m𖡌\u001B[0m", street.getLetter());
    }

    @Test
    public void testToString() {
        Street street = new Street();
        assertEquals(street.getLetter(), street.toString());
    }
}
