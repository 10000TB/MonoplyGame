import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.net.URL;

public class MonoplyGameGUI extends JFrame {

public static void main(String[] args) {
    new MonoplyGameGUI().setVisible(true);
}
public static boolean isNumeric(String str)  
{  
  try  
  {  
    double d = Double.parseDouble(str);  
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;  
}
Image bg = new ImageIcon("/s/bach/j/under/ykzhu/Downloads/question-mark_318-52837.jpg").getImage();

public void paintComponent(Graphics g) {
    g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
}

//private static ImageIcon createImageIcon(String path, 
//	      String description) {
//	      java.net.URL imgURL = GridBagLayoutExample.class.getResource(path);
//	      if (imgURL != null) {
//	         return new ImageIcon(imgURL, description);
//	      } else {            
//	         System.err.println("Couldn't find file: " + path);
//	         return null;
//	      }
//	   }   

public MonoplyGameGUI() {

	ArrayList<String> names = new ArrayList<String>();
	String numOfPlayers = JOptionPane.showInputDialog("Please input the number of players");
	
	if (isNumeric(numOfPlayers)){
		for (int i = 0; i < Integer.parseInt(numOfPlayers); i++)
		{
			String name = JOptionPane.showInputDialog("Please input the name of each player");
			names.add(name);
		}
		 
	}
	else{
		JOptionPane.showMessageDialog(null, "FUCK YOU THE WRONG INPUT");
		return;
		
	}
	
	System.out.println(names);



	
    try {
        //Setup the Layout
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        GridBagLayout thisLayout = new GridBagLayout();
        thisLayout.rowWeights = new double[] { 0.1, 0.05, 0.05,
                0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.1 };
        thisLayout.columnWeights = new double[] { 0.1, 0.05, 0.05,
                0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.05, 0.1 };
        getContentPane().setLayout(thisLayout);

        //Default Grid values
        int gridX = 0;
        int gridY = 0;        


//        JButton javaButton = new JButton("Submit", icon);
//        JButton cancelButton = new JButton("Cancel", icon);
       
        //Add Panels for Each of the four sides
        ArrayList<String> nameOfTiles = new ArrayList<String>();
        nameOfTiles.add("<html><h4> Free <br> Parking </h4></html>");
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
        
        
        nameOfTiles.add("<html><h4>New York<br> Avenue<br><br><br>M200</h4></html>");
        nameOfTiles.add("<html><h4>Tennessee <br>Avenue<br><br><br>M180</h4></html>");
        nameOfTiles.add("<html><h4>Community <br>Chest</h4></html>");
        nameOfTiles.add("<html><h4>St. James <br>Place<br><br><br>M180</h4></html>");
        nameOfTiles.add("<html><h4>Pennsylvania <br>RR<br><br><br>M200</h4></html>");
        nameOfTiles.add("<html><h4>Virginia <br>Avenue<br><br><br>M160</h4></html>");
        nameOfTiles.add("<html><h4>States <br>Avenue<br><br><br>M140</h4></html>");
        nameOfTiles.add("<html><h4>Electricity <br>Company<br><br><br>M150</h4></html>");
        nameOfTiles.add("<html><h4>St. Charles <br>Place<br><br><br>M140</h4></html>");
        nameOfTiles.add("<html><h4>IN JAIL</h4></html>");

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
        nameOfTiles.add("<html><h4>GO!</h4></html>");

        nameOfTiles.add("null");
        nameOfTiles.add("<html><h4>Connecticut <br>Avenue<br><br><br>M120</h4></html>"); 
        nameOfTiles.add("<html><h4>Vermont <br>Avenue<br><br><br>M100</h4></html>");
        nameOfTiles.add("<html><h4>Chance</h4></html>");
        nameOfTiles.add("<html><h4>Oriental <br>Avenue<br><br><br>M100</h4></html>");
        nameOfTiles.add("<html><h4>Reading <br>RailRoad<br><br><br>M200</h4></html>");
        nameOfTiles.add("<html><h4>Income <br>Tax<br><br><br>PAY M200</h4></html>");
        nameOfTiles.add("<html><h4>Baltic <br>Avenue<br><br><br>M60</h4></html>");
        nameOfTiles.add("<html><h4>Community <br>Chest</h4></html>");
        nameOfTiles.add("<html><h4>Mediterranean <br>Avenue<br><br><br>M60</h4></html>");
        nameOfTiles.add("null");

        //nameOfTiles.add("Free Parking (Just take a rest)");
        System.out.println(nameOfTiles.size());
        
        int flag = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 11; i++) {
                JPanel tempPanel = new JPanel();
             	JLabel label = new JLabel();

                switch(j)
                {
                case 0://Top Spaces
                    gridX = i;
                    gridY = 0;
                    label.setText(nameOfTiles.get(flag));
                    //System.out.println(nameOfTiles.get(flag) + (j*10+i));
                    flag++;
                    ///s/bach/j/under/ykzhu/Downloads/question-mark_318-52837.jpg
                    
                    tempPanel.add(label);
                    if (flag == 2 ||flag == 4 || flag == 5)
                    {
                    	tempPanel.setBackground(Color.RED);  
                    }
                    if (flag == 7 ||flag == 8 || flag == 10)
                    {
                    	tempPanel.setBackground(Color.YELLOW);  
                    }
//                    if (flag == 3){
//                    	//tempPanel.setLayout(new BorderLayout());
//                    	 //tempPanel.add(new GridBagLayoutExample(), BorderLayout.CENTER);
//                    }
               
                    

                    break;
                case 1://Left Spaces
                    gridX = 0;
                    gridY = i;
                    
                    label.setText(nameOfTiles.get(flag));
                    tempPanel.add(label);
                    flag++;
                    
                    if (flag == 13 ||flag == 14 || flag == 16)
                    {
                    	tempPanel.setBackground(Color.ORANGE);  
                    }
                    
                    if (flag == 18 ||flag == 19 || flag == 21)
                    {
                    	tempPanel.setBackground(Color.PINK);  
                    }

                    
                    break;
                case 2://Right Spaces
                    gridX = 10;
                    gridY = i;
                    label.setText(nameOfTiles.get(flag));
                    tempPanel.add(label);
                    flag++;
                    
                    if (flag == 24 ||flag == 25 || flag == 27)
                    {
                    	tempPanel.setBackground(Color.GREEN);  
                    }
                    
                    if (flag == 30 ||flag == 32)
                    {
                    	tempPanel.setBackground(Color.BLUE);  
                    }
                    break;
                case 3://Bottom Spaces
                    gridX = i;
                    gridY = 10;
                    
                    label.setText(nameOfTiles.get(flag));
                    tempPanel.add(label);
                    flag++;
                    if (flag == 35 ||flag == 36 || flag == 38)
                    {
                    	tempPanel.setBackground(Color.GRAY);  
                    }
                    if (flag == 41 ||flag == 43)
                    {
                    	Color clr = new Color(205,133,63);
                    	tempPanel.setBackground(clr);  
                    }
                    break;
                }
                getContentPane().add(tempPanel,
                        new GridBagConstraints(gridX,// XGridSpot
                                gridY,// YGridSpot
                                1,// XGridSpaces
                                1,// YGridSpaces
                                0.0, 0.0, GridBagConstraints.CENTER,
                                GridBagConstraints.BOTH,//Fill
                                new Insets(0, 0, 0, 0), 0, 0)
                        
                        

                        );
                
                tempPanel.setBorder(BorderFactory
                        .createLineBorder(Color.BLACK));
                

            }
        }

        {// Main Inner Area Notice Starts at (1,1) and takes up 11x11
        	
            JPanel innerPanel = new JPanel();
            //JButton diceButton = new JButton("Roll Dice");


            getContentPane().add(
                    innerPanel,
                    new GridBagConstraints(11,
                            1,
                            11,
                            11,
                            3.0, 3.0,
                            GridBagConstraints.CENTER,
                            GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
            JButton diceButton = new JButton("Roll Dice");
            diceButton.addActionListener(new ActionListener()
            {
              public void actionPerformed(ActionEvent e)
              {
            	  //GEIVE THE RANDOM NUMBER
            	  JOptionPane.showMessageDialog(null, "Give the random number", "Roll Dice", JOptionPane.PLAIN_MESSAGE);

              }
            });
            JButton takeTurnButton = new JButton("Take Turn");
            takeTurnButton.addActionListener(new ActionListener()
            {
              public void actionPerformed(ActionEvent e)
              {
            	  //GEIVE THE RANDOM NUMBER
            	  JOptionPane.showMessageDialog(null, "Take Turn", "Take Turn", JOptionPane.PLAIN_MESSAGE);

              }
            });
            
            JButton showCurrentBalance = new JButton("Show Status");
            showCurrentBalance.addActionListener(new ActionListener()
            {
              public void actionPerformed(ActionEvent e)
              {
            	  //GEIVE THE RANDOM NUMBER
            	  JOptionPane.showMessageDialog(null, "Show Balance", "Show Balance", JOptionPane.PLAIN_MESSAGE);

              }
            });
            
            diceButton.setBounds(100, 100, 200, 100);
            takeTurnButton.setBounds(100, 250, 200, 100);
            showCurrentBalance.setBounds(100, 400, 200, 100);

            innerPanel.add(diceButton);
            innerPanel.add(takeTurnButton);
            innerPanel.add(showCurrentBalance);

            JTextArea textArea = new JTextArea(
            	    "Roll the dice"
            	);
            	textArea.setFont(new Font("Serif", Font.ITALIC, 16));
            	textArea.setWrapStyleWord(true);
            	JScrollPane areaScrollPane = new JScrollPane(textArea);
            	areaScrollPane.setVerticalScrollBarPolicy(
            	                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            	textArea.setEditable(false);
            innerPanel.add(textArea);
            
            innerPanel.setLayout(null);


            
            
        }
        pack();



        setSize(2000, 2000);
        setLocation(200, 100);

        



    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
