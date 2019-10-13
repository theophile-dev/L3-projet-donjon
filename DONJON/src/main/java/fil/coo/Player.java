package fil.coo;

import java.util.ArrayList;

import fil.coo.actions.Action;
import fil.coo.actions.Fight;
import fil.coo.actions.LookAround;
import fil.coo.actions.Move;

public class Player extends Character {

	private Room currentRoom;
	private ArrayList<Action> actionList;
	private ArrayList<Action> availableActions;
	private String deathOrigin;
	private boolean hasWon;

	public Player(String name, int pv, int force, int po,Room currentRoom) {
		super(name, pv, force, po);
		this.display = Display.getInstance();
		this.hasWon = false;
		this.currentRoom = currentRoom;
		this.actionList = new ArrayList<Action>();
		this.actionList.add(new LookAround(this));
		this.actionList.add(new Move(this));
		this.actionList.add(new Fight(this));
		this.deathOrigin = "Unknown";
		this.updateAvailableAction();
		
	}
	
	/**
	 * Return the player's death origin
	 * @return this.deathOrigin, the death origin
	 */
	public String getDeathOrigin() {
		return deathOrigin;
	}
	
	/**
	 * Set the player's death origin
	 * @param deathOrigin, the death origin
	 */
	public void setDeathOrigin(String deathOrigin) {
		this.deathOrigin = deathOrigin;
	}

	/**
	 * Check if the player has won the game
	 * @return 
	 */
	public boolean hasPlayerWon() {
		return this.currentRoom instanceof DonjonExit;
	}
	
	/**
	 * Give the player's current room
	 * @return this.current
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	/**
	 * Set the player's current room
	 * @param currentRoom
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	/**
	 * Display player's available actions
	 */
	public void act() {
		try {
			display.listChoose(availableActions).act();
		} catch (EmptyListException e) {
			System.out.println("There is no available action");
			e.printStackTrace();
		}
	}
	
	/** 
	 * Return player's available actions
	 * @return this.availableActions
	 */
	public ArrayList<Action> getAvailableActions(){
		return this.availableActions;
	}
	
	/**
	 * Update player's available actions
	 */
	public void updateAvailableAction() {
		this.availableActions = new ArrayList<Action>();
		for(Action action: this.actionList) {
			if (action.canBePerform()) {
				this.availableActions.add(action);
			}
			
		}
	}
}
