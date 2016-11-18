package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MonoplyGameGUI extends JFrame {

	// global game constraints
	int gameMaxDuration = 10 * 60;// maximum game duration 10*60 seconds
	ArrayList<JLabel> tileLabels = new ArrayList<JLabel>();
	HashMap<String, Player> allPlayers = new HashMap<String, Player>();

	// UI elements
	// timer panel
	JPanel timerPanel = new JPanel();
	JLabel timerLabel = new JLabel();
	// player info
	JPanel playerPanel1 = new JPanel();
	JPanel playerPanel2 = new JPanel();
	JPanel playerPanel3 = new JPanel();
	JPanel playerPanel4 = new JPanel();
   JPanel computerPanel = new JPanel();

	JLabel player_one_label = new JLabel();
	JLabel player_two_label = new JLabel();
	JLabel player_three_label = new JLabel();
	JLabel player_four_label = new JLabel();
   JLabel computerLabel     = new JLabel();

	JPanel turnPanel = new JPanel();
	JLabel turnLabel = new JLabel();

	// player panel
// 	JPanel player_one_panel = new JPanel();
// 	JPanel player_two_panel = new JPanel();
// 	JPanel player_three_panel = new JPanel();
// 	JPanel player_four_panel = new JPanel();

	// rollDice panel
	JPanel rollDice = new JPanel();
	JButton diceButton = new JButton("Rolling Dice");
	// JButton player_one_info = new JButton("player 1 Info");

	//
	Board board = new Board();
	int flag = 0;

	private void showStatus() {
		int player_cnt = 0;

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

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private void nextPerson(Player currentPlayer, MonoplyGame MG) {
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

	private boolean bankcrupt(Player currentPlayer, int moneyNeedToPay) {
		int moneyOwed = moneyNeedToPay;

		if (currentPlayer.getproperty() == null) {
			JOptionPane.showMessageDialog(null, "GET OUT OF THE GAME!");
			currentPlayer.setfinancialStatus(false);
			return false;
		}

		if (moneyOwed < 0) {
			return true;
		}

		int dialogButton = JOptionPane.YES_NO_OPTION;

		int dialogResult = JOptionPane.showConfirmDialog(null,
				"You are going to bankcrupt are going to sell your properties?", "Information", dialogButton);
		if (dialogResult == JOptionPane.YES_OPTION) {
			String[] choice = currentPlayer.getAllDescriptions()
					.toArray(new String[currentPlayer.getAllDescriptions().size()]);

			String inpu = (String) JOptionPane.showInputDialog(null, "Choose now...", "The Choice of a Lifetime",
					JOptionPane.QUESTION_MESSAGE, null, // Use
														// default
														// icon
					choice, // Array of choices
					null); // Initial choice
			for (Property soldProperty : currentPlayer.getproperty()) {

				if (soldProperty.getDescription().equals(inpu)) {
					moneyOwed = moneyOwed - soldProperty.getMorgagePrice();
					soldProperty.setMorg();
					currentPlayer.addMortgageProperty(soldProperty);
					currentPlayer.getMoney(soldProperty.getMorgagePrice());
					break;

				}
			}

			if (inpu == null) {
				JOptionPane.showMessageDialog(null, "GET OUT OF THE GAME!");
				currentPlayer.setfinancialStatus(false);
				return false;
			}

		} else {
			JOptionPane.showMessageDialog(null, "GET OUT OF THE GAME!");
			currentPlayer.setfinancialStatus(false);
			return false;
		}

		return bankcrupt(currentPlayer, moneyOwed);
	}

	private void jailStatus(Player currentPlayer, MonoplyGame MG) {
		if (currentPlayer.getnumOutOfJailCard() > 0) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null,
					"Is" + currentPlayer.getname() + " going to use the Get Out Of Jail card?", "Information",
					dialogButton);
			if (dialogResult == JOptionPane.YES_OPTION) {
				currentPlayer.setjailStatus(false);
				currentPlayer.setnumOutOfJailCard(currentPlayer.getnumOutOfJailCard() - 1);

			}

		} else {
			JOptionPane.showMessageDialog(null,
					"Let's try " + currentPlayer.getname() + "'s luckness! Number over than 80, you will get free");
			int luckness = (int) (Math.random() * 99 + 1);
			JOptionPane.showMessageDialog(null, "your number: " + luckness);

			if (luckness > 80) {
				JOptionPane.showMessageDialog(null, currentPlayer.getname() + "is so luck! Get out of here!");
				currentPlayer.setjailStatus(false);
			} else {
				JOptionPane.showMessageDialog(null, "Oh man! DO NOT TRY TO PRISON BREAK");
				JOptionPane.showMessageDialog(null,
						currentPlayer.getname() + "GET A FINE OF $200 and cannot move this turn");
				currentPlayer.payMoney(200);

				if (currentPlayer.getbalance() < 0) {
					bankcrupt(currentPlayer, -1 * currentPlayer.getbalance());
				}

			}

		}

		nextPerson(currentPlayer, MG);
		updateAllPlayerPositionToken(MG);

		if (MG.getactivePlayers().size() < 2) {
			// end of game
			JOptionPane.showMessageDialog(null, "WINNER IS " + MG.getactivePlayers().get(0) + "!");
			dispose();
			return;
		}
		JOptionPane.showMessageDialog(null, allPlayers.get(MG.getactivePlayers().get(0)).getname() + "'s turn",
				"Information", JOptionPane.PLAIN_MESSAGE);
		currentPlayer = allPlayers.get(MG.getactivePlayers().get(0));
	}

	private void goToJailCard(Player currentPlayer, MonoplyGame MG) {
		currentPlayer.setposition(10);
		updateAllPlayerPositionToken(MG);

		if (currentPlayer.getnumOutOfJailCard() > 0) {
			currentPlayer.setposition(10);

			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null,
					"Is" + currentPlayer.getname() + " going to use the Get Out Of Jail card?", "Information",
					dialogButton);
			if (dialogResult == JOptionPane.YES_OPTION) {
				currentPlayer.setjailStatus(false);
				currentPlayer.setnumOutOfJailCard(currentPlayer.getnumOutOfJailCard() - 1);

			} else {
				JOptionPane.showMessageDialog(null, "What's wrong with you, you m***** f*****!");
				currentPlayer.setjailStatus(true);

			}

		} else {
			currentPlayer.setjailStatus(true);

		}
	}

	private void propertyTile(Player currentPlayer, MonoplyGame MG) {
		Property currentProperty = (Property) board.getTile(currentPlayer.getposition());
      boolean auction = false;

		// If the property does not have a owner
		if (currentProperty.getOwner().isEmpty()) {
      
         // AI encounters an ownerless property
         if (currentPlayer.getname().equals("Computer")) {
            if (currentPlayer.getbalance() >= currentProperty.getCost()) {
               currentProperty.setOwner(currentPlayer.getname());
   				currentProperty.buildHouse();
   				ArrayList<Property> arrP = new ArrayList<Property>();
   				arrP.add(currentProperty);
   				currentPlayer.payMoney(currentProperty.getCost());
   				if (currentPlayer.getproperty() == null) {
   					currentPlayer.setproperty(arrP);
   				} else {
   					currentPlayer.addproperty(currentProperty);
   				}
               JOptionPane.showMessageDialog(null, "I bought this Property!");
            } else {
               auction = true;
               JOptionPane.showMessageDialog(null, "I can't afford this..");
            }
         } else { // human player 
   			int dialogButton = JOptionPane.YES_NO_OPTION;
   			int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to buy this property?",
   					"Information", dialogButton);
   			if (dialogResult == JOptionPane.YES_OPTION && currentPlayer.getbalance() >= currentProperty.getCost()) {
   
   				currentProperty.setOwner(currentPlayer.getname());
   				currentProperty.buildHouse();
   				ArrayList<Property> arrP = new ArrayList<Property>();
   				arrP.add(currentProperty);
   				currentPlayer.payMoney(currentProperty.getCost());
   				if (currentPlayer.getproperty() == null) {
   					currentPlayer.setproperty(arrP);
   				} else {
   					currentPlayer.addproperty(currentProperty);
   				}
   			} else {
               auction = true;      // player cannot afford property
            }
         } 
         
         
         if (auction) {
				// Auction here
				Hashtable<Integer, String> givenMoney = new Hashtable<Integer, String>();
				for (int i = 0; i < MG.getactivePlayers().size(); i++) {
					String money = JOptionPane.showInputDialog(null,
							"What's " + MG.getactivePlayers().get(i) + " price?");
					if (!isNumeric(money)) {
						JOptionPane.showMessageDialog(null, "Invalid Price, give up this auction!");
						givenMoney.put(0, MG.getactivePlayers().get(i));

					} else if (Integer.parseInt(money) > allPlayers.get(MG.getactivePlayers().get(i)).getbalance()) {
						JOptionPane.showMessageDialog(null,
								currentPlayer.getname() + " cannot afford the price, give up this auction!");
						givenMoney.put(0, MG.getactivePlayers().get(i));
					} else {
						givenMoney.put(Integer.parseInt(money), MG.getactivePlayers().get(i));
					}

				}

				int maxPrice = 0;
				for (Integer currentPrice : givenMoney.keySet()) {
					if (maxPrice < currentPrice) {
						maxPrice = currentPrice;
					}
				}

				String newOwner = givenMoney.get(maxPrice);
				allPlayers.get(newOwner).payMoney(maxPrice);
				currentProperty.setOwner(newOwner);

				allPlayers.get(newOwner).addproperty(currentProperty);
				JOptionPane.showMessageDialog(null,
						newOwner + " is the new owner of " + currentProperty.getDescription());

			}
			showStatus();
		}
		// Owner is the current player
		else if (currentProperty.getOwner().equals(currentPlayer.getname())) {

			if (!currentProperty.isFullHouse()) {
				int dialogButton = JOptionPane.YES_NO_OPTION;

				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Would" + currentPlayer.getname() + " like to build one more house?", "Information",
						dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {

					if (currentPlayer.getbalance() > currentProperty.getCost()) {
						currentPlayer.payMoney(currentProperty.getCost());
						currentProperty.buildHouse();
					} else {
						JOptionPane.showMessageDialog(null,
								currentPlayer.getname() + " cannot afford the price, give up building!");
					}

				}
			} else {
				int dialogButton = JOptionPane.YES_NO_OPTION;

				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Would" + currentPlayer.getname() + " like to build a hotel?", "Information", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					if (currentPlayer.getbalance() > currentProperty.getCost()) {
						currentPlayer.payMoney(currentProperty.getCost());
						currentProperty.buildHouse();
					} else {
						JOptionPane.showMessageDialog(null,
								currentPlayer.getname() + " cannot afford the price, give up upgrading!");
					}

				}

			}
			showStatus();
		}
		// Owner is others
		else {
			String thisOwner = currentProperty.getOwner();
			allPlayers.get(thisOwner).getMoney(currentProperty.getRent());
			currentPlayer.payMoney(currentProperty.getRent());

			JOptionPane.showMessageDialog(null,
					"Player: " + currentPlayer.getname() + " pay rent to Player: " + currentProperty.getOwner());

			if (currentPlayer.getbalance() < 0) {
				bankcrupt(currentPlayer, -currentPlayer.getbalance());
			}
			showStatus();
		}
	}

	private void setButton(JPanel tempPanel, int flag, int minus) {
		JButton property = new JButton("Info");

		property.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Property currentProperty = (Property) board.getTile(flag - minus);
				JOptionPane.showMessageDialog(null,
						currentProperty.getDescription() + "\n" + "Owner: " + currentProperty.getOwner() + "\n"
								+ "Cost: " + currentProperty.getCost() + "\n" + "Rent: " + currentProperty.getRent()
								+ "\n" + "Number Of Houses: " + currentProperty.getNumOfHouses() + "\n"
								+ "Number Of Hotels: " + currentProperty.getNumOfHotels() + "\n",

						"Info", JOptionPane.PLAIN_MESSAGE);

			}
		});

		tempPanel.add(property);

	}

	private ArrayList<String> getnameOfTiles() {
		ArrayList<String> nameOfTiles = new ArrayList<String>();

		nameOfTiles.add("<html><h4>GO!<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Mediterranean <br>Avenue<br><br>M60<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Community <br>Chest<br></h4></html>");
		nameOfTiles.add("<html><h4>Baltic <br>Avenue<br><br>M60<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Income <br>Tax<br><br>PAY M200<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Reading <br>RailRoad<br><br>M200<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Oriental <br>Avenue<br><br>M100<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Chance<br></h4></html>");
		nameOfTiles.add("<html><h4>Vermont <br>Avenue<br><br>M100<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Connecticut <br>Avenue<br><br>M120<br><br></h4></html>");

		nameOfTiles.add("<html><h4>IN JAIL<br></h4></html>");
		nameOfTiles.add("null");

		nameOfTiles.add("<html><h4>St. Charles <br>Place<br><br>M140<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Electricity <br>Company<br><br>M150<br><br></h4></html>");
		nameOfTiles.add("<html><h4>States <br>Avenue<br><br>M140<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Virginia <br>Avenue<br><br>M160<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Pennsylvania <br>RR<br><br>M200<br><br></h4></html>");
		nameOfTiles.add("<html><h4>St. James <br>Place<br><br>M180<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Community <br>Chest<br></h4></html>");
		nameOfTiles.add("<html><h4>Tennessee <br>Avenue<br><br>M180<br><br></h4></html>");
		nameOfTiles.add("<html><h4>New York<br> Avenue<br><br>M200<br><br></h4></html>");

		nameOfTiles.add("<html><h4> Free <br> Parking <br></h4></html>");
		nameOfTiles.add("null");

		nameOfTiles.add("<html><h4> Kentucky <br> Avenue<br><br>M220<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Chance</h4></html>");
		nameOfTiles.add("<html><h4> Indiana <br> Avenue<br><br>M220<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Illinois <br> Avenue<br><br>M240<br><br></h4></html>");
		nameOfTiles.add("<html><h4> B&O Rail <br> Road<br><br>M200<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Atlantic <br> Avenue<br><br><br>M260<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Ventnor <br> Avenue<br><br>M260<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Water <br> Works<br><br>M150<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Marvin <br> Gardens<br><br>M280<br><br></h4></html>");
		nameOfTiles.add("<html><h4> GO TO <br> JAIL <br></h4></html>");
		nameOfTiles.add("null");

		nameOfTiles.add("<html><h4>Pacific <br>Avenue<br><br>M300<br><br></h4></html>");
		nameOfTiles.add("<html><h4>North Carolina <br>Avenue<br><br>M300<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Community <br>Chest<br></h4></html>");
		nameOfTiles.add("<html><h4>Pennsylvania <br>Avenue<br><br>M320<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Short Line <br>Station<br><br>M200<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Chance<br></h4></html>");
		nameOfTiles.add("<html><h4>Park <br>Place<br><br>M350<br><br></h4></html>");
		nameOfTiles.add("<html><h4>SUPER <br>TAX<br><br><br>PAY M60<br></h4></html>");
		nameOfTiles.add("<html><h4>Boardwalk<br><br>M400<br><br></h4></html>");

		nameOfTiles.add("null");
		// nameOfTiles.add("Free Parking (Just take a rest)");

		return nameOfTiles;
	}

	private boolean testEnding(MonoplyGame MG) {
		if (MG.getactivePlayers().size() < 2) {
			// end of game
			JOptionPane.showMessageDialog(null, "WINNER IS " + MG.getactivePlayers().get(0) + "!");
			dispose();
		}

		return false;

	}

	private ArrayList<String> getactualNameOfTiles() {
		ArrayList<String> nameOfTiles = new ArrayList<String>();

		nameOfTiles.add("<html><h4>GO!<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Mediterranean <br>Avenue<br><br>M60<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Community <br>Chest<br></h4></html>");
		nameOfTiles.add("<html><h4>Baltic <br>Avenue<br><br>M60<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Income <br>Tax<br><br>PAY M200<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Reading <br>RailRoad<br><br>M200<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Oriental <br>Avenue<br><br>M100<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Chance<br></h4></html>");
		nameOfTiles.add("<html><h4>Vermont <br>Avenue<br><br>M100<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Connecticut <br>Avenue<br><br>M120<br><br></h4></html>");

		nameOfTiles.add("<html><h4>IN JAIL<br></h4></html>");

		nameOfTiles.add("<html><h4>St. Charles <br>Place<br><br>M140<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Electricity <br>Company<br><br>M150<br><br></h4></html>");
		nameOfTiles.add("<html><h4>States <br>Avenue<br><br>M140<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Virginia <br>Avenue<br><br>M160<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Pennsylvania <br>RR<br><br>M200<br><br></h4></html>");
		nameOfTiles.add("<html><h4>St. James <br>Place<br><br>M180<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Community <br>Chest<br></h4></html>");
		nameOfTiles.add("<html><h4>Tennessee <br>Avenue<br><br>M180<br><br></h4></html>");
		nameOfTiles.add("<html><h4>New York<br> Avenue<br><br>M200<br><br></h4></html>");

		nameOfTiles.add("<html><h4> Free <br> Parking <br></h4></html>");

		nameOfTiles.add("<html><h4> Kentucky <br> Avenue<br><br>M220<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Chance</h4></html>");
		nameOfTiles.add("<html><h4> Indiana <br> Avenue<br><br>M220<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Illinois <br> Avenue<br><br>M240<br><br></h4></html>");
		nameOfTiles.add("<html><h4> B&O Rail <br> Road<br><br>M200<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Atlantic <br> Avenue<br><br><br>M260<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Ventnor <br> Avenue<br><br>M260<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Water <br> Works<br><br>M150<br><br></h4></html>");
		nameOfTiles.add("<html><h4> Marvin <br> Gardens<br><br>M280<br><br></h4></html>");
		nameOfTiles.add("<html><h4> GO TO <br> JAIL <br></h4></html>");

		nameOfTiles.add("<html><h4>Pacific <br>Avenue<br><br>M300<br><br></h4></html>");
		nameOfTiles.add("<html><h4>North Carolina <br>Avenue<br><br>M300<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Community <br>Chest<br></h4></html>");
		nameOfTiles.add("<html><h4>Pennsylvania <br>Avenue<br><br>M320<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Short Line <br>Station<br><br>M200<br><br></h4></html>");
		nameOfTiles.add("<html><h4>Chance<br></h4></html>");
		nameOfTiles.add("<html><h4>Park <br>Place<br><br>M350<br><br></h4></html>");
		nameOfTiles.add("<html><h4>SUPER <br>TAX<br><br><br>PAY M60<br></h4></html>");
		nameOfTiles.add("<html><h4>Boardwalk<br><br>M400<br><br></h4></html>");

		// nameOfTiles.add("Free Parking (Just take a rest)");
		return nameOfTiles;
	}

	private void paintTiles(ArrayList<String> nameOfTiles) {
		// Default Grid values
		int gridX = 0;
		int gridY = 0;

		for (int j = 0; j < 4; j++) {
			for (int i = 11; i > 0; i--) {
				JPanel tempPanel = new JPanel();
				JLabel label = new JLabel();

				switch (j) {
				case 2:// Top Spaces
					gridX = 11 - i;
					gridY = 0;
					label.setText(nameOfTiles.get(flag));
					// System.out.println(nameOfTiles.get(flag) + (j*10+i));
					/// s/bach/j/under/ykzhu/Downloads/question-mark_318-52837.jpg

					tempPanel.add(label);
					if (flag == 23 || flag == 25 || flag == 26) {
						tempPanel.setBackground(Color.RED);
						setButton(tempPanel, flag, 2);

					}
					if (flag == 28 || flag == 29 || flag == 31) {
						tempPanel.setBackground(Color.YELLOW);
						setButton(tempPanel, flag, 2);

					}

					if (nameOfTiles.get(flag) != "null") {
						tileLabels.add(label);
					}

					flag++;

					break;
				case 1:// Left Spaces
					gridX = 0;
					gridY = i - 1;

					label.setText(nameOfTiles.get(flag));
					tempPanel.add(label);

					if (flag == 12 || flag == 14 || flag == 15) {
						tempPanel.setBackground(Color.PINK);
						setButton(tempPanel, flag, 1);

					}

					if (flag == 17 || flag == 19 || flag == 20) {
						tempPanel.setBackground(Color.ORANGE);
						setButton(tempPanel, flag, 1);

					}

					if (nameOfTiles.get(flag) != "null") {
						tileLabels.add(label);
					}

					flag++;

					break;
				case 3:// Right Spaces
					gridX = 10;
					gridY = 11 - i;
					label.setText(nameOfTiles.get(flag));
					tempPanel.add(label);

					if (flag == 34 || flag == 35 || flag == 37) {
						tempPanel.setBackground(Color.GREEN);
						setButton(tempPanel, flag, 3);
					}

					if (flag == 40 || flag == 42) {
						tempPanel.setBackground(Color.BLUE);
						setButton(tempPanel, flag, 3);

					}

					if (nameOfTiles.get(flag) != "null") {
						tileLabels.add(label);
					}

					flag++;

					break;
				case 0:// Bottom Spaces
					gridX = i - 1;
					gridY = 10;

					label.setText(nameOfTiles.get(flag));
					tempPanel.add(label);
					if (flag == 6 || flag == 8 || flag == 9) {
						tempPanel.setBackground(Color.GRAY);
						setButton(tempPanel, flag, 0);

					}
					if (flag == 1 || flag == 3) {
						Color clr = new Color(205, 133, 63);
						tempPanel.setBackground(clr);
						setButton(tempPanel, flag, 0);

					}

					if (nameOfTiles.get(flag) != "null") {
						tileLabels.add(label);
					}

					flag++;

					break;
				}
				getContentPane().add(tempPanel,
						new GridBagConstraints(gridX, // XGridSpot
								gridY, // YGridSpot
								1, // XGridSpaces
								1, // YGridSpaces
								0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
								new Insets(0, 0, 0, 0), 0, 0));

				tempPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		}

	}

	private void paintInner(MonoplyGame MG, HashMap<String, Player> allPlayers) {

		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				// System.out.println("Hello World");
				gameMaxDuration = gameMaxDuration - 1;

				int mins_left = gameMaxDuration / 60;
				int sec_left = gameMaxDuration % 60;

				if (gameMaxDuration == 0) {
					JOptionPane.showMessageDialog(null, "Time is up");
					int maxBalance = 0;
					String winner = null;
					for (String s : allPlayers.keySet()) {
						if (allPlayers.get(s).getbalance() > maxBalance) {
							winner = s;
							maxBalance = allPlayers.get(s).getbalance();
						}
					}

					JOptionPane.showMessageDialog(null, "Winner is " + winner);

					dispose();
				}
				timerLabel.setText("Remaing Time: " + Integer.toString(mins_left) + ":" + Integer.toString(sec_left));
			}
		}, 0, 1000);

	}

	private void setUpGUI(MonoplyGame MG, HashMap<String, Player> allPlayers) {
		// Setup the Layout
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		GridBagLayout thisLayout = new GridBagLayout();
		thisLayout.rowWeights = new double[] { 0.1, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.1 };
		thisLayout.columnWeights = new double[] { 0.1, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.1 };
		getContentPane().setLayout(thisLayout);

		// paint tiles
		ArrayList<String> nameOfTiles = getnameOfTiles();
		paintTiles(nameOfTiles);

		// paint innner area
		paintInner(MG, allPlayers);

		//
		timerLabel.setText("Remaing Time: ");
		timerPanel.add(timerLabel);
		getContentPane().add(timerPanel,
				new GridBagConstraints(9, // XGridSpot
						1, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0)

		);
		//
		// player info label

		rollDice.add(diceButton);

		getContentPane().add(rollDice,
				new GridBagConstraints(9, // XGridSpot
						3, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0)

		);

		player_one_label.setText("");
		player_two_label.setText("");
		player_three_label.setText("");
		player_four_label.setText("");

		playerPanel1.add(player_one_label);
		playerPanel2.add(player_two_label);
		playerPanel3.add(player_three_label);
		playerPanel4.add(player_four_label);

		getContentPane().add(turnPanel,
				new GridBagConstraints(1, // XGridSpot
						5, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0));

		getContentPane().add(playerPanel1,
				new GridBagConstraints(1, // XGridSpot
						1, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0));
		getContentPane().add(playerPanel2,
				new GridBagConstraints(1, // XGridSpot
						2, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0));
		getContentPane().add(playerPanel3,
				new GridBagConstraints(1, // XGridSpot
						3, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0));
		getContentPane().add(playerPanel4,
				new GridBagConstraints(1, // XGridSpot
						4, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0));

		showStatus();

		pack();

		setSize(2000, 1500);
		setLocation(200, 200);

	}

	private String processTokenTileString(ArrayList<String> playerNames, String tileString) {
		String tokenizedTileString = "<html><h4>";

		for (String str : playerNames) {
			tokenizedTileString += str + ",";
		}

		tokenizedTileString += "<br>";

		tokenizedTileString += tileString.substring(10, tileString.length());

		return tokenizedTileString;
	}

	private void updateAllPlayerPositionToken(MonoplyGame MG) {
		ArrayList<String> nameOfTiles = new ArrayList<String>();
		nameOfTiles = getactualNameOfTiles();
		ArrayList<String> playersOnThisTile = new ArrayList<String>();
		boolean isNoPlayerOnTile;

		// reset all tile string, and set active player on it
		for (int i = 0; i < 40; i++) {
			String aTileText = nameOfTiles.get(i);
			playersOnThisTile.clear();
			isNoPlayerOnTile = true;

			for (String playerName : MG.getactivePlayers()) {
				HashMap<String, Player> allPlayers = MG.getallPlayers();

				if (allPlayers.get(playerName).getposition() == i) {
					playersOnThisTile.add(playerName);
					isNoPlayerOnTile = false;
				}
			}

			String newTileString = processTokenTileString(playersOnThisTile, aTileText);

			if (isNoPlayerOnTile) {
				tileLabels.get(i).setText(aTileText);
			} else {
				tileLabels.get(i).setText(newTileString);
			}
		}

	}
   
   
   private boolean addAI () {
      int decision = JOptionPane.showConfirmDialog(null, "Enable AI in this game?", "", JOptionPane.YES_NO_OPTION);
      return decision == JOptionPane.YES_OPTION;
   }

	public MonoplyGameGUI() {

		ArrayList<String> names = new ArrayList<String>();

		String time = JOptionPane.showInputDialog("Please input the game time(minute)");

		if (isNumeric(time)) {
			gameMaxDuration = Integer.parseInt(time) * 60;
		} else {
			JOptionPane.showInputDialog("illegal input");
			return;
		}
      
      boolean AI = addAI();
      
		String numOfPlayers = JOptionPane.showInputDialog("Please input the number of players(2-4)");
		MonoplyGame MG = new MonoplyGame(0, true);
		SetOfCards SOC = new SetOfCards();

		if (isNumeric(numOfPlayers)) {
			int n = Integer.parseInt(numOfPlayers);

			if (n < 2 || n > 4) {
				JOptionPane.showMessageDialog(null, "Invalid number of players");
				return;
			}

			for (int i = 0; i < Integer.parseInt(numOfPlayers); i++) {
				String name = JOptionPane.showInputDialog("Please input the name of the " + (i + 1) + " player");
            if (!names.contains(name) && !name.toLowerCase().equals("computer")) {
   				names.add(name);
   				Player player = new Player(name, 1000, true, 0, false, 0, null);
   				allPlayers.put(name, player);
   				MG.setnumOfPlayer(n);
            } else {
               JOptionPane.showMessageDialog(null, "Invalid Input! Enter another name!");
               i --;
            }
			}
         if (AI) {
            Player computer = new Player ("Computer", 1500, true, 0, false, 0, null);
            names.add("Computer");
            allPlayers.put ("Computer", computer);  
            MG.setnumOfPlayer(n+1);
         }
			MG.setactivePlayers(names);
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Input");
			return;
		}

		MG.setallPlayers(allPlayers);

		// paint UI
		try {
			setUpGUI(MG, allPlayers);

			updateAllPlayerPositionToken(MG);

			diceButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					ChanceCard currentCard = SOC.drawChanceCard();
					CommunityChestCard currentCard2 = SOC.drawCommunityChestCard();

					Player currentPlayer = allPlayers.get(MG.getactivePlayers().get(0));
					// ArrayList<String> nameOfTiles = new ArrayList<String>();
					// nameOfTiles = getnameOfTiles();

					// init player position
					turnLabel.setText("Current Turn:" + currentPlayer.getname());
					turnPanel.add(turnLabel);

					int face1 = 0, face2 = 0;

					if (currentPlayer.getjailStatus() == true) {
						jailStatus(currentPlayer, MG);

					} else {

						while (face1 == face2) {
                     
                     // mortgate
							if (currentPlayer.getMorDes() != null && !currentPlayer.getMorDes().isEmpty()) {

								int dialogButton = JOptionPane.YES_NO_OPTION;

								int dialogResult = JOptionPane.showConfirmDialog(null,
										"Are you going to get your motgage back?", "Information", dialogButton);
								if (dialogResult == JOptionPane.YES_OPTION) {
									String[] choice = currentPlayer.getMorDes()
											.toArray(new String[currentPlayer.getMorDes().size()]);

									String inpu = (String) JOptionPane.showInputDialog(null, "Choose now...",
											"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
																											// default
																											// icon
											choice, // Array of choices
											null); // Initial choice
									for (Property returnProperty : currentPlayer.getproperty()) {

										if (returnProperty.getDescription().equals(inpu)) {

											if (currentPlayer.getbalance() >= returnProperty.getCost()) {
												currentPlayer.payMoney(returnProperty.getCost());
												returnProperty.cancelMor();
												currentPlayer.removeMortgageProperty(returnProperty);
												break;
											} else {
												JOptionPane.showMessageDialog(null, "Not enough money");

											}

										}
									}
								}
							}

							String[] choices = currentPlayer.getAllDescriptions()
									.toArray(new String[currentPlayer.getAllDescriptions().size()]);
                     
                     // Computer starts to roll dice
                     if (currentPlayer.getname().equals("Computer")) {
                        String properties = "";
                        if (choices.length == 0) {
                           JOptionPane.showMessageDialog(null, "I do not have a property yet!", "AI's property",
                           JOptionPane.PLAIN_MESSAGE);
                        } else {
                           for (int i = 0; i < choices.length; i++) {
                              properties += choices[i]+'\n';
                           }
                           JOptionPane.showMessageDialog(null, "My properties:\n" + properties, "AI's property",
                           JOptionPane.PLAIN_MESSAGE);
                        }
                     } else {    // Human rolls dice
   							JOptionPane.showInputDialog(null, "Player: " + currentPlayer.getname(),
   									"Information" + currentPlayer.getname() + "'s properties",
   									JOptionPane.QUESTION_MESSAGE, null, // Use
   									// default
   									// icon
   									choices, // Array of choices
   									null); // Initial choice
                     }
							face1 = currentPlayer.throwDice()[0];
							face2 = currentPlayer.throwDice()[1];
                     if (currentPlayer.getname().equals("Computer")) {
                        JOptionPane.showMessageDialog(null, "I Rolled\n"+"dice1: " + face1 + "\n"+"dice2: " + face2,
                        "Roll Dice", JOptionPane.PLAIN_MESSAGE);
                     } else {
							   JOptionPane.showMessageDialog(null, "Face1:" + face1 + "\n" + "Face2: " + face2,
									"Roll Dice", JOptionPane.PLAIN_MESSAGE);
                     }
                     
							// remove player from its previous tile
							// <h5></h5>
							// see if player previous tile has any other person
							// System.out.println("all labees
							// count:"+tileLabels.get(1).getText());

							currentPlayer.move(face1 + face2);

							updateAllPlayerPositionToken(MG);

							if (currentPlayer.getposition() == 30) {
								JOptionPane.showMessageDialog(null, "You theif! Go to jail!", "Warning",
										JOptionPane.PLAIN_MESSAGE);
								currentPlayer.setposition(10);
								currentPlayer.setjailStatus(true);
								break;
							}

							updateAllPlayerPositionToken(MG);

							if (currentPlayer.getposition() == 7
									|| currentPlayer.getposition() == 22 | currentPlayer.getposition() == 36) {
								if (currentCard.isGoToJail()) {

									goToJailCard(currentPlayer, MG);

								} else if (currentCard.isGetOutOfJail()) {
									currentPlayer.setnumOutOfJailCard(currentPlayer.getnumOutOfJailCard() + 1);
								} else {

									if (currentCard.getInfluenceOthers()) {
										for (String Name : MG.getactivePlayers()) {
											if (!allPlayers.get(Name).equals(currentPlayer)) {
												System.out.println(Name + currentCard.getAmountChange());
												allPlayers.get(Name).payMoney(currentCard.getAmountChange());

												currentPlayer.getMoney(currentCard.getAmountChange());
												if (allPlayers.get(Name).getbalance() < 0) {
													bankcrupt(allPlayers.get(Name),
															-(allPlayers.get(Name).getbalance()));

												}

											}

											if (currentPlayer.getbalance() < 0) {
												bankcrupt(currentPlayer, -currentPlayer.getbalance());
											}

										}

									} else {
										currentPlayer.getMoney(currentCard.getAmountChange());
									}
								}

								JOptionPane.showMessageDialog(null, currentCard.getDescription());
								showStatus();
								testEnding(MG);

							} else if (currentPlayer.getposition() == 2 || currentPlayer.getposition() == 17
									|| currentPlayer.getposition() == 13) {
								if (currentCard2.isGoToJail()) {
									goToJailCard(currentPlayer, MG);

								} else if (currentCard2.isGetOutOfJail()) {
									currentPlayer.setnumOutOfJailCard(currentPlayer.getnumOutOfJailCard() + 1);

								} else {
									if (currentCard2.ifMove) {
										currentPlayer.move(currentCard2.getposMove());
									} else {
										currentPlayer.setposition(currentCard2.getJump());

									}
								}
								testEnding(MG);

							}
							showStatus();

							updateAllPlayerPositionToken(MG);

							switch (currentPlayer.getposition()) {

							case 4:
								currentPlayer.payMoney(200);
								if (currentPlayer.getbalance() < 0) {
									bankcrupt(currentPlayer, -currentPlayer.getbalance());

								}

								break;
							case 5:
								currentPlayer.getMoney(200);
								break;
							case 12:
								currentPlayer.getMoney(150);
								break;
							case 15:
								currentPlayer.getMoney(200);
								break;
							case 25:
								currentPlayer.getMoney(200);
								break;
							case 28:
								currentPlayer.getMoney(150);
								break;
							case 35:
								currentPlayer.getMoney(200);
								break;
							case 38:
								currentPlayer.payMoney(60);
								if (currentPlayer.getbalance() < 0) {
									bankcrupt(currentPlayer, -currentPlayer.getbalance());
								}
								break;
							case 20:
								break;

							}
							updateAllPlayerPositionToken(MG);
							showStatus();
							testEnding(MG);

							// If the current tile is property
							if (board.getTile(currentPlayer.getposition()) instanceof Property) {
								propertyTile(currentPlayer, MG);

							}

						}

						nextPerson(currentPlayer, MG);
						updateAllPlayerPositionToken(MG);

						testEnding(MG);

						JOptionPane.showMessageDialog(null,
								allPlayers.get(MG.getactivePlayers().get(0)).getname() + "'s turn", "Information",
								JOptionPane.PLAIN_MESSAGE);
						currentPlayer = allPlayers.get(MG.getactivePlayers().get(0));

					}

				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new MonoplyGameGUI().setVisible(true);
	}

}