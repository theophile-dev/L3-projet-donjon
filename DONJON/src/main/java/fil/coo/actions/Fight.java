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
	public boolean canBePerform() {
		return this.getPlayer().getCurrentRoom().getMonsters().size() > 0;
	}

	@Override
	public void act() {
		Player player = this.getPlayer();
		Room currentRoom = player.getCurrentRoom();
		try {
			Monster target = this.display.listChoose(currentRoom.getMonsters());
			while(!(player.isDead() || target.isDead())) {
				this.display.simpleMessage(player.getName() + " HP :" + player.getHp() +" | " + target.getName() + " HP :" + target.getHp());
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
				currentRoom.removeMonster(target);
			}
			
		} catch (EmptyListException e) {
			System.out.println("There is no monster to fight");
			e.printStackTrace();
		}
	}

}
