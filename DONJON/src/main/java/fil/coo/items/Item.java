package fil.coo.items;

import fil.coo.Display;
import fil.coo.Displayable;
import fil.coo.Player;

public abstract class Item implements Displayable {
	protected Display display;
	public Item() {
		this.display = Display.getInstance();
	}
	
	protected abstract String useMessage();
	protected abstract String getName();
	public void use(Player player) {
		this.display.simpleMessage(player.getName() + " use [" + this.getName() + "]");
		this.display.simpleMessage(this.useMessage());
	}
	
}
