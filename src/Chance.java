
public class Chance extends Card{
	
	private int numOfSteps;
	private int targetTile;
	
	Chance(){
		this.setDescription("");
		this.setGoToJail(false);
		this.setUsed(false);
		this.setAmountChange(0);
		this.setInfluenceOthers(false);
		this.setHouseCost(-1);
		this.setHotelCost(-1);
		this.setNumOfSteps(0);
		this.setTargetTile(-1);
	}

	
	Chance(String description,boolean goToJail,boolean getOutOfJail,boolean isUsed,int amountChange,boolean influenceOthers,int houseCost,int hotelCost, int numOfSteps, int targetTile){
		this.setDescription(description);
		this.setGoToJail(goToJail);
		this.setUsed(isUsed);
		this.setAmountChange(amountChange);
		this.setInfluenceOthers(influenceOthers);
		this.setHouseCost(houseCost);
		this.setHotelCost(hotelCost);
		this.setNumOfSteps(numOfSteps);
		this.setTargetTile(targetTile);
	}

	public int getNumOfSteps() {
		return numOfSteps;
	}

	public void setNumOfSteps(int numOfSteps) {
		this.numOfSteps = numOfSteps;
	}

	public int getTargetTile() {
		return targetTile;
	}

	public void setTargetTile(int targetTile) {
		this.targetTile = targetTile;
	}

}
