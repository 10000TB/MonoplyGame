import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author xuehaohu
 *
 */
public class MonoplyGame {
	private int numOfPlayer;
	private ArrayList<String> activePlayers;
	private HashMap<String,Player> allPlayers;
	private Board board;
	private ArrayList<Card> cards;
	private boolean onOffLine;
	
	MonoplyGame(int NumOfPlayer, boolean OnOffLine){
		this.numOfPlayer = NumOfPlayer;
		this.onOffLine = OnOffLine;
		
		this.activePlayers = new ArrayList<String>();
		this.allPlayers = new HashMap<String,Player>();
		this.cards = new ArrayList<Card>();
		this.onOffLine = false;
	}
	
	
	public void propertyAudition(){
		
	}
	
	public void removePlayer(String name){
		
		
	}
	
	
	/**
	 * Class Essentials
	 * Getters, Setters
	 * */
	public int getnumOfPlayer(){
		return this.numOfPlayer;
	}
	
	public void setnumOfPlayer(int num){
		this.numOfPlayer = num;
	}

	public ArrayList<String> getactivePlayers(){
		return this.activePlayers;
	}

	public void setactivePlayers(ArrayList<String> activePlayers){
		this.activePlayers = activePlayers;
	}
	
	public HashMap<String,Player> getallPlayers(){	
		return this.allPlayers;
	}
	
	public void setallPlayers(HashMap<String,Player> allPlayers){	
		this.allPlayers = allPlayers;
	}
	
	public Board getboard(){
		return this.board;
	}
	
	public void setboard(Board board){
		this.board = board;
	}
	
	public ArrayList<Card> getcards(){
		return this.cards;
	}
	
	public void setcards(ArrayList<Card> cards){
		this.cards = cards;
	}	
	
	public boolean getonOffLine(){
		return this.onOffLine;
	}
	
	public void setonOffLine(boolean onOffLine){
		this.onOffLine = onOffLine;
	}
}
