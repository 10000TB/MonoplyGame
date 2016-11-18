package test;

import static org.junit.Assert.*;

import org.junit.Test;
import model.ChanceCard;

public class ChanceCardTest {
	@Test
	public void getAmountChange_normal() {
		ChanceCard cc = new ChanceCard("chanceCardT", true, true, 100, false);
		
		assertEquals(100,cc.getAmountChange());
	}
	
	@Test
	public void setAmountChange_normal(){
		ChanceCard cc = new ChanceCard("chanceCardT", true, true, 100, false);
		cc.setAmountChange(200);
		
		assertEquals(200,cc.getAmountChange());
	}
	
	@Test
	public void getInfluenceOthers_normal(){
		ChanceCard cc = new ChanceCard("chanceCardT", true, true, 100, false);
		
		assertFalse(cc.getInfluenceOthers());
	}
}
