import java.util.ArrayList;

public class SetOfCards {
	ArrayList<Card> cards;

	public SetOfCards() {

		cards = new ArrayList<Card>();

		// ---------------------------------- ChanceCards
		// ------------------------------------------

		cards.add(new ChanceCard("Advance to Go (Collect $200)", false, false, 200, false));
		cards.add(new ChanceCard("Advance to Illinois Ave.", false, false, 200, false));
		cards.add(new ChanceCard("Advance token to nearest Utility.", false, false, 300, false));
		cards.add(new ChanceCard("Advance to the nearest Railroad", false, false, 400, false));
		cards.add(new ChanceCard("Get a fine of $200", false, false, -200, false));
		cards.add(new ChanceCard("Get a fine of $500", false, false, -500, false));
		cards.add(new ChanceCard("Advance to St. Charles Place", false, false, 100, false));
		cards.add(new ChanceCard("Bank pays you dividend of $500", false, false, 500, false));
		cards.add(new ChanceCard("Get out of Jail free this card may be kept until needed", false, true, 0, false));
		cards.add(new ChanceCard("Go to jail you m***** f*****", false, true, 0, false));
		cards.add(new ChanceCard("Other player give you $100", false, false, 100, true));
		cards.add(new ChanceCard("Other player give you $200", false, false, 100, true));
		cards.add(new ChanceCard("Other player give you $300", false, false, 100, true));
		cards.add(new ChanceCard("you give each player $100", false, false, -100, true));
		cards.add(new ChanceCard("you give each player $200", false, false, -200, true));
		cards.add(new ChanceCard("you give each player $300", false, false, -300, true));

		// ---------------------------------- CommunityChestCards
		// ------------------------------------------

		cards.add(new CommunityChestCard("Move forward 3", false, false, 3, false, 0));
		cards.add(new CommunityChestCard("Move forward 4", false, false, 4, false, 0));

		cards.add(new CommunityChestCard("Move forward 6", false, false, 6, false, 0));

		cards.add(new CommunityChestCard("Move forward 10", false, false, 10, false, 0));

		cards.add(new CommunityChestCard("Move backward 3", false, false, -3, false, 0));
		cards.add(new CommunityChestCard("Move backward 4", false, false, -4, false, 0));
		cards.add(new CommunityChestCard("Move backward 8", false, false, -8, false, 0));

		cards.add(new CommunityChestCard("Get out of Jail free this card may be kept until needed", false, true, 0,
				false, 0));
		cards.add(new CommunityChestCard("Go to jail you m***** f*****", false, true, 0, false, 0));

		cards.add(new CommunityChestCard("Go to water works", false, false, 0, true, 28));
		cards.add(new CommunityChestCard("Go to the start point", false, false, 0, true, 0));
		cards.add(new CommunityChestCard("Go to New York Avenue", false, false, 0, true, 20));
		cards.add(new CommunityChestCard("Go to electricity company", false, false, 0, true, 12));

		cards.add(new CommunityChestCard("Go to super line station", false, false, 0, true, 35));

		cards.add(new CommunityChestCard("Go to illinois Avenue", false, false, 0, true, 24));
		cards.add(new CommunityChestCard("Visiting Jail", false, false, 0, true, 10));

	}

}