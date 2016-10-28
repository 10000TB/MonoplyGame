package JunitTest;

import static org.junit.Assert.*;


import org.junit.Test;
import Game.*;

public class SetOfCardsTest {

	
	// test drawChanceCard()
	@Test
	public void drawChanceCardtest() {
		SetOfCards cards = new SetOfCards();
		ChanceCard c0 = cards.drawChanceCard();		
		ChanceCard c1 = cards.drawChanceCard();
		ChanceCard c2 = cards.drawChanceCard();
		ChanceCard c3 = cards.drawChanceCard();
		ChanceCard c4 = cards.drawChanceCard();
		ChanceCard c5 = cards.drawChanceCard();
		ChanceCard c6 = cards.drawChanceCard();
		ChanceCard c7 = cards.drawChanceCard();
		ChanceCard c8 = cards.drawChanceCard();
		ChanceCard c9 = cards.drawChanceCard();
		
		assertTrue(chanceCardsFound(c0));
		assertTrue(chanceCardsFound(c1));
		assertTrue(chanceCardsFound(c2));
		assertTrue(chanceCardsFound(c3));
		assertTrue(chanceCardsFound(c4));
		assertTrue(chanceCardsFound(c5));
		assertTrue(chanceCardsFound(c6));
		assertTrue(chanceCardsFound(c7));
		assertTrue(chanceCardsFound(c8));
		assertTrue(chanceCardsFound(c9));		
	}
	
	
	// test drawCommunityChestCard()
	@Test
	public void drawCommunityChestCardtest() {
		SetOfCards cards = new SetOfCards();
		CommunityChestCard c0 = cards.drawCommunityChestCard();		
		CommunityChestCard c1 = cards.drawCommunityChestCard();	
		CommunityChestCard c2 = cards.drawCommunityChestCard();	
		CommunityChestCard c3 = cards.drawCommunityChestCard();	
		CommunityChestCard c4 = cards.drawCommunityChestCard();	
		CommunityChestCard c5 = cards.drawCommunityChestCard();	
		CommunityChestCard c6 = cards.drawCommunityChestCard();	
		CommunityChestCard c7 = cards.drawCommunityChestCard();	
		CommunityChestCard c8 = cards.drawCommunityChestCard();	
		CommunityChestCard c9 = cards.drawCommunityChestCard();	
		
		assertTrue(communityChestCardFound(c0));
		assertTrue(communityChestCardFound(c1));
		assertTrue(communityChestCardFound(c2));
		assertTrue(communityChestCardFound(c3));
		assertTrue(communityChestCardFound(c4));
		assertTrue(communityChestCardFound(c5));
		assertTrue(communityChestCardFound(c6));
		assertTrue(communityChestCardFound(c7));
		assertTrue(communityChestCardFound(c8));
		assertTrue(communityChestCardFound(c9));		
	}
	
	
	
	public boolean chanceCardsFound (ChanceCard c) {
		SetOfCards cards = new SetOfCards();
		
		for (int i = 0; i < 16; i++) {
			if (cards.getChanceCard(i).getDescription().equals((c.getDescription()))) {
				return true;
			}
		}
		return false;		
	}
	
	public boolean communityChestCardFound (CommunityChestCard c) {
		SetOfCards cards = new SetOfCards();
		
		for (int i = 0; i < 16; i++) {
			if (cards.getCommunityChestCards(i).getDescription().equals((c.getDescription()))) {
				return true;
			}
		}
		return false;		
	}
	
	
	

}