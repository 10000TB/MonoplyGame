package Game;

public abstract class Card {
	
	private String description;
	private boolean goToJail;
	private boolean getOutOfJail;
	private boolean isUsed;
//	private int amountChange;
//	private boolean influenceOthers;
//	private int houseCost;
//	private int hotelCost;
	
//	public Card(String description, boolean goToJail, boolean getOutOfJail){
//		this.description = description;
//		this.isUsed = false;
//		this.goToJail = goToJail;
//		this.getOutOfJail = getOutOfJail;
//	}
		
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isGoToJail() {
		return goToJail;
	}

	public void setGoToJail(boolean goToJail) {
		this.goToJail = goToJail;
	}
	
	public void setNotUsed(){
		this.isUsed = false;
	}

	public boolean isGetOutOfJail() {
		return getOutOfJail;
	}

	public void setGetOutOfJail(boolean getOutOfJail) {
		this.getOutOfJail = getOutOfJail;
	}

	public boolean isUsed() {
		return isUsed;
	}
	
	public void setUsed(){
		this.isUsed = true;
	}
	

}
