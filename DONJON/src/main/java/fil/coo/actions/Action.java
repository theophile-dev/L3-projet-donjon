package fil.coo.actions;

import fil.coo.Displayable;
import fil.coo.Player;

public abstract class Action implements Displayable {
	private Player player;

	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player
	 */
	public Action(Player player) {
		this.player = player;
	}
	
	public abstract boolean canBePerform();
	
	public abstract void act();
	
	
}
