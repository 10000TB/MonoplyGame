import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MonoplyGameGUI extends JFrame {

	//global game constraints
	int gameMaxDuration = 10*60;//maximum game duration 10*60 seconds
	
	//UI elements
	//timer panel
	JPanel timerPanel = new JPanel();
	JLabel timerLabel = new JLabel();
	//player info
	JPanel playerPanel1 = new JPanel();
	JPanel playerPanel2 = new JPanel();
	JPanel playerPanel3 = new JPanel();
	JPanel playerPanel4 = new JPanel();
	
	JLabel player_one_label = new JLabel();
	JLabel player_two_label = new JLabel();	
	JLabel player_three_label = new JLabel();
	JLabel player_four_label = new JLabel();
	
	JPanel turnPanel = new JPanel();
	JLabel turnLabel = new JLabel();
	
	//player panel
	JPanel player_one_panel = new JPanel();
	JPanel player_two_panel = new JPanel();
	JPanel player_three_panel = new JPanel();	
	JPanel player_four_panel = new JPanel();
	//
	Board board = new Board();
	int flag = 0;
	Player currentPlayer;
	

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	Image bg = new ImageIcon("/s/bach/j/under/ykzhu/Downloads/question-mark_318-52837.jpg").getImage();

	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
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
	
	private ArrayList<String> getnameOfTiles(){
		ArrayList<String> nameOfTiles = new ArrayList<String>();

		nameOfTiles.add("<html><h4>GO!<br></h4></html>");
		nameOfTiles.add("<html>David<br><h4>Mediterranean <br>Avenue<br><br><br>M60</h4></html>");
		nameOfTiles.add("<html><h4>Community <br>Chest</h4></html>");
		nameOfTiles.add("<html><h4>Baltic <br>Avenue<br><br><br>M60</h4></html>");
		nameOfTiles.add("<html><h4>Income <br>Tax<br><br><br>PAY M200</h4></html>");
		nameOfTiles.add("<html><h4>Reading <br>RailRoad<br><br><br>M200</h4></html>");
		nameOfTiles.add("<html><h4>Oriental <br>Avenue<br><br><br>M100</h4></html>");
		nameOfTiles.add("<html><h4>Chance</h4></html>");
		nameOfTiles.add("<html><h4>Vermont <br>Avenue<br><br><br>M100</h4></html>");
		nameOfTiles.add("<html><h4>Connecticut <br>Avenue<br><br><br>M120</h4></html>");

		nameOfTiles.add("<html><h4>IN JAIL</h4></html>");
		nameOfTiles.add("null");

		nameOfTiles.add("<html><h4>St. Charles <br>Place<br><br><br>M140</h4></html>");
		nameOfTiles.add("<html><h4>Electricity <br>Company<br><br><br>M150</h4></html>");
		nameOfTiles.add("<html><h4>States <br>Avenue<br><br><br>M140</h4></html>");
		nameOfTiles.add("<html><h4>Virginia <br>Avenue<br><br><br>M160</h4></html>");
		nameOfTiles.add("<html><h4>Pennsylvania <br>RR<br><br><br>M200</h4></html>");
		nameOfTiles.add("<html><h4>St. James <br>Place<br><br><br>M180</h4></html>");
		nameOfTiles.add("<html><h4>Community <br>Chest</h4></html>");
		nameOfTiles.add("<html><h4>Tennessee <br>Avenue<br><br><br>M180</h4></html>");
		nameOfTiles.add("<html><h4>New York<br> Avenue<br><br><br>M200</h4></html>");

		nameOfTiles.add("<html><h4> Free <br> Parking </h4></html>");
		nameOfTiles.add("null");

		nameOfTiles.add("<html><h4> Kentucky <br> Avenue<br><br><br>M220</h4></html>");
		nameOfTiles.add("<html><h4> Chance</h4></html>");
		nameOfTiles.add("<html><h4> Indiana <br> Avenue<br><br><br>M220</h4></html>");
		nameOfTiles.add("<html><h4> Illinois <br> Avenue<br><br><br>M240</h4></html>");
		nameOfTiles.add("<html><h4> B&O Rail <br> Road<br><br><br>M200</h4></html>");
		nameOfTiles.add("<html><h4> Atlantic <br> Avenue<br><br><br>M260</h4></html>");
		nameOfTiles.add("<html><h4> Ventnor <br> Avenue<br><br><br>M260</h4></html>");
		nameOfTiles.add("<html><h4> Water <br> Works<br><br><br>M150</h4></html>");
		nameOfTiles.add("<html><h4> Marvin <br> Gardens<br><br><br>M280</h4></html>");
		nameOfTiles.add("<html><h4> GO TO <br> JAIL </h4></html>");
		nameOfTiles.add("null");

		nameOfTiles.add("<html><h4>Pacific <br>Avenue<br><br><br>M300</h4></html>");
		nameOfTiles.add("<html><h4>North Carolina <br>Avenue<br><br><br>M300</h4></html>");
		nameOfTiles.add("<html><h4>Community <br>Chest</h4></html>");
		nameOfTiles.add("<html><h4>Pennsylvania <br>Avenue<br><br><br>M320</h4></html>");
		nameOfTiles.add("<html><h4>Short Line <br>Station<br><br><br>M200</h4></html>");
		nameOfTiles.add("<html><h4>Chance</h4></html>");
		nameOfTiles.add("<html><h4>Park <br>Place<br><br><br>M350</h4></html>");
		nameOfTiles.add("<html><h4>SUPER <br>TAX<br><br><br>PAY M60</h4></html>");
		nameOfTiles.add("<html><h4>Boardwalk<br><br><br>M400</h4></html>");

		nameOfTiles.add("null");
		// nameOfTiles.add("Free Parking (Just take a rest)");
		
		return nameOfTiles;
	}
	
	private void paintTiles(ArrayList<String> nameOfTiles){
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
					flag++;

					break;
				}
				getContentPane().add(tempPanel,
						new GridBagConstraints(gridX, // XGridSpot
								gridY, // YGridSpot
								1, // XGridSpaces
								1, // YGridSpaces
								0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
								new Insets(0, 0, 0, 0), 0, 0)

				);

				tempPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			}
		}

	}
	
	private void paintInner(MonoplyGame MG, HashMap<String, Player> allPlayers){
		// Main Inner Area Notice Starts at (1,1) and takes up 11x11
		System.out.println("**");

		int gh = 0;
		
		currentPlayer = allPlayers.get(MG.getactivePlayers().get(0));

		JPanel innerPanel = new JPanel();       

		JButton diceButton = new JButton("Roll Dice");
		
		diceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// GEIVE THE RANDOM NUMBER
				int face1 = 0, face2 = 0;
				
				while (face1 == face2) {
					face1 = currentPlayer.throwDice()[0];
					face2 = currentPlayer.throwDice()[1];
					JOptionPane.showMessageDialog(null, "Face1:" + face1 + "\n" + "Face2: " + face2,
							"Roll Dice", JOptionPane.PLAIN_MESSAGE);
					
					currentPlayer.move(face1 + face2);
					
					// if community chest
					if (currentPlayer.getposition() == 2 || currentPlayer.getposition() == 17
							|| currentPlayer.getposition() == 33) {
						// need to be implemented
					}

					// if chance chest card
					if (currentPlayer.getposition() == 7 || currentPlayer.getposition() == 22
							|| currentPlayer.getposition() == 36) {
						// need to be implemented
					}
					switch (currentPlayer.getposition()) {
					
					case 4:
						currentPlayer.payMoney(200);
						;
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
						break;
					case 20:
						break;
					}

					if (board.getTile(currentPlayer.getposition()) instanceof Property) {

						Property currentProperty = (Property) board.getTile(currentPlayer.getposition());

						if (currentProperty.getOwner().isEmpty()) {
							int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult = JOptionPane.showConfirmDialog(null,
									"Would you like to buy this property?", "Warning", dialogButton);
							if (dialogResult == JOptionPane.YES_OPTION
									&& currentPlayer.getbalance() >= currentProperty.getCost()) {

								currentProperty.setOwner(currentPlayer.getname());
								currentPlayer.payMoney(currentProperty.getCost());

							} else {

							}
						}

					}
					
				}
				MG.getactivePlayers().remove(0);
				//allPlayers.get(MG.getactivePlayers().get(1));
				if (currentPlayer.getfinancialStatus()) {
					MG.getactivePlayers().add(currentPlayer.getname());
				}
				JOptionPane.showMessageDialog(null, allPlayers.get(MG.getactivePlayers().get(0)).getname()+"'s turn",
						"Warning", JOptionPane.PLAIN_MESSAGE);
				currentPlayer = allPlayers.get(MG.getactivePlayers().get(0));

			}
			
		});

		JButton showCurrentBalance = new JButton("Show Status");
		showCurrentBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String output = "";
				for (String name : allPlayers.keySet()) {
					output += "Player: " + name + "       " + "current balance: "
							+ allPlayers.get(name).getbalance() + "\n";
				}
				JOptionPane.showMessageDialog(null, output, "Show Balance",
						JOptionPane.PLAIN_MESSAGE);

			}
		});

		diceButton.setBounds(100, 100, 150, 50);
		showCurrentBalance.setBounds(100, 300, 150, 50);

		innerPanel.add(diceButton);
		innerPanel.add(showCurrentBalance);

		getContentPane().add(innerPanel, new GridBagConstraints(11, 1, 10, 7, 2.0, 2.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));					
		
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    @Override
		    public void run() {
//		       System.out.println("Hello World");
		       gameMaxDuration = gameMaxDuration-1;
		       
				int mins_left = gameMaxDuration / 60;
				int sec_left = gameMaxDuration % 60;
				timerLabel.setText("Remaing Time: " + Integer.toString(mins_left) + ":" + Integer.toString(sec_left));
		    }
		}, 0, 1000);
		
		while (MG.getactivePlayers().size() > 1 && gh < 10) {
								
			
			
			
			JTextArea textArea = new JTextArea("Roll the dice");
			textArea.setFont(new Font("Serif", Font.ITALIC, 16));
			textArea.setWrapStyleWord(true);
			JScrollPane areaScrollPane = new JScrollPane(textArea);
			areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			textArea.setEditable(false);
			innerPanel.add(textArea);

			innerPanel.setLayout(null);

			
			System.out.println(currentPlayer.getname());
			gh++;

		}
	}
	
	private void setUpGUI(MonoplyGame MG, HashMap<String, Player> allPlayers){
		// Setup the Layout
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		GridBagLayout thisLayout = new GridBagLayout();
		thisLayout.rowWeights = new double[] { 0.1, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.1 };
		thisLayout.columnWeights = new double[] { 0.1, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.1 };
		getContentPane().setLayout(thisLayout);
		
		//paint tiles
		ArrayList<String> nameOfTiles = getnameOfTiles();
		paintTiles(nameOfTiles);
		
		//paint innner area
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
		//player info label
		player_one_label.setText("");
		player_two_label.setText("");
		player_three_label.setText("");
		player_four_label.setText("");
		
		playerPanel1.add(player_one_label);
		playerPanel2.add(player_two_label);
		playerPanel3.add(player_three_label);
		playerPanel4.add(player_four_label);
		
		turnLabel.setText("Current Turn:");
		turnPanel.add(turnLabel);
		
		getContentPane().add(turnPanel,
				new GridBagConstraints(1, // XGridSpot
						5, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0)
		);		
		
		getContentPane().add(playerPanel1,
				new GridBagConstraints(1, // XGridSpot
						1, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0)
		);
		getContentPane().add(playerPanel2,
				new GridBagConstraints(1, // XGridSpot
						2, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0)
		);		
		getContentPane().add(playerPanel3,
				new GridBagConstraints(1, // XGridSpot
						3, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0)
		);
		getContentPane().add(playerPanel4,
				new GridBagConstraints(1, // XGridSpot
						4, // YGridSpot
						1, // XGridSpaces
						1, // YGridSpaces
						0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, // Fill
						new Insets(0, 0, 0, 0), 0, 0)
		);
		
		int player_cnt = 0;
		for (String key: allPlayers.keySet()){
			player_cnt++;
			switch(player_cnt){
				case 1:
					player_one_label.setText(allPlayers.get(key).getname()+":"+allPlayers.get(key).getbalance()+"     ");
					break;
				case 2:
					player_two_label.setText(allPlayers.get(key).getname()+":"+allPlayers.get(key).getbalance()+"     ");
					break;
				case 3:
					player_three_label.setText(allPlayers.get(key).getname()+":"+allPlayers.get(key).getbalance()+"     ");
					break;
				
				case 4:
					player_four_label.setText(allPlayers.get(key).getname()+":"+allPlayers.get(key).getbalance()+"     ");
					break;
					
				default:
					break;
			}
		}
		
		
		pack();

		setSize(2000, 1500);
		setLocation(200, 200);
		
	}

	
	

	public MonoplyGameGUI() {

		ArrayList<String> names = new ArrayList<String>();
		String numOfPlayers = JOptionPane.showInputDialog("Please input the number of players");
		HashMap<String, Player> allPlayers = new HashMap<String, Player>();
		MonoplyGame MG = new MonoplyGame(0, true);

		if (isNumeric(numOfPlayers)) {
			int n = Integer.parseInt(numOfPlayers);

			for (int i = 0; i < Integer.parseInt(numOfPlayers); i++) {
				String name = JOptionPane.showInputDialog("Please input the name of each player");
				names.add(name);
				Player player = new Player(name, 1500, true, 0, false, 0, null);
				allPlayers.put(name, player);
				MG.setnumOfPlayer(n);
			}
			MG.setactivePlayers(names);
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Input");
			return;
		}
		
		//paint UI
		try { setUpGUI(MG, allPlayers); } catch (Exception e) { e.printStackTrace(); }
	}
	
	public static void main(String[] args) {
		new MonoplyGameGUI().setVisible(true);
	}

	
}
