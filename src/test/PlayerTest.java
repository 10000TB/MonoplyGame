package test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import model.Player;
import model.Property;

public class PlayerTest {

	
	//
	// Test throwDiceTest() - 1 
	// see if throw dice return two integer number and are with 1 and 6 
	//
	@Test
	public void throwDiceTest() {
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 0, false, 0, property); 
		
		int[] dice_nums =  player.throwDice();
		
		assertEquals(2, dice_nums.length);
		assertTrue(dice_nums[0]>=1 && dice_nums[0]<=6);
		assertTrue(dice_nums[1]>=1 && dice_nums[1]<=6);
	}
	
	//
	// Test move(target pos) - 1
	// - see if move position correctly if currentPosition+moveStep<40
	//
	@Test
	public void moveTest_within40(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 0, false, 0, property); 
		
		player.move(10);
		
		assertEquals(10,player.getposition());
	}
	
	//
	// Test move(target pos) - 2
	// - see if move position correctly if currentPosition+moveStep > 40
	//
	@Test	
	public void moveTest_over40(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		player.move(4);
		
		assertEquals(2, player.getposition());
	}
	
	//
	// Test payMoney(amt) - 1
	// the amt is smaller than balance
	//
	@Test
	public void payMoney_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		player.payMoney(1000);
		
		assertEquals(500, player.getbalance());
	}

	//
	// Test payMoney(amt) - 2
	// the amt is larger than balance
	// as we handle bankrupt in main game, so we allow minus balance here
	//
	@Test
	public void payMoney_bankrupt(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		player.payMoney(2000);
		
		assertEquals(-500, player.getbalance());
	}
	
	@Test
	public void getMoney_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		player.getMoney(100);
		
		assertEquals(1600,player.getbalance());
	}

	@Test
	public void getname_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		assertEquals("test",player.getname());
	}

	@Test
	public void setname_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		player.setname("test2");
		
		assertEquals("test2", player.getname());
	}

	@Test
	public void getbalance_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		assertEquals(1500,player.getbalance());
	}
	
	@Test
	public void setbalance_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		player.setbalance(1600);
		
		assertEquals(1600,player.getbalance());
	}	
	
	@Test
	public void getfinancialStatus_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		assertEquals(true,player.getfinancialStatus());
	}
	
	@Test
	public void setfinancialStatus_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		player.setfinancialStatus(false);
		
		assertEquals(false,player.getfinancialStatus());
	}	
	
	@Test
	public void getposition_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		assertEquals(38,player.getposition());
	}
	
	@Test
	public void setposition_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		player.setposition(10);
		
		assertEquals(10,player.getposition());
	}	
	
	@Test
	public void getjailStatus_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		assertEquals(false,player.getjailStatus());
	}
	
	@Test
	public void setjailstatus_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		player.setjailStatus(true);
		
		assertEquals(true,player.getjailStatus());		
	}
	
	@Test
	public void getnumOutOfJailCard_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		assertEquals(0,player.getnumOutOfJailCard());
	}

	@Test
	public void setnumOutOfJailCard_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
	
		player.setnumOutOfJailCard(1);
		
		assertEquals(1,player.getnumOutOfJailCard());
	}
	
	@Test
	public void getproperty_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		
		assertEquals(property,player.getproperty());
	}

	@Test
	public void setproperty_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		int[] rentData = {1,1};
		
		Property p1 = new Property(1, "" , rentData);
		property.add(p1);
		
		player.setproperty(property);;
		
		assertEquals(property,player.getproperty());
	}	
	
	@Test
	public void addproperty_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		int[] rentData = {1,1};
		
		Property p1 = new Property(1, "" , rentData);
		property.add(p1);
		player.addproperty(p1);
		
		assertEquals(property,player.getproperty());
	}	
	
	@Test
	public void removeProperty_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		int[] rentData = {1,1};		
		
		Property p1 = new Property(1, "" , rentData);
		player.addproperty(p1);	
		
		player.removeproperty(p1);
		
		assertEquals(property,player.getproperty());
	}

	@Test
	public void getalldes_normal(){
		ArrayList<Property> property = new ArrayList<Property>();
		Player player = new Player("test", 1500, true, 38, false, 0, property); 
		int[] rentData = {1,1};		
		
		Property p1 = new Property(1, "pa" , rentData);
		player.addproperty(p1);
	
		ArrayList<String> allDes = new ArrayList<String>();
		allDes.add("pa");
		
		assertEquals(allDes,player.getAllDescriptions());
	}
	
	
}