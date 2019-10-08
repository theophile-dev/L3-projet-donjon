package fil.coo;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
	private String name;
	private String description;
	private ArrayList<Monster> monsters;
	private ArrayList<Item> items;
	private boolean exit;
	private HashMap<Direction, Room> voisin;
		
	public Room(String name, boolean exit) {
		this.name = name;
		this.exit = exit;
		this.voisin = new HashMap<Direction, Room>();
		this.monsters = new ArrayList<Monster>();
		this.items = new ArrayList<Item>();
	}

	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public boolean isExit() {
		return this.exit;
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
	
	public void setVoisins(Direction direction, Room voisin) {
		this.voisin.put(direction, voisin);
	}
}
