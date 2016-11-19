package controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Board;
import model.MonoplyGame;
import model.Player;
import model.Property;

public class PlayerController extends JFrame{
	Player player;
	Board board;
	MonoplyGame MG;
	JLabel player_one_label;
	JLabel player_two_label;
	JLabel player_three_label;
	JLabel player_four_label;
	JLabel computerLabel;
	
	public PlayerController(Player player, Board board, MonoplyGame MG, JLabel player_one_label, JLabel player_two_label, JLabel player_three_label,JLabel player_four_label,
			JLabel computerLabel){
		this.player = player;
		this.board = board;
		this.MG = MG;
		this.player_one_label = player_one_label;
		this.player_two_label = player_two_label;
		this.player_three_label = player_three_label;
		this.player_four_label = player_four_label;
		this.computerLabel = computerLabel;
	}
	
	
	/**
	 * 
	 * PlayerController Utilities
	 * 
	 * */
	public int getnumOutOfJailCard(){
		return player.getnumOutOfJailCard();
	}
	
	public void setnumOutOfJailCard(int num){
		player.setnumOutOfJailCard(num);
	}
	
	public void setjailStatus(boolean js){
		player.setjailStatus(js);
	}
	
	public void setposition(int pos){
		player.setposition(pos);
	}
	
	public void move(int pos){
		player.move(pos);
	}
	
	public void getMoney(int amt){
		player.getMoney(amt);
	}
	
	public int getposition(){
		return player.getposition();
	}
	
	public ArrayList<String> getAllDescriptions(){
		return player.getAllDescriptions();
	}
	
	public void addProperty(Property p){
		player.addproperty(p);
	}
	
	public void removeMortgageProperty(Property returnProperty){
		player.removeMortgageProperty(returnProperty);
	}
	
	public void payMoney(int amt){
		player.payMoney(amt);
	}
	
	public int getbalance(){
		return player.getbalance();
	}
	
	public ArrayList<Property> getproperty(){
		return player.getproperty();
	}
	
	public ArrayList<String> getMorDes(){
		return player.getMorDes();
	}
	
	public void setActivePlayer(Player player){
		this.player = player;
	}
	
