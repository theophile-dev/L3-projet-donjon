package fil.coo.actions;

import fil.coo.Direction;
import fil.coo.Display;
import fil.coo.EmptyListException;
import fil.coo.ForbiddenDirectionException;
import fil.coo.Player;
import fil.coo.Room;

public class Move extends Action {
	
	private Display display;

	public Move(Player player) {
		super(player);
		this.display = Display.getInstance();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Move to a choosen next room";
	}

	@Override
	public void act() {
		Player player = this.getPlayer();
		Room currentRoom = player.getCurrentRoom();
		this.display.simpleMessage("Choose a direction :");
		try {
			Direction chosenDirection = this.display.listChoose(currentRoom.getAvailableDirection());
			player.setCurrentRoom(currentRoom.getNextRoom(chosenDirection));
			player.getCurrentRoom().onEnter();
		} catch (EmptyListException e) {
			System.out.println("No direction available");
			e.printStackTrace();
		} catch (ForbiddenDirectionException e) {
			// TODO Auto-generated catch block
			System.out.println("The chosen direction point toward a non-existing room");
			e.printStackTrace();
		}
	}

	@Override
	public boolean canBePerform() {
		Room currentRoom = this.getPlayer().getCurrentRoom();
		boolean hasAtLeastOneExit = currentRoom.getNeighbors().size() != 0;
		boolean noMonsterAlive = currentRoom.getMonsters().size() == 0;
		return hasAtLeastOneExit && noMonsterAlive;
	}

}
