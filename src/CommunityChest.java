
public class CommunityChest extends Card{
	
	CommunityChest(){
		this.setDescription("");
		this.setGoToJail(false);
		this.setUsed(false);
		this.setAmountChange(0);
		this.setInfluenceOthers(false);
		this.setHouseCost(-1);
		this.setHotelCost(-1);
	}

	
	CommunityChest(String description,boolean goToJail,boolean getOutOfJail,boolean isUsed,int amountChange,boolean influenceOthers,int houseCost,int hotelCost){
		this.setDescription(description);
		this.setGoToJail(goToJail);
		this.setUsed(isUsed);
		this.setAmountChange(amountChange);
		this.setInfluenceOthers(influenceOthers);
		this.setHouseCost(houseCost);
		this.setHotelCost(hotelCost);
	}

}
