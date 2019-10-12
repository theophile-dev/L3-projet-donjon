package fil.coo.actions;

import fil.coo.Display;
import fil.coo.EmptyListException;
import fil.coo.ForbiddenDirectionException;
import fil.coo.Player;
import fil.coo.Room;
import fil.coo.directions.Direction;

public class Move extends Action {
	
	private Display display;

	public Move(Player player) {
		super(player);
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
		try {
			Direction chosenDirection = this.display.listChoose(currentRoom.getAvailableDirection());
			player.setCurrentRoom(currentRoom.getNextRoom(chosenDirection));
		} catch (EmptyListException e) {
			System.out.println("No direction available");
			e.printStackTrace();
		} catch (ForbiddenDirectionException e) {
			// TODO Auto-generated catch block
			System.out.println("The chosen direction point toward a non-existing room");
			e.printStackTrace();
		}
	}

}
