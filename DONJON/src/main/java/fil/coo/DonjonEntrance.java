package fil.coo;

public class DonjonEntrance extends Room {

	public DonjonEntrance() {
		super();

	}

	@Override
	public void onEnter() {
		this.display.simpleMessage("Welcome to the Donjon's Entrance");
	}

	@Override
	public String getDescription() {
		return "Entrance";
	}
	
}
