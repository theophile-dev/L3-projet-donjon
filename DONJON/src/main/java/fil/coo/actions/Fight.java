package fil.coo.actions;

import fil.coo.Display;
import fil.coo.EmptyListException;
import fil.coo.Monster;
import fil.coo.Player;
import fil.coo.Room;

public class Fight extends Action {

	private Display display;
	
	public Fight(Player player) {
		super(player);
		this.display = Display.getInstance();
	}

	@Override
	public String getDescription() {
		return "Fight a monster";
	}

	@Override
	/**
	 * Fight can only be perform if there is at least on Monster in the Room
	 */
	public boolean canBePerform() {
		return this.getPlayer().getCurrentRoom().getMonsters().size() > 0;
	}

	@Override
	/**
	 * Make a fight with the player and a monster choose from a list
	 */
	public void act() {
		Player player = this.getPlayer();
		Room currentRoom = player.getCurrentRoom();
		try {
			Monster target = this.display.listChoose(currentRoom.getMonsters());
			while (!(player.isDead() || target.isDead())) {
				this.display.simpleMessage(player.getName() + " HP :" + player.getHp() + " | " + target.getName()
						+ " HP :" + target.getHp());
				player.attack(target);
				if (!target.isDead()) {
					target.attack(player);
				}
			}
			if (player.isDead()) {
				player.setDeathOrigin("Killed by " + target.getName());
			}
			if (target.isDead()) {
				this.display.simpleMessage(player.getName() + " Killed " + target.getName());
				player.setGold(player.getGold() + target.getGold());
				currentRoom.removeMonster(target);
			}

		} catch (EmptyListException e) {
			System.out.println("There is no monster to fight");
			e.printStackTrace();
		}
	}

}
