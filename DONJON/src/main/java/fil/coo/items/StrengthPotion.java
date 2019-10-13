package fil.coo.items;

import fil.coo.Player;

public class StrengthPotion extends Item {
	private int strengthGiven;
		
	/**
	 * @param strengthGiven
	 */
	public StrengthPotion(int strengthGiven) {
		super();
		this.strengthGiven = strengthGiven;
	}

	@Override
	public String getDescription() {
		return "Strength potion : Give " + this.strengthGiven + " strength";
	}

	@Override
	public void use(Player player) {
		super.use(player);
		player.setStrength(player.getStrength() + this.strengthGiven);
	}

	@Override
	protected String useMessage() {
		return "You gained " + this.strengthGiven + " strength";
	}

	@Override
	protected String getName() {
		return "Strength potion";
	}
}
