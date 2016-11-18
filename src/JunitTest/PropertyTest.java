package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import Game.*;
import model.Board;
import model.Property;

public class PropertyTest {

	// Test cost for property and getCost()7y
	@Test
	public void getCostTest () {
		Board b = new Board ();
		
		int cost [] = {0, 60, 0, 60, 0, 0, 100, 0, 100, 120,
					   0, 140, 0, 140, 160, 0, 180, 0, 180, 200,
					   0, 220, 0, 220, 240, 0, 260, 260, 0, 280,
					   0, 300, 300, 0, 320, 0, 0, 350, 0, 400};
		
		for (int i = 0; i < cost.length; i++) {
			if (cost[i] != 0) {
				Property p = (Property) b.getTile(i);
				assertEquals (cost[i], p.getCost());
			}
		}	
	}
	
	
	// Test getNumOfHouses()
	@Test
	public void getNumOfHousesTest () {
		Board b = new Board();
		
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getTile(i).equals("property")) {
				Property p = (Property) b.getTile(i);
				assertEquals (0, p.getNumOfHouses());
			}
		}	
	}
	
	
	// Test setNumOfHotels()
	@Test
	public void getNumOfHotelsTest () {
		Board b = new Board();
		
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getTile(i).equals("property")) {
				Property p = (Property) b.getTile(i);
				assertEquals (0, p.getNumOfHotels());
			}
		}
	}
	
	
	// Test buildHouse
	@Test
	public void buildHouseTest () {
		Property p = new Property (0, "P", new int[] {50, 100, 150, 200});
		
		assertEquals (0, p.getNumOfHouses());
		
		p.buildHouse();
		assertEquals (1, p.getNumOfHouses());
		p.buildHouse();
		p.buildHouse();
		assertEquals (3, p.getNumOfHouses());
		
	}
	
	// Test getRent()
	@Test
	public void getRentTest() {
		Property p = new Property (0, "P", new int[] {50, 100, 150, 200});
		p.buildHouse();
		assertEquals (100, p.getRent());
		p.buildHouse();
		assertEquals (150, p.getRent());
		p.buildHouse();
		assertEquals (200, p.getRent());	
	}
	
	
	// Test ifFullHouse()
	@Test
	public void fullHouseTest () {
		Property p = new Property (0, "P", new int[] {50, 100, 150, 200, 250});
		assertFalse(p.isFullHouse());
		p.buildHouse();
		p.buildHouse();
		p.buildHouse();
		p.buildHouse();
		assertTrue(p.isFullHouse());
	}
	
	
	// Test buildHotel()
	@Test
	public void buildHotelTest() {
		Property p = new Property (0, "P", new int[] {50, 100, 150, 200, 250, 500});
		p.buildHouse();
		p.buildHouse();
		p.buildHouse();
		p.buildHouse();
		p.buildHotel();
		assertEquals(0, p.getNumOfHouses());
		assertEquals(1, p.getNumOfHotels());
		assertEquals(500, p.getRent());
	}
	
	
	// Test getOwner()
	@Test
	public void getOwnerTest () {
		Board b = new Board();
		
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getTile(i).getType().equals("property")) {
				Property p = (Property) b.getTile(i);
				assertEquals("", p.getOwner());
			}
		}
	}
	
	// Test setOwner()
	@Test
	public void setOwnerTest () {
		Board b = new Board();
		
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getTile(i).getType().equals("property")) {
				Property p = (Property) b.getTile(i);
				p.setOwner("NEW OWNER");
				assertEquals("NEW OWNER", p.getOwner());
			}
		}	
	}
	
	// Test morgStatus
	@Test
	public void morgStatusTest() {
		Property p = new Property (0, "P", new int[] {50, 100, 150, 200, 250, 500});
		assertFalse(p.morg());
	}
	
	// Test setMorgStatus
	@Test
	public void setMorgStatus() {
		Property p = new Property (0, "P", new int[] {50, 100, 150, 200, 250, 500});
		p.setMorg();
		assertTrue(p.morg());
	}
	
	// Test morg price
	@Test
	public void morgPriceTest () {
		Property p = new Property (0, "P", new int[] {50, 100, 150, 200, 250, 500});
		p.buildHouse();
		p.setMorg();
		assertEquals(80, p.getMorgagePrice());
	}
	
	
	
	

}
