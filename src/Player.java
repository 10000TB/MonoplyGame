import java.util.*;

public class Player {
	private String name;
	private int balance;
	private boolean financialStatus;
	private int position;
	private boolean jailStatus;
	private int numOutOfJailCard;
	private ArrayList<Property> property;
	private ArrayList<String> allDes = new ArrayList<String>();

	Player(String name, int balance, boolean financialStatus, int position, boolean jailStatus, int numOutOfJailCard,
			ArrayList<Property> property) {
		this.name = name;
		this.balance = balance;
		this.financialStatus = financialStatus;
		this.position = position;
		this.jailStatus = jailStatus;
		this.numOutOfJailCard = numOutOfJailCard;
		this.property = property;
		if (property != null && !property.isEmpty()) {
			for (Property p : property) {
				allDes.add(p.getDescription());
			}
		}
	}

	public int[] throwDice() {
		int[] nums = new int[2];

		Dice dice1 = new Dice();
		Dice dice2 = new Dice();

		nums[0] = dice1.randomNumberGenerator();
		nums[1] = dice2.randomNumberGenerator();

		return nums;
	}

	public void move(int position) {
		this.setposition((this.position + position) % 40);
	}

	public void payMoney(int money) {
		this.setbalance(this.getbalance() - money);

	}

	public void getMoney(int money) {
		this.setbalance(this.getbalance() + money);
	}

	/**
	 * Class Essentials Setters and getters
	 */
	public String getname() {
		return this.name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getbalance() {
		return this.balance;
	}

	public void setbalance(int balance) {
		this.balance = balance;
	}

	public boolean getfinancialStatus() {
		return this.financialStatus;
	}

	public void setfinancialStatus(boolean financialStatus) {
		this.financialStatus = financialStatus;
	}

	public int getposition() {
		return this.position;
	}

	public void setposition(int position) {
		this.position = position;
	}

	public boolean getjailStatus() {
		return this.jailStatus;
	}

	public void setjailStatus(boolean jailStatus) {
		this.jailStatus = jailStatus;
	}

	public int getnumOutOfJailCard() {
		return this.numOutOfJailCard;
	}

	public void setnumOutOfJailCard(int numOutOfJailCard) {
		this.numOutOfJailCard = numOutOfJailCard;
	}

	public ArrayList<Property> getproperty() {
		return this.property;
	}

	public void setproperty(ArrayList<Property> property) {
		this.property = property;
		for (Property p : property) {
			System.out.println(p.getDescription());
			System.out.println(allDes.size());
			allDes.add(p.getDescription());
		}
	}

	public void addproperty(Property newProperty) {
		this.property.add(newProperty);
		allDes.add(newProperty.getDescription());
	}

	public void removeproperty(Property oldProperty) {
		for (int i = 0; i < this.property.size(); i++) {
			if (this.property.get(i).equals(oldProperty)) {
				this.property.remove(i);
				allDes.remove(oldProperty.getDescription());
				break;
			}
		}
	}

	public ArrayList<String> getAllDescriptions() {
		return allDes;
	}

}
