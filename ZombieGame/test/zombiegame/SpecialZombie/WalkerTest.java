package zombiegame.SpecialZombie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zombiegame.Town;
import zombiegame.Actors.Survivor;

public class WalkerTest {

	@Test
    public void testAttack() {
        Walker walker = new Walker(0, 0);
        Town town = new Town();
        Survivor survivor = new Survivor("s1", 0, 0, town);
        walker.attack(survivor); 
        assertEquals(5, survivor.getHealthPoints());
    }
}
