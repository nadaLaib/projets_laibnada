package zombiegame.Roles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HealerTest {

	@Test
	public void HealerRoleTest(){
		 Healer healer = new Healer();
	        
	    String roleName = healer.getName();
	        
	    assertEquals("Healer", roleName);
    }

}
