package fil.coo;

public class DonjonExit extends Room {

	public DonjonExit() {
		super();

	}

	@Override
	public void onEnter() {
		this.display.simpleMessage("You Won !");
	}

	@Override
	public String getDescription() {
		return "Exit";
	}
	
}
