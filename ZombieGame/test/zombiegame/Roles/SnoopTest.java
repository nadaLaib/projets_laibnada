package zombiegame.Roles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class SnoopTest {

	@Test
	public void SnoopRoleTest(){
		 Snoop snoop = new Snoop();
	        
	     String roleName = snoop.getName();
	        
	     assertEquals("Snoop", roleName);
    }
}
