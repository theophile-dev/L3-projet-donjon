package fil.coo;

public class Monster extends Character implements Displayable{

	public Monster(String name, int hp, int strength, int gold) {
		super(name, hp, strength, gold);
		
	}

	@Override
	public String getDescription() {
		return getName();
	}
}
