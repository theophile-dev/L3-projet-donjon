package fil.coo.items;

import java.util.Random;

import fil.coo.Display;
/**
 * ItemGenerator is used generate random item from a predefined list of item
 * 
 * This class use the design pattern Singleton 
 * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton</a>
 */
public class ItemGenerator {
	private Item[] availableItems;
	private Item[] banditItems;
	private Random randomGenerator;

    
    private static ItemGenerator INSTANCE = new ItemGenerator();

    public static ItemGenerator getInstance()
    {   
    	return INSTANCE;
    }

	
	private ItemGenerator() {
		this.availableItems = new Item[]{new Purse(5), new HealingPotion(3), new StrengthPotion(5)};
		this.banditItems = new Item[]{new Purse(2), new HealingPotion(1), new StrengthPotion(3)};
		randomGenerator = new Random();
	}
	

	
	/**
	 * Generate a random item from a predefined list of item
	 * Note that the object is not is not cloned
	 * @return the reference of one item of the availableItems list
	 */
	public Item getRandomItem() {
		Item randomItem = this.availableItems[randomGenerator.nextInt(this.availableItems.length)];
		return randomItem;
	}
	
	public Item getRandomBanditItem() {
		Item randomItem = this.banditItems[randomGenerator.nextInt(this.banditItems.length)];
		return randomItem;
	}
	

}
