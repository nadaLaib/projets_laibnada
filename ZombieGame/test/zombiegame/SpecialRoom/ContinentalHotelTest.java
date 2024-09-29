package zombiegame.SpecialRoom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import zombiegame.*;
import zombiegame.Actors.Survivor;

public class ContinentalHotelTest {
	@Test
    public void testToStringNoSurvivors() {
        ContinentalHotel hotel = new ContinentalHotel();
        assertEquals("🅷", hotel.toString());
    }

    @Test
    public void testToStringWithSurvivors() {
        ContinentalHotel hotel = new ContinentalHotel();
        Town town = new Town();
        hotel.ajouterSurvivor(new Survivor("s1", 2,3, town)); // Ajoute un survivant pour simuler
        assertEquals("\u001B[33m𖡌\u001B[0m", hotel.toString());
    }

}

