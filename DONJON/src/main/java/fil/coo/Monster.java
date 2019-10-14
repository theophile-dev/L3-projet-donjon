package fil.coo;

public class Monster extends Character implements Displayable{

	/**
	 * Create a Monster
	 * @param name, his name
	 * @param pv, his life points
	 * @param force, his strength
	 * @param po, his gold
	 */
	public Monster(String name, int hp, int strength, int gold) {
		super(name, hp, strength, gold);
		
	}

	@Override
	public String getDescription() {
		return getName();
	}
}