	public void jailStatus() {
		if (player.getnumOutOfJailCard() > 0) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null,
					"Is" + player.getname() + " going to use the Get Out Of Jail card?", "Information",
					dialogButton);
			if (dialogResult == JOptionPane.YES_OPTION) {
				player.setjailStatus(false);
				player.setnumOutOfJailCard(player.getnumOutOfJailCard() - 1);

			}

		} else {
			JOptionPane.showMessageDialog(null,
					"Let's try " + player.getname() + "'s luckness! Number over than 80, you will get free");
			int luckness = (int) (Math.random() * 99 + 1);
			JOptionPane.showMessageDialog(null, "your number: " + luckness);

			if (luckness > 80) {
				JOptionPane.showMessageDialog(null, player.getname() + "is so luck! Get out of here!");
				player.setjailStatus(false);
			} else {
				JOptionPane.showMessageDialog(null, "Oh man! DO NOT TRY TO PRISON BREAK");
				JOptionPane.showMessageDialog(null,
						player.getname() + "GET A FINE OF $200 and cannot move this turn");
				player.payMoney(200);
            showStatus();

				if (player.getbalance() < 0) {
					bankcrupt(-1 * player.getbalance());
				}
			}

		}
		
		this.nextPerson();
		
		
		
	}
	
	public void nextPerson(){
		Player currentPlayer  = player;
		
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
		
		public boolean bankcrupt(int moneyNeedToPay) {
			int moneyOwed = moneyNeedToPay;

			if (player.getproperty() == null || player.getproperty().size() == 0) {
				JOptionPane.showMessageDialog(null, "GET OUT OF THE GAME!");
				player.setfinancialStatus(false);
	         MG.deActivate(player.getname());
				return false;
			}

			if (moneyOwed < 0) {
				return true;
			}
	      
	      // AI bankrupts and sells property
	      if (player.getname().equals("Computer")) {
	    	  
	    	  
	         Property soldProperty = player.getproperty().get(player.getproperty().size()-1);
	         moneyOwed = moneyOwed - soldProperty.getMorgagePrice();
	   		soldProperty.setOwner("");
	 			player.getMoney(soldProperty.getMorgagePrice());
	         player.removeproperty(soldProperty);
	         JOptionPane.showMessageDialog(null, "I just sold " + soldProperty.getDescription());
	      } else { // Human bankrupts and sells property

	   		int dialogButton = JOptionPane.YES_NO_OPTION;
	   
	   		int dialogResult = JOptionPane.showConfirmDialog(null,
	   				"You are going to bankcrupt are going to sell your properties?", "Information", dialogButton);
	   		if (dialogResult == JOptionPane.YES_OPTION) {
	   			String[] choice = player.getAllDescriptions()
	   					.toArray(new String[player.getAllDescriptions().size()]);
	   
	   			String inpu = (String) JOptionPane.showInputDialog(null, "Choose now...", "The Choice of a Lifetime",
	   					JOptionPane.QUESTION_MESSAGE, null, // Use
	   														// default
	   														// icon
	   					choice, // Array of choices
	   					null); // Initial choice
	   			for (Property soldProperty : player.getproperty()) {
	   
	   				if (soldProperty.getDescription().equals(inpu)) {
	   					moneyOwed = moneyOwed - soldProperty.getMorgagePrice();
	   					soldProperty.setMorg();
	   					player.addMortgageProperty(soldProperty);
	   					player.removeproperty(soldProperty);
	   					player.getMoney(soldProperty.getMorgagePrice());
	   					break;
	   
	   				}
	   			}
	   
	   			if (inpu == null) {
	   				JOptionPane.showMessageDialog(null, "GET OUT OF THE GAME!");
	   				player.setfinancialStatus(false);
	               MG.deActivate(player.getname());
	   				return false;
	   			}
	   
	   		} else {
	   			JOptionPane.showMessageDialog(null, "GET OUT OF THE GAME!");
	   			player.setfinancialStatus(false);
	            MG.deActivate(player.getname());
	   			return false;
	   		}
	      }
			return bankcrupt(moneyOwed);
		}
		
		
		private void showStatus() {
			int player_cnt = 0;
			HashMap<String,Player> allPlayers = MG.getallPlayers();
			
			for (String key : allPlayers.keySet()) {
				player_cnt++;
				String balance;
				if (allPlayers.get(key).getfinancialStatus() == false) {
					balance = "gg";
				} else {
					balance = Integer.toString(allPlayers.get(key).getbalance());
				}
				switch (player_cnt) {
				case 1:
					player_one_label.setText(allPlayers.get(key).getname() + ":" + balance + "     ");
					break;
				case 2:
					player_two_label.setText(allPlayers.get(key).getname() + ":" + balance + "     ");
					break;
				case 3:
					player_three_label.setText(allPlayers.get(key).getname() + ":" + balance + "     ");
					break;

				case 4:
					player_four_label.setText(allPlayers.get(key).getname() + ":" + balance + "     ");
					break;

				default:
					break;
				}
			}
		}
	
		
	public boolean ownverCheck( int a, int b) {
		Property p1 = (Property) board.getTile(a);
		Property p2 = (Property) board.getTile(b);
		if (p1.getOwner() == p2.getOwner() && p1.getOwner() == player.getname()) {
			return true;
		}
		return false;
	}
	
	public boolean ownverCheck(int a, int b, int c) {
		Property p1 = (Property) board.getTile(a);
		Property p2 = (Property) board.getTile(b);
		Property p3 = (Property) board.getTile(c);
		if (p1.getOwner() == p2.getOwner() && p3.getOwner() == p2.getOwner() && p1.getOwner() == player.getname()) {
			return true;
		}
		return false;
	}
	
	public boolean checkDaLao(Property currentProperty) {
		int pos = currentProperty.getPosition();
		if (pos == 1 || pos == 3) {
			return ownverCheck( 1, 3);

		} else if (pos == 6 || pos == 8 || pos == 9) {
			return ownverCheck( 6, 8, 9);

		} else if (pos == 11 || pos == 13 || pos == 14) {
			return ownverCheck( 11, 13, 14);

		}

		else if (pos == 16 || pos == 18 || pos == 19) {
			return ownverCheck( 16, 18, 19);

		}

		else if (pos == 21 || pos == 23 || pos == 24) {
			return ownverCheck( 21, 23, 24);

		}

		else if (pos == 26 || pos == 27 || pos == 29) {
			return ownverCheck( 26, 27, 29);

		}

		else if (pos == 31 || pos == 32 || pos == 34) {
			return ownverCheck( 31, 32, 34);

		} else if (pos == 37 || pos == 39) {
			return ownverCheck( 37, 39);

		}

		return false;
	}
	
	
	/**
	 * Getters and Setters
	 * */
	public int[] throwDice(){
		return player.throwDice();
	}
	
	public String getname(){
		return this.player.getname();
	}
	
	public boolean getjailStatus(){
		return player.getjailStatus();
	}
	
}
