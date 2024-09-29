package zombiegame.Roles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class FighterTest {

	@Test
	public void FighterRoleTest(){
        Fighter fighter = new Fighter();
        
        String roleName = fighter.getName();
        
        assertEquals("Fighter", roleName);
       
    }

}
