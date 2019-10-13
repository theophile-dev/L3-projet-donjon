package fil.coo;

public abstract class Character {
	private String name;	// nom du personnage
	private int hp;			// points de vie
	private int strength;		// force
	private int gold;			// pièces d'or
	protected Display display;
	
	/**
	 * Crée un personnage à partir de son nom, du nombre de ses points de vie, de sa force et du nombre de ses pièces d'or.
	 * @param name le nom du personnage
	 * @param pv le nombres de points de vie du personnage
	 * @param force la force du personnage
	 * @param po le nombre de pièces d'or du personnage
	 */
	public Character(String name, int hp, int strength, int gold){
		this.name = name;
		this.hp = hp;
		this.strength = strength;
		this.gold = gold;
		this.display = Display.getInstance();
	}
	
	/**
	 * Le personnage attaque sa cible, un autre personnage.
	 * La valeur de force de l'attaquant est déduit du totale de points de vie la cible.
	 * @param target la cible de l'attaque
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
	 * Donne le nom du personnage
	 * @return this.name le nom du personnage
	 */
	public String getName() {
		return this.name;
	}
	
	
	
	/**
	 * Fixe pv comme nouvelle valeur des points de vie du personnage.
	 * @param pv la nouvelle valeur de points de vie du personnage
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	/**
	 * Donne le nombre de point de vie du personnage
	 * @return this.pv les points de vie actuels du personnage
	 */
	public int getHp() {
		return this.hp;
	}
	
	
	/**
	 * Fixe force comme la nouvelle valeur de force du personnage
	 * @param force la nouvelle valeur de force du personnage
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	/**
	 * Check if the character is dead
	 */
	public boolean isDead() {
		return this.getHp() <= 0;
	}
	
	
	/**
	 * Donne la valeur de force du personnage
	 * @return this.force la force du personnage
	 */
	public int getStrength() {
		return this.strength;
	}
	
	
	/**
	 * Fixe po comme nouveau nombres de pièces d'or que possède ke personnage
	 * @param po le nouveau nombre de pièces d'or
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	/**
	 * Donne le nombre de pièces d'or que possède le personnage
	 * @return this.po le nombre de pièces d'or du personnage 
	 */
	public int getGold() {
		return this.gold;
	}
}
