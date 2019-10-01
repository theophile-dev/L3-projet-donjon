package fil.coo;

public class Room {
	private String name;
	private ArrayList<Monster> monsters;
	private ArrayList<Item> items;
	private boolean exit;
	//private ? voisins;
	
	public String toString() {
		return this.name;
	}
	
	public boolean isExit() {
		return this.exit;
	}
	
	public void addMonster(Monster m) {
		//
	}
	
	public void addItem(Item i) {
		//
	}
	
	public void removeMonster(Monster m) {
		//
	}
	
	public void removeItem(Item i) {
		//
	}
}
