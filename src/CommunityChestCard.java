
public class CommunityChestCard extends Card {

	private int posMove;
	boolean ifMove;
	private int posJump;

	public CommunityChestCard(String Des, boolean isGoToJail, boolean isGetOutOfJail, int posMove, boolean ifMove,
			int posJump) {

		super.setDescription(Des);
		super.setGoToJail(isGoToJail);
		super.setGetOutOfJail(isGetOutOfJail);
		super.setNotUsed();
		this.posMove = posMove;
		this.ifMove = ifMove;
		this.posJump = posJump;


	}

	public int getposMove() {
		return posMove;
	}

	public int getJump(){
		return posJump;
	}
	
	public boolean ifMove() {
		return ifMove;
	}
	

}
