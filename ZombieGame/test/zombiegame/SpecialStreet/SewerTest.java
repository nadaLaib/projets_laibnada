package zombiegame.SpecialStreet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class SewerTest {
    
    @Test
    public void testToString() {
        Sewer sewer = new Sewer();
        assertEquals("\u001B[31m𝗢\u001B[0m", sewer.toString());
    }

    
}