package fil.coo.actions;

import fil.coo.Display;
import fil.coo.EmptyListException;
import fil.coo.Player;
import fil.coo.Room;
import fil.coo.items.Item;

public class Use extends Action {
	private Display display;

	public Use(Player player) {
		super(player);
		this.display = Display.getInstance();
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Use an Item";
	}

	@Override
	public boolean canBePerform() {
		return this.getPlayer().getCurrentRoom().getItems().size() > 0;
	}

	@Override
	public void act() {
		Player player = this.getPlayer();
		Room currentRoom = player.getCurrentRoom();
		try {
			Item chosenItem = this.display.listChoose(currentRoom.getItems());
			chosenItem.use(player);
			currentRoom.removeItem(chosenItem);
			player.displayStats();
			
		} catch (EmptyListException e) {
			System.out.println("There is no item to use");
			e.printStackTrace();
		}
	}

}
