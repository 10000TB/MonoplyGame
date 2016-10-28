package JunitTest;
import static org.junit.Assert.*;

import org.junit.Test;

import Game.*;

public class BoardTest {

	
	// Test if board initialized correctly
	@Test
	public void boardInitTest() {
		Board b = new Board();
		assertEquals (40, b.getSize());
	}
	
	
	// Test if tile type is stored correctly and getType()
	@Test
	public void tileTypeTest () {
		Board b = new Board();
		int propertyIndex [] = {1, 3, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21,
								23, 24, 26, 27, 29, 31, 32, 34, 37, 39};
		
		for (int i = 0; i < propertyIndex.length; i++) {
			assertEquals ("property", b.getTile(propertyIndex[i]).getType());
		}
		
		int specialIndex [] = {2, 4, 5, 7, 10, 12, 15, 17, 20, 22, 25, 28, 30, 33, 35, 36, 38};
		for (int i = 0; i < specialIndex.length; i++) {
			assertEquals ("special", b.getTile(specialIndex[i]).getType());
		}
	}
	
	
	
	// Test getDescription() and names of tiles
	@Test
	public void getDescTest () {
		Board b = new Board ();
		
		String names[] = {"GO!", "Mediterranean Avenue", "Community Chest", "Baltic Avenue",
						  "Income Tax", "Reading RailRoad", "Oriental Avenue", "Chance",
						  "Vermont Avenue", "Connecticut Avenue", "IN JAIL", "St. Charles Place",
						  "Electricity Company", "States Avenue", "Virginia Avenue", "Pennsylvania RR",
						  "St. James Place", "Community Chest", "Tennessee Avenue", "New York Avenue",
						  "Free Parking (Just take a rest)", "Kentucky Avenue", "Chance",
						  "Indiana Avenue", "Illinois Avenue", "B&O Rail Road",  "Atlantic Avenue",
						  "Ventnor Avenue",  "Water Works", "Marvin Gardens", "GO TO JAIL", 
						  "Pacific Avenue", "North Carolina Avenue", "Community Chest", 
						  "Pennsylvania Avenue", "Short Line Station", "Chance", "Park Place", "SUPER TAX",
						  "Boardwalk" };

		
		for (int i = 0; i < 40; i++) {
			assertEquals (names[i], b.getTile(i).getDescription());
		}
	}
	
	
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
	

}
	
