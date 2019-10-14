package fil.coo;

import java.util.ArrayList;

import fil.coo.items.ItemGenerator;
import fil.coo.items.OneArmedBandit;

public class DonjonBuilder {
	
	private ArrayList<Room> donjon;
	private DonjonEntrance donjonEntrance;
	private DonjonExit donjonExit;
	private int numberOfRoom;
	private ItemGenerator itemGenerator;

	public DonjonBuilder(int numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
		this.itemGenerator = ItemGenerator.getInstance();
	}

	public void generate() {
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
		Monster monster1 = new Monster("Ugly Monster", 3, 1, 3);
		Monster monster2 = new Monster("Happy Monster", 4, 1, 2);
		Monster monsterBoss = new Monster("Big ulgy spooky Monster", 10, 2, 10);
		room3.addMonster(monster1);
		room3.addMonster(monsterBoss);
		room2.addMonster(monster2);
		donjonEntrance.addItem(itemGenerator.getRandomItem());
		donjonEntrance.addItem(itemGenerator.getRandomItem());
		room2.addItem(new OneArmedBandit(4));
		room3.addItem(itemGenerator.getRandomItem());
		room3.addItem(itemGenerator.getRandomItem());
		room3.addItem(itemGenerator.getRandomItem());
		room3.addItem(itemGenerator.getRandomItem());
		
	}
	
	/**
	 * Return donjonEntrance
	 * @return donjonEntrance
	 */
	public Room getDonjonEntrance(){
		return donjonEntrance;
	}
	
	/**
	 * Return donjonExit
	 * @return donjonExit
	 */
	public Room getDonjonExit(){
		return donjonExit;
	}

	
	
}
