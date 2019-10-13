package fil.coo.items;

import fil.coo.Player;

public class Purse extends Item {
	private int gold;
		
	/**
	 * @param gold
	 */
	public Purse(int gold) {
		super();
		this.gold = gold;
	}


	@Override
	public String getDescription() {
		return "Purse : Give " + this.gold + " gold";
	}



	@Override
	public void use(Player player) {
		super.use(player);
		player.setGold(player.getGold() + this.gold);
	}


	@Override
	protected String useMessage() {
		return "You gained " + this.gold + " gold";
	}


	@Override
	protected String getName() {
		return "Purse";
	}

}
