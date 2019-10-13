package fil.coo.actions;

import fil.coo.Player;

public class LookAround extends Action {

	public LookAround(Player player) {
		super(player);
	}

	@Override
	public String getDescription() {
		return "Look around to see what's in the room";
	}

	@Override
	/**
	 * Player get information about the Room
	 */
	public void act() {
		this.getPlayer().getCurrentRoom().describeSurrounding();
	}

	@Override
	/**
	 * LookAround can always be perform
	 */
	public boolean canBePerform() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
