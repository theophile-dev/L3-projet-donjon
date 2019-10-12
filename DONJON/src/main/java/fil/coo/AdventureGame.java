package fil.coo;
/**
 * Main class of the project.
 * AdventureGame handle the main game mechanics such as 
 * 
 *
 */
public class AdventureGame {
	
    public static void main( String[] args ) {
        DonjonBuilder donjonBuilder = new DonjonBuilder(4);
        Player player = new Player("didier", 10, 10, 10, donjonBuilder.getDonjonEntrance());
        while (!(player.hasPlayerWon() || player.isDead())) {
        	player.act();
        }
        if (player.isDead()) {
        	System.out.println("You died");
        }
       
    }
    
}
