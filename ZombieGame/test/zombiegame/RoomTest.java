package zombiegame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import zombiegame.Equipments.AidKit;

public class RoomTest {


	//vérifie que le constructeur par défaut initialise correctement la pièce avec un type normale
	@Test
			public void testDefaultConstructor() {
			Room room = new Room();
			assertEquals("NormalRoom", room.getRoomType());
			}
	//vérifie que le constructeur avec paramètre initialise correctement la pièce avec le type spécifié.
	@Test
			public void testParameterizedConstructor() {
			Room room = new Room("SpecialRoom");
			assertEquals("SpecialRoom", room.getRoomType());
			}
		
	//vérifie la méthode setRoomType
	@Test
			public void testSetRoomType() {
			Room room = new Room();
			room.setRoomType("ModifiedRoom");
			assertEquals("ModifiedRoom", room.getRoomType());
			}

	
	@Test
    public void testAddAndGetEquipment() {
        Room room = new Room();
        Equipment equipment = new AidKit();
        room.ajouterEquipment(equipment);
        assertTrue(room.getEquipment().contains(equipment));
    }

    @Test
    public void testRemoveEquipment() {
        Room room = new Room();
        Equipment equipment = new AidKit();
        room.ajouterEquipment(equipment);
        room.removeEquipment(equipment);
        assertFalse(room.getEquipment().contains(equipment));
    }

			
	}
