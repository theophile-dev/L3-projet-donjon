package fil.coo;

import java.util.ArrayList;

public class DonjonBuilder {
	
	private ArrayList<Room> donjon;
	private DonjonEntrance donjonEntrance;
	private DonjonExit donjonExit;
	
	public DonjonBuilder(int numberOfRoom) {
		donjon = new ArrayList<Room>();
		donjonEntrance = new DonjonEntrance();
		Room room2 = new Room();
		Room room3 = new Room();
		donjonExit = new DonjonExit();
		DonjonExit donjonExit = new DonjonExit();
		donjonEntrance.setNeighbor(Direction.RIGHT, room2);
		room2.setNeighbor(Direction.LEFT, donjonEntrance);
		room2.setNeighbor(Direction.DOWN, room3);
		room3.setNeighbor(Direction.UP, room3);
		room3.setNeighbor(Direction.RIGHT, donjonExit);
		

		
	}
	
	public Room getDonjonEntrance(){
		return donjonEntrance;
	}
	
	public Room getDonjonExit(){
		return donjonExit;
	}
	
	
}
