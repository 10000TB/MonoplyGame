import java.util.*;

public class Player {
	private String name;
	private int balance;
	private boolean financialStatus;
	private int position;
	private boolean jailStatus;
	private int numOutOfJailCard;
	private int[] property;
	
	Player(String name, int balance, boolean financialStatus, int position, boolean jailStatus, int numOutOfJailCard, int[] property){
		this.name = name;
		this.balance = balance;
		this.financialStatus = financialStatus;
		this.position = position;
		this.jailStatus = jailStatus;
		this.numOutOfJailCard = numOutOfJailCard;
		this.property = property;
	}
	
	public int[] throwDice(){
		int[] nums = new int[2];
		
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		
		nums[0] = dice1.randomNumberGenerator();
		nums[1] = dice2.randomNumberGenerator();
		
		return nums;
	}
	
	public void move(int position){
		this.setposition((this.position + position)%40);
	}
	
	public void payMoney(int money){
		this.setbalance(this.getbalance() - money);
		
	}
	
	public void getMoney(int money){
		this.setbalance(this.getbalance() + money);
	}
	
	/**
	 * Class Essentials
	 * Setters and getters
	 * */
	public String getname(){
		return this.name;
	}
	public void setname(String name){
		this.name = name;
	}
	public int getbalance(){
		return this.balance;
	}
	public void setbalance(int balance){
		this.balance = balance;
	}
	public boolean getfinancialStatus(){
		return this.financialStatus;
	}
	public void setfinancialStatus(boolean financialStatus){
		this.financialStatus = financialStatus;
	}
	public int getposition(){
		return this.position;
	}
	public void setposition(int position){
		this.position = position;
	}
	public boolean getjailStatus(){
		return this.jailStatus;
	}
	public void setjailStatus(boolean jailStatus){
		this.jailStatus = jailStatus;
	}
	public int getnumOutOfJailCard(){
		return this.numOutOfJailCard;
	}
	public void setnumOutOfJailCard(int numOutOfJailCard){
		this.numOutOfJailCard = numOutOfJailCard;
	}
	public int[] getproperty(){
		return this.property;
	}
	public void setproperty(int[] property){
		this.property = property;
	}
	
}
