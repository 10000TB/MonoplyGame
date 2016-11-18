package controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Board;
import model.MonoplyGame;
import model.Player;
import model.Property;

public class MonoplyGameController extends JFrame{
	MonoplyGame MG;
	ArrayList<String> names;
	HashMap<String, Player> allPlayers;
	Board board;

	public MonoplyGameController(MonoplyGame MG, HashMap<String, Player> allPlayers, Board board){
		this.MG = MG;
		this.allPlayers = allPlayers;
		this.names = new ArrayList<String>();
		this.board = board;
	}
	
	/*********************
	  Utilities
	*/
	public void setnumOfPlayer(int num){
		this.MG.setnumOfPlayer(num);
	}
	
	public void addPlayer(String name){
		names.add(name);
		Player player = new Player(name, 1000, true, 0, false, 0, new ArrayList<Property>());
		this.allPlayers.put(name, player);
	}
	
	public void setactivePlayers(){
		this.MG.setactivePlayers(this.names);
	}
	
	public void setAllPlayers(){
		this.MG.setallPlayers(this.allPlayers);
	}
	
	public Player getActivePlayer(){
		return this.allPlayers.get(this.MG.getactivePlayers().get(0));
	}
	
	public void nextPerson(){
		Player currentPlayer  = getActivePlayer();
		
		MG.getactivePlayers().remove(0);
		// allPlayers.get(MG.getactivePlayers().get(1));
		if (currentPlayer.getfinancialStatus()) {
			MG.getactivePlayers().add(currentPlayer.getname());

		} else {
			for (int i = 0; i < 39; i++) {
				if (currentPlayer.getproperty() == null) {
					break;
				}
				if (board.getTile(i) instanceof Property) {
					Property p = (Property) board.getTile(i);
					if (currentPlayer.getproperty().contains(p)) {
						p.clearAll();
						currentPlayer.removeproperty(p);
						currentPlayer.getMoney(p.getMorgagePrice());
					}
				}
			}
		}
	}
	
	/**
	 * Getters and Setters
	 * */
	public ArrayList<String> getnames(){
		return this.names;
	}
	
	public MonoplyGame getgame(){
		return this.MG;
	}
	
	public HashMap<String,Player> getallPlayers(){
		return MG.getallPlayers();
	}
}
