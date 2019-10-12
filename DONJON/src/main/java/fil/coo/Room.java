package fil.coo;

import java.util.ArrayList;
import java.util.HashMap;

import fil.coo.directions.Direction;
import fil.coo.items.Item;

public class Room implements Displayable{
	private ArrayList<Monster> monsters;
	private ArrayList<Item> items;
	private HashMap<Direction, Room> neighbors;
	private Display display;
		
	public Room() {
		this.display = Display.getInstance();
		this.neighbors = new HashMap<Direction, Room>();
		this.monsters = new ArrayList<Monster>();
		this.items = new ArrayList<Item>();
	}


	public HashMap<Direction, Room> getNeighbors() {
		return neighbors;
	}

	public void describeSurrounding() {
		this.display.displayList(monsters);
		this.display.displayList(items);
		this.display.displayHashMap(neighbors);
	}
	
	public void addMonster(Monster monster) {
		monsters.add(monster);
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeMonster(Monster monster) {
		monsters.remove(monster);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public Room getNextRoom(Direction direction) throws ForbiddenDirectionException {
		Room nextRoom = this.neighbors.get(direction);
		if (nextRoom == null) {
			throw new ForbiddenDirectionException("There is not next room for this direction");
		}
		return nextRoom;
	}
	
	// This need optimization because each time the function is called a new ArrayList is created
	public ArrayList<Direction> getAvailableDirection(){
		return new ArrayList<Direction>(this.neighbors.keySet());
	}
	
	public void setNeighbor(Direction direction, Room neighbor) {
		this.neighbors.put(direction, neighbor);
	}

	@Override
	public String getDescription() {
		return "Room";
	}
}
