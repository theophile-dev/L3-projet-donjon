package fil.coo;

import java.util.ArrayList;

import fil.coo.actions.Action;
import fil.coo.actions.LookAround;
import fil.coo.actions.Move;

public class Player extends Character {

	private Room currentRoom;
	private ArrayList<Action> actionList;
	private ArrayList<Action> availableActions;
	private Display display;
	private boolean hasWon;

	public Player(String name, int pv, int force, int po,Room currentRoom) {
		super(name, pv, force, po);
		this.display = Display.getInstance();
		this.hasWon = false;
		this.currentRoom = currentRoom;
		this.actionList = new ArrayList<Action>();
		this.actionList.add(new LookAround(this));
		this.actionList.add(new Move(this));
		this.updateAvailableAction();
		
	}
	
	public boolean hasPlayerWon() {
		return this.currentRoom instanceof DonjonExit;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public void act() {
		try {
			display.listChoose(availableActions).act();
		} catch (EmptyListException e) {
			System.out.println("There is no available action");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Action> getAvailableActions(){
		return this.availableActions;
	}
	
	public void updateAvailableAction() {
		this.availableActions = new ArrayList<Action>();
		for(Action action: this.actionList) {
			if (action.canBePerform()) {
				this.availableActions.add(action);
			}
			
		}
	}
	
	
	


}
