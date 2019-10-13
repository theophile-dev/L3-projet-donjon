package fil.coo;

public abstract class Character {
	private String name; // Character's Name
	private int hp; // Character's Life Point
	private int strength; // Character's Strength
	private int gold; // Character's Gold
	protected Display display;

	/**
	 * Creates a character by name, life point, strength, gold.
	 * 
	 * @param name     Character's name
	 * @param hp       Character's Life Points
	 * @param strength Character's Strength
	 * @param gold     Character's Gold
	 */
	public Character(String name, int hp, int strength, int gold) {
		this.name = name;
		this.hp = hp;
		this.strength = strength;
		this.gold = gold;
		this.display = Display.getInstance();
	}

	/**
	 * The Character attack a target, another Character The attacker's strength
	 * value is deducted from the target's total health.
	 * 
	 * @param target of the attack
	 */
	public void attack(Character target) {

		this.display.simpleMessage(this.getName() + " attack and deal " + this.getStrength());
		target.setHp(target.getHp() - this.getStrength());
	}

	public void displayStats() {
		this.display.simpleMessage(" --- ");
		this.display.simpleMessage(this.getName() + " stats :");
		this.display.simpleMessage("Strength : " + this.getStrength());
		this.display.simpleMessage("Hp : " + this.getHp());
		this.display.simpleMessage("Gold : " + this.getGold());
		this.display.simpleMessage(" --- ");
		
		
	}
	
	/**
	 * Return Character's Name
	 * 
	 * @return this.name Character's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set Character's Life Point
	 * 
	 * @param hp Character's name
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * Return Character's Life Point
	 * 
	 * @return this.hp Character's Life Point
	 */
	public int getHp() {
		return this.hp;
	}

	/**
	 * Set Character's Strength
	 * @param strength Character's Strength
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	/**
	 * Check if the character is dead
	 * 
	 * @return boolean
	 */
	public boolean isDead() {
		return this.getHp() <= 0;
	}

	/**
	 * Return Character's Strength
	 * 
	 * @return this.strength Character's Strength
	 */
	public int getStrength() {
		return this.strength;
	}

	/**
	 * Set Character's Gold
	 * 
	 * @param gold Character's Gold
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * Return Character's Gold
	 * 
	 * @return this.gold Character's Gold
	 */
	public int getGold() {
		return this.gold;
	}
}
