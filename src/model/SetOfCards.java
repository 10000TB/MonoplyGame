package model;

import java.util.ArrayList;

public class SetOfCards {
	private ArrayList<ChanceCard> chanceCards;
	private ArrayList<CommunityChestCard> communityChestCards;

	public SetOfCards() {

		chanceCards = new ArrayList<ChanceCard>();
		communityChestCards = new ArrayList<CommunityChestCard>();
		// ----------------------------------
		// ChanceCards------------------------------------------

		chanceCards.add(new ChanceCard("Advance to Go (Collect $200)", false, false, 200, false));
		chanceCards.add(new ChanceCard("Advance to Illinois Ave(Collect $200).", false, false, 200, false));
		chanceCards.add(new ChanceCard("Advance token to nearest Utility(Collect $300).", false, false, 300, false));
		chanceCards.add(new ChanceCard("Advance to the nearest Railroad(Collect $400)", false, false, 400, false));
		chanceCards.add(new ChanceCard("Get a fine of $200", false, false, -200, false));
		chanceCards.add(new ChanceCard("Get a fine of $500", false, false, -500, false));
		chanceCards.add(new ChanceCard("Advance to St. Charles Place(Collect $100)", false, false, 100, false));
		chanceCards.add(new ChanceCard("Bank pays you dividend of $500", false, false, 500, false));
		chanceCards
				.add(new ChanceCard("Get out of Jail free this card may be kept until needed", false, true, 0, false));
		chanceCards.add(new ChanceCard("Go to jail you m***** f*****", false, true, 0, false));
		chanceCards.add(new ChanceCard("Other player give you $100", false, false, 100, true));
		chanceCards.add(new ChanceCard("Other player give you $200", false, false, 200, true));
		chanceCards.add(new ChanceCard("Other player give you $300", false, false, 300, true));
		chanceCards.add(new ChanceCard("you give each player $100", false, false, -100, true));
		chanceCards.add(new ChanceCard("you give each player $200", false, false, -200, true));
		chanceCards.add(new ChanceCard("you give each player $300", false, false, -300, true));

		// ----------------------------------
		// CommunityChestCards------------------------------------------

		communityChestCards.add(new CommunityChestCard("Move forward 3", false, false, 3, true, 0));
		communityChestCards.add(new CommunityChestCard("Move forward 4", false, false, 4, true, 0));

		communityChestCards.add(new CommunityChestCard("Move forward 6", false, false, 6, true, 0));

		communityChestCards.add(new CommunityChestCard("Move forward 10", false, false, 10, true, 0));

		communityChestCards.add(new CommunityChestCard("Move backward 3", false, false, -3, true, 0));
		communityChestCards.add(new CommunityChestCard("Move backward 4", false, false, -4, true, 0));
		communityChestCards.add(new CommunityChestCard("Move backward 8", false, false, -8, true, 0));

		communityChestCards.add(new CommunityChestCard("Get out of Jail free this card may be kept until needed", false,
				true, 0, false, 0));
		communityChestCards.add(new CommunityChestCard("Go to jail you m***** f*****", false, true, 0, false, 0));

		communityChestCards.add(new CommunityChestCard("Go to water works", false, false, 0, false, 28));
		communityChestCards.add(new CommunityChestCard("Go to the start point", false, false, 0, false, 0));
		communityChestCards.add(new CommunityChestCard("Go to New York Avenue", false, false, 0, false, 20));
		communityChestCards.add(new CommunityChestCard("Go to electricity company", false, false, 0, false, 12));

		communityChestCards.add(new CommunityChestCard("Go to super line station", false, false, 0, false, 35));

		communityChestCards.add(new CommunityChestCard("Go to illinois Avenue", false, false, 0, false, 24));
		communityChestCards.add(new CommunityChestCard("Visiting Jail", false, false, 0, false, 10));

	}

	public ChanceCard drawChanceCard() {
		return this.chanceCards.get((int) (Math.random() * 15 + 1));
	}

	public CommunityChestCard drawCommunityChestCard() {
		return this.communityChestCards.get((int) (Math.random() * 15 + 1));
	}

	public ChanceCard getChanceCard(int index) {
		return chanceCards.get(index);
	}

	public CommunityChestCard getCommunityChestCards(int index) {
		return communityChestCards.get(index);
	}

}