package zombiegame.SpecialZombie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zombiegame.Town;
import zombiegame.Actors.Survivor;

public class BalaiseTest {
	
	@Test
    public void testAttack() {
        Balaise balaise = new Balaise("z1", 0, 0);
        Town town = new Town();
        Survivor survivor = new Survivor("s1", 0, 0, town);
        balaise.attack(survivor); 
        assertEquals(5, survivor.getHealthPoints());
    }

}
