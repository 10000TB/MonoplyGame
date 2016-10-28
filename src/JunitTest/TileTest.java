package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Game.Board;
import Game.Tile;

public class TileTest {

	// Test if tile type is stored correctly and getType()
	@Test
	public void getTypeTest () {
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
	
	// Test getPosition().
	@Test
	public void getPositionTest () {
		Board b = new Board ();
		
		for (int i = 0; i < b.getSize(); i++) {
			Tile t = b.getTile(i);
			assertEquals (i, t.getPosition());
		}	
	}
	
	// Test setPosition()
	@Test
	public void setPositionTest () {
		Board b = new Board ();
		for (int i = 0; i < b.getSize(); i++) {
			Tile t = b.getTile(i);
			t.setPosition(10);
			assertEquals (10, t.getPosition());	
		}	
	}
	
	// Test setType()
	@Test
	public void setTypeTest () {
		Board b = new Board();
		
		for (int i = 0; i < b.getSize(); i++) {
			Tile t = b.getTile(i);
			t.setType("TYPE");		
			assertEquals ("TYPE", t.getType());			
		}
		
	}
	
	
	
	
	
	
	
	
	

}
