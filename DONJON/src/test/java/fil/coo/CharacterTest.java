package fil.coo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class CharacterTest {

	protected Character character1;
	protected Character character2;

	@Before
	protected abstract void createCharacters();

	/**
	 * Test if the characters deal "Force" damage to other characters
	 */
	@Test
	public void attackDealDamageTest() {
		int character2PvBeforeAttack = character2.getPv();
		character1.attack(character2);
		assertEquals(character2PvBeforeAttack - character1.getForce(), character2.getPv());
	}

}
