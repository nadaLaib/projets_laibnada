package zombiegame.SpecialRoom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import zombiegame.*;
import zombiegame.Actors.Survivor;


public class PharmacyTest {
	  

	 @Test
	    public void testToStringNoSurvivors() {
	        Pharmacy pharmacy = new Pharmacy();
	        assertEquals("🅿", pharmacy.toString());
	    }

	    @Test
	    public void testToStringWithSurvivors() {
	        Pharmacy pharmacy = new Pharmacy();
	        Town town = new Town ();
	        pharmacy.ajouterSurvivor(new Survivor("s1", 2,4, town)); // Ajoute un survivant pour simuler
	        assertEquals("\u001B[33m𖡌\u001B[0m", pharmacy.toString());
	    }
}
