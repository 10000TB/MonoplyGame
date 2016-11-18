package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import model.Board;
import model.Card;
import model.MonoplyGame;
import model.Player;
import model.Property;

public class MonoplyGameTest {

	@Test
	public void getnumOfPlayer_normal() {
		MonoplyGame MG = new MonoplyGame(2, false);
		
		assertEquals(2,MG.getnumOfPlayer());
	}
	
	@Test
	public void getnumOfPlayerTest() {
		MonoplyGame MG = new MonoplyGame(2, false);
		
		MG.setnumOfPlayer(3);
		
		assertEquals(3,MG.getnumOfPlayer());
	}
	
	@Test
	public void getactivePlayers_normal(){
		MonoplyGame MG = new MonoplyGame(2, false);
		
		ArrayList<String> a_p = new ArrayList<String>();
		MG.setactivePlayers(a_p);
		
		assertEquals(a_p,MG.getactivePlayers());
	}
	
	@Test
	public void setactivePlayers_normal(){
		MonoplyGame MG = new MonoplyGame(2, false);
		
		ArrayList<String> a_p = new ArrayList<String>();
		MG.setactivePlayers(a_p);
		
		assertEquals(a_p,MG.getactivePlayers());
	}
	
	@Test
	public void getallPlayers_normal(){
		MonoplyGame MG = new MonoplyGame(2, false);
		HashMap<String, Player> all_p = new HashMap<String, Player>();
	
		ArrayList<Property> property = new ArrayList<Property>();
		Player player1 = new Player("p1", 1500, true, 0, false, 0, property); 
		Player player2 = new Player("p2", 1500, true, 0, false, 0, property);
		
		all_p.put("p1", player1);
		all_p.put("p2", player2);
		
		MG.setallPlayers(all_p);
		
		assertEquals(all_p,MG.getallPlayers());
	}

	@Test
	public void setAllPlayer_normal(){
		MonoplyGame MG = new MonoplyGame(2, false);
		HashMap<String, Player> all_p = new HashMap<String, Player>();
	
		ArrayList<Property> property = new ArrayList<Property>();
		Player player1 = new Player("p1", 1500, true, 0, false, 0, property); 
		Player player2 = new Player("p2", 1500, true, 0, false, 0, property);
		
		all_p.put("p1", player1);
		all_p.put("p2", player2);
		
		MG.setallPlayers(all_p);
		
		assertEquals(all_p,MG.getallPlayers());
	}
	
	@Test
	public void getboard_null(){
		MonoplyGame MG = new MonoplyGame(2, false);
		
		assertEquals(null,MG.getboard());
	}
	
	@Test
	public void getboard_normal(){
		MonoplyGame MG = new MonoplyGame(2, false);
		Board b = new Board();
		MG.setboard(b);
		
		assertEquals(b,MG.getboard());
	}
	
	@Test
	public void setboard_normal(){
		MonoplyGame MG = new MonoplyGame(2, false);
		Board b = new Board();
		MG.setboard(b);
		
		assertEquals(b,MG.getboard());
	}

	@Test
	public void getCards_normal(){
		MonoplyGame MG = new MonoplyGame(2, false);
		ArrayList<Card> cards = new ArrayList<Card>();
		
		assertEquals(cards,MG.getcards());
	}

	@Test
	public void setCards_normal(){
		MonoplyGame MG = new MonoplyGame(2, false);
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(null);
		MG.setcards(cards);

		assertEquals(cards,MG.getcards());
	}	

	@Test
	public void getonOffLine(){
		MonoplyGame MG = new MonoplyGame(2, false);
		
		assertEquals(false,MG.getonOffLine());
	}
	
	@Test
	public void setonOffLine(){
		MonoplyGame MG = new MonoplyGame(2, false);
		MG.setonOffLine(true);
		
		assertEquals(true,MG.getonOffLine());
	}
}
