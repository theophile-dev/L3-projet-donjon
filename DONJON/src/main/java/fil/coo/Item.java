package fil.coo;

public abstract class Item {
	private String name;
	private String description;
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.description;
	}
	

	public abstract void use();	
}
