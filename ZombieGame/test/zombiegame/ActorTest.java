package zombiegame;

import zombiegame.Actors.Zombie;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class ActorTest {
	@Test
    public void testActorConstructor() {
        Actor actor = new Zombie("Zombie", 3, 5);
        assertEquals("Zombie", actor.name);
        assertEquals(5, actor.healthPoints);
        assertEquals(3, actor.positionX);
        assertEquals(5, actor.positionY);
    }

    @Test
    public void testIsDead() {
        Actor actor = new Zombie("Zombie", 0, 0);
        assertFalse(actor.isDead());
    }

    @Test
    public void testSetPosition() {
        Actor actor = new Zombie("Zombie", 0, 0);
        actor.setPosition(2, 4);
        assertEquals(2, actor.getPositionX());
        assertEquals(4, actor.getPositionY());
    }

    @Test
    public void testTakeDamage() {
        Actor actor = new Zombie("Zombie", 0, 0);
        actor.takeDamage(3);
        assertEquals(2, actor.getHealthPoints());
    }
}
