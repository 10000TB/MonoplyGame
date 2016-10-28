package Game;

public abstract class Card {

	private String description;
	private boolean goToJail;
	private boolean getOutOfJail;
	private boolean isUsed;

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

	public void setNotUsed() {
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

	public void setUsed() {
		this.isUsed = true;
	}

}
