package fil.coo;

public class Monster extends Character implements Displayable{

	public Monster(String name, int pv, int force, int po) {
		super(name, pv, force, po);
		
	}

	@Override
	public String getDescription() {
		return getName();
	}
}
