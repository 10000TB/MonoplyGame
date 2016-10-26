public class MonoplyGameGUI extends JFrame {

	// global game constraints
	int gameMaxDuration = 10 * 60;// maximum game duration 10*60 seconds

	// UI elements
	// timer panel
	JPanel timerPanel = new JPanel();
	JLabel timerLabel = new JLabel();
	// player info
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

	// player panel
	JPanel player_one_panel = new JPanel();
	JPanel player_two_panel = new JPanel();
	JPanel player_three_panel = new JPanel();
	JPanel player_four_panel = new JPanel();

	// rollDice panel
	JPanel rollDice = new JPanel();
	JButton diceButton = new JButton("Rolling Dice");
	// JButton player_one_info = new JButton("player 1 Info");

	//
	Board board = new Board();
	int flag = 0;

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	Image bg = new ImageIcon("/s/bach/j/under/ykzhu/Downloads/question-mark_318-52837.jpg").getImage();
