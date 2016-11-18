package test;

import static org.junit.Assert.*;

import org.junit.Test;
import model.CommunityChestCard;

public class CommunityChestCardTest {

	@Test
	public void getposMove_normal() {
		CommunityChestCard ccc = new CommunityChestCard("ccc1", true, false, 12, false, 1);
		
		assertEquals(12,ccc.getposMove());
	}

	@Test
	public void getJump_normal() {
		CommunityChestCard ccc = new CommunityChestCard("ccc1", true, false, 12, false, 1);
		
		assertEquals(1,ccc.getJump());
	}
	
	@Test 
	public void ifMove_normal(){
		CommunityChestCard ccc = new CommunityChestCard("ccc1", true, false, 12, false, -1);

		assertFalse(ccc.ifMove());
	}
	
}
