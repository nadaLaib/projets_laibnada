package zombiegame.SpecialZombie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zombiegame.Town;
import zombiegame.Actors.Survivor;

public class AbominationTest {
	
	@Test
    public void testAttack() {
        Abomination abomination = new Abomination("Test Abomination", 0, 0);
        Town town = new Town();
        Survivor survivor = new Survivor("Test Survivor", 0, 0, town);
        abomination.attack(survivor); // Abomination attaque Survivor
        assertEquals(5, survivor.getHealthPoints());
    }

}
