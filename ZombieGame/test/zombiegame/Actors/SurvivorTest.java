package zombiegame.Actors;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import zombiegame.*;

class SurvivorTest {
	
	@Test
	void testToString() {
		Town town = new Town();
		Survivor survivant = new Survivor("survivant1",2,4,town);
		assertEquals("\u001B[33m𖡌\u001B[0m", survivant.toString());
	}
	
	@Test
	void testIsDead() {
		Town town = new Town();
		Survivor survivant = new Survivor("survivant1",2,4,town);
		assertEquals(5, survivant.getHealthPoints());
		assertNotEquals(0, survivant.getHealthPoints());
		assertFalse(survivant.isDead());
	}
	
	@Test
	void testGetName() {
		Town town = new Town();
		Survivor survivant = new Survivor("survivant1",2,4,town);
		assertEquals("survivant1", survivant.getName());
	}
	
	@Test
	void testGetPositionX() {
		Town town = new Town();
		Survivor survivant = new Survivor("survivant1",2,4,town);
		assertEquals(2, survivant.getPositionX());
	}
	
	@Test
	void testGetPositionY() {
		Town town = new Town();
		Survivor survivant = new Survivor("survivant1",2,4,town);
		assertEquals(4, survivant.getPositionY());
	}
	
	@Test
	void testGetHealthPoints() {
		Town town = new Town();
		Survivor survivant = new Survivor("survivant1",2,4,town);
		assertEquals(5, survivant.getHealthPoints());
	}
	
	@Test
	void testGetBackpack() {
		Town town = new Town();
		Survivor survivant = new Survivor("survivant1",2,4,town);
		assertNotNull(survivant.getBackpack());
		assertTrue(survivant.getBackpack().isEmpty());
	}
	
	@Test
	void testGetExpertiseLevel() {
		Town town = new Town();
		Survivor survivant = new Survivor("survivant1", 2, 4,town);
		assertEquals(1, survivant.getExpertiseLevel());
	}
	
	@Test
	void testGetActionPoints() {
		Town town = new Town();
		Survivor survivant = new Survivor("survivant1", 2, 4,town);
		assertEquals(3, survivant.getActionPoints());
	}
	
	@Test
	void testGetRoles() {
		Town town = new Town();
		Survivor survivant = new Survivor("survivant1", 2, 4,town);
		assertNotNull(survivant.getRoles());
	}
	
	
	@Test
	void testAugmenterNiveauExpertise() {
		Town town = new Town();
		Survivor survivant = new Survivor("survivant1", 2, 4,town);
		assertEquals(1, survivant.getExpertiseLevel());
		survivant.augmenterNiveauExpertise();
		assertEquals(2, survivant.getExpertiseLevel());
	}
	
	

}
