
public abstract class Card {
	
	private String description;
	private boolean goToJail;
	private boolean getOutOfJail;
	private boolean isUsed;
	private int amountChange;
	private boolean influenceOthers;
	private int houseCost;
	private int hotelCost;
	
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

	public boolean isGetOutOfJail() {
		return getOutOfJail;
	}

	public void setGetOutOfJail(boolean getOutOfJail) {
		this.getOutOfJail = getOutOfJail;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public int getAmountChange() {
		return amountChange;
	}

	public void setAmountChange(int amountChange) {
		this.amountChange = amountChange;
	}

	public boolean isInfluenceOthers() {
		return influenceOthers;
	}

	public void setInfluenceOthers(boolean influenceOthers) {
		this.influenceOthers = influenceOthers;
	}

	public int getHouseCost() {
		return houseCost;
	}

	public void setHouseCost(int houseCost) {
		this.houseCost = houseCost;
	}

	public int getHotelCost() {
		return hotelCost;
	}

	public void setHotelCost(int hotelCost) {
		this.hotelCost = hotelCost;
	}
	

}
