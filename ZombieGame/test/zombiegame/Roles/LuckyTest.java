package zombiegame.Roles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LuckyTest {

	@Test
	public void LuckyRoleTest(){
		 Lucky lucky = new Lucky();
	        
	     String roleName = lucky.getName();
	        
	     assertEquals("Lucky", roleName);

    }

}
