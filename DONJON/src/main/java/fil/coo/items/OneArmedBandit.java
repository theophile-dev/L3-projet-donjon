package fil.coo.items;

import fil.coo.Player;

public class OneArmedBandit extends Item {
	private int goldCost;
	private ItemGenerator itemGenerator;
	private Item generatedItem;
	/**
	 * @param goldCost
	 */
	public OneArmedBandit(int goldCost) {
		super();
		this.goldCost = goldCost;
		this.itemGenerator = ItemGenerator.getInstance();
	}

	@Override
	public String getDescription() {
		return "A one-armed bandit that ask you for " + this.goldCost + " gold";
	}


	@Override
	public void use(Player player) {
		if (player.getGold() >= this.goldCost) {
			this.generatedItem = itemGenerator.getRandomBanditItem();
			super.use(player);
			this.generatedItem.use(player);
		} else {
			this.display.simpleMessage(player.getName() + " don't have enougth money");
		}
	}

	@Override
	protected String useMessage() {
		return "You received a " + this.generatedItem.getName() + "\n" + this.getName() +" : " + this.getDescription();
		
	}

	@Override
	protected String getName() {
		return "One-armed bandit";
	}
}
