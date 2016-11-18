package model;

public class ChanceCard extends Card {

	private int amountChange;
	private boolean influenceOthers;

	public ChanceCard(String Des, boolean isGoToJail, boolean isGetOutOfJail, int amountChange, boolean affectOthers) {

		super.setDescription(Des);
		super.setGoToJail(isGoToJail);
		super.setGetOutOfJail(isGetOutOfJail);
		super.setNotUsed();
		this.amountChange = amountChange;
		this.influenceOthers = affectOthers;

	}

	public int getAmountChange() {

		return amountChange;
	}

	public void setAmountChange(int amountChange) {
		System.out.println(amountChange);
		this.amountChange = amountChange;
	}

	public boolean getInfluenceOthers() {
		return influenceOthers;
	}

}
