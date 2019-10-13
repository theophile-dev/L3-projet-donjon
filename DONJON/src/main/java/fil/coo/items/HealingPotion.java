package fil.coo.items;

import fil.coo.Player;

public class HealingPotion extends Item {
	private int hpGiven;
	
	/**
	 * @param hpGiven
	 */
	public HealingPotion(int hpGiven) {
		super();
		this.hpGiven = hpGiven;
	}

	@Override
	public String getDescription() {
		return "Healing Potion : Heal the target " + this.hpGiven + " hp";
	}

	@Override
	protected String useMessage() {
		return "You gained " + this .hpGiven + " hp";
	}
	
 
	@Override
	public void use(Player player) {
		super.use(player);
		player.setHp(player.getHp() + this.hpGiven);
	}

	@Override
	protected String getName() {
		return "Healing potion";
	}
}
