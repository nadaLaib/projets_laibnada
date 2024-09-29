package zombiegame.SpecialZombie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zombiegame.Town;
import zombiegame.Actors.Survivor;

public class RunnerTest {
	
	@Test
    public void testAttack() {
        Runner runner = new Runner("z1", 0, 0);
        Town town = new Town();
        Survivor survivor = new Survivor("s1", 0, 0, town);
        runner.attack(survivor); 
        assertEquals(5, survivor.getHealthPoints());
    }

}
