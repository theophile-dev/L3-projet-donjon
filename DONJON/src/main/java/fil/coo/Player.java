package fil.coo;

public class Player extends Character {

	private Room currentRoom; 

	public Player(String name, int pv, int force, int po) {
		super(name, pv, force, po);
		
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}



}
