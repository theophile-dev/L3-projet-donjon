package fil.coo;

public abstract class Character {
	private String name;	// nom du personnage
	private int pv;			// points de vie
	private int force;		// force
	private int po;			// pièces d'or
	
	/**
	 * Crée un personnage à partir de son nom, du nombre de ses points de vie, de sa force et du nombre de ses pièces d'or.
	 * @param name le nom du personnage
	 * @param pv le nombres de points de vie du personnage
	 * @param force la force du personnage
	 * @param po le nombre de pièces d'or du personnage
	 */
	public Character(String name, int pv, int force, int po){
		this.name = name;
		this.pv = pv;
		this.force = force;
		this.po = po;
	}
	
	/**
	 * Le personnage attaque sa cible, un autre personnage.
	 * La valeur de force de l'attaquant est déduit du totale de points de vie la cible.
	 * @param cible la cible de l'attaque
	 */
	public void attack(Character cible) {
		int pv_cible = cible.getPv();
		int force_attack = this.getForce();
		cible.setPv(pv_cible - force_attack);
	}
	/**
	 * Function called when the character is dead
	 */
	public abstract void die();
	
	
	
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
	public void setPv(int pv) {
		this.pv = pv;
	}
	
	/**
	 * Donne le nombre de point de vie du personnage
	 * @return this.pv les points de vie actuels du personnage
	 */
	public int getPv() {
		return this.pv;
	}
	
	
	/**
	 * Fixe force comme la nouvelle valeur de force du personnage
	 * @param force la nouvelle valeur de force du personnage
	 */
	public void setForce(int force) {
		this.force = force;
	}
	
	/**
	 * Donne la valeur de force du personnage
	 * @return this.force la force du personnage
	 */
	public int getForce() {
		return this.force;
	}
	
	
	/**
	 * Fixe po comme nouveau nombres de pièces d'or que possède ke personnage
	 * @param po le nouveau nombre de pièces d'or
	 */
	public void setPo(int po) {
		this.pv = po;
	}
	
	/**
	 * Donne le nombre de pièces d'or que possède le personnage
	 * @return this.po le nombre de pièces d'or du personnage 
	 */
	public int getPo() {
		return this.po;
	}
}
