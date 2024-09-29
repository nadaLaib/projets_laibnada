package zombiegame.Actors;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import zombiegame.*;


public class ZombieTest {
    /*
     * Ce test vérifie que lorsque le zombie attaque le survivant,
     *  les points de vie du survivant diminuent d'un point, comme attendu
     */
    @Test
    public void testAttack_Survivor() {
		Town town = new Town();
        Survivor survivor = new Survivor("survivant", 10, 0,town);
        // Le zombie peut être positionné n'importe où pour ce test
        Zombie zombie = new Zombie("Zombie", 9, 0); 
        
        zombie.attack(survivor);
        assertEquals(5, survivor.getHealthPoints());
    }
   
}
