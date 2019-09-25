package fil.coo;

public abstract class Character {
	private String name;	// nom du personnage
	private int pv;			// points de vie
	private int force;		// force
	private int po;			// pièces d'or
	
	/**
	 * Crée un personnage à partir de son nom, du nombre de ses points de vie, sa force et le nombre de ses pièces d'or.
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
	
	public void attack(Character cible) {
		
	}
	
	/*
	public abstract void die() {
		
	}
	*/
	
	
	
	
	public String getName() {
		return this.name;
	}
	
	
	
	
	public void setPv(int pv) {
		this.pv = pv;
	}
	
	public int getPv() {
		return this.pv;
	}
	
	
	
	public void setForce(int force) {
		this.force = force;
	}
	
	public int getForce() {
		return this.force;
	}
	
	
	
	
	public void setPo(int po) {
		this.pv = po;
	}
	
	public int getPo() {
		return this.po;
	}
}
