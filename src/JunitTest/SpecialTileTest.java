package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import Game.SpecialTile;

public class SpecialTileTest {

	
	// Test constructor
	@Test
	public void constructorTest() {
		SpecialTile st = new SpecialTile (0, "specialTile");
		assertEquals(0, st.getPosition());
		assertEquals("specialTile", st.getDescription());
		assertEquals("special", st.getType());
	}

}
