package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.MonoplyGame;
import model.Player;
import model.Property;

public class MonoplyGameController {
	MonoplyGame MG;
	ArrayList<String> names;
	HashMap<String, Player> allPlayers;

	public MonoplyGameController(MonoplyGame MG, HashMap<String, Player> allPlayers){
		this.MG = MG;
		this.allPlayers = allPlayers;
		this.names = new ArrayList<String>();
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
	
	/**
	 * Getters and Setters
	 * */
	public ArrayList<String> getnames(){
		return this.names;
	}
	
	public MonoplyGame getgame(){
		return this.MG;
	}
}
