package JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import Game.Dice;

public class DiceTest {

	@Test
	public void boardInitTesrandomNumberGenerator_normalt() {
		Dice dice = new Dice();
		
		int face = dice.randomNumberGenerator();
	
		assertTrue(face>=1 && face<=6);
	}
	
}
