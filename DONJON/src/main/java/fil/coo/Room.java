package fil.coo;

import java.util.ArrayList;
import java.util.HashMap;

import fil.coo.items.Item;

public class Room implements Displayable{
	private ArrayList<Monster> monsters;
	private ArrayList<Item> items;
	private HashMap<Direction, Room> neighbors;
	protected Display display;
	private static int numberOfRooms = 0;
	private int roomNumber;
		
	/**
	 * Create a Room
	 */
	public Room() {
		this.display = Display.getInstance();
		this.neighbors = new HashMap<Direction, Room>();
		this.monsters = new ArrayList<Monster>();
		this.items = new ArrayList<Item>();
		Room.numberOfRooms++;
		this.roomNumber = Room.numberOfRooms;
	}

	/**
	 * Return Room's neighbors in an HashMap
	 * @return this.neighbors
	 */
	public HashMap<Direction, Room> getNeighbors() {
		return neighbors;
	}

	/**
	 * Display a description of the Room's Content (Items and Monsters) and the Room's neighbors 
	 */
	public void describeSurrounding() {
		this.display.simpleMessage("Monster List :");
		this.display.displayList(monsters);
		this.display.simpleMessage("Item List :");
		this.display.displayList(items);
		this.display.simpleMessage("Direction List :");
		this.display.displayHashMap(neighbors);
	}
	
	/**
	 * Display a simple message on entering a Room
	 */
	public void onEnter() {
		this.display.simpleMessage("Welcome to room number " + this.roomNumber);
	}
	
	/**
	 * Add a Monster in the Room
	 * @param monster
	 */
	public void addMonster(Monster monster) {
		monsters.add(monster);
	}
	
	/**
	 * Add an Item in the Room
	 * @param item
	 */
	public void addItem(Item item) {
		items.add(item);
	}
	
	/**
	 * Remove a Monster in the Room
	 * @param monster
	 */
	public void removeMonster(Monster monster) {
		monsters.remove(monster);
	}
	
	/**
	 * Remove an Item in the Room
	 * @param item
	 */
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	/**
	 * Return a neighbor Room at the given Direction
	 * @param direction
	 * @return nextRoom
	 * @throws ForbiddenDirectionException
	 */
	public Room getNextRoom(Direction direction) throws ForbiddenDirectionException {
		Room nextRoom = this.neighbors.get(direction);
		if (nextRoom == null) {
			throw new ForbiddenDirectionException("There is not next room for this direction");
		}
		return nextRoom;
	}
	
	// This need optimization because each time the function is called a new ArrayList is created
	/**
	 * 
	 * @return
	 */
	public ArrayList<Direction> getAvailableDirection(){
		return new ArrayList<Direction>(this.neighbors.keySet());
	}
	
	/**
	 * Set Room's neighbor with their Direction
	 * @param direction
	 * @param neighbor
	 */
	public void setNeighbor(Direction direction, Room neighbor) {
		this.neighbors.put(direction, neighbor);
	}
	
	/**
	 * Return Room's Monster list
	 * @return this.monsters
	 */
	public ArrayList<Monster> getMonsters(){
		return this.monsters;
	}
	
	public ArrayList<Item> getItems(){
		return this.items;
	}

	@Override
	/**
	 * Return Room's Description
	 * @return "Room"
	 */
	public String getDescription() {
		return "Room";
	}
}
