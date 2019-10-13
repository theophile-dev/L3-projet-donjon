package fil.coo;
/**
 * Main class of the project.
 * AdventureGame handle the main game mechanics such as 
 * 
 *
 */
public class AdventureGame {
	
	private static Display display;
	
    public static void main( String[] args ) {
    	AdventureGame.display = Display.getInstance();
        DonjonBuilder donjonBuilder = new DonjonBuilder(4);
        donjonBuilder.generate();
        AdventureGame.display.simpleMessage("What's your name ?");
        Player player = new Player(AdventureGame.display.askString(), 10, 1, 10, donjonBuilder.getDonjonEntrance());
        while (!(player.hasPlayerWon() || player.isDead())) {
        	player.act();
        	player.updateAvailableAction();
        }
        if (player.isDead()) {
        	AdventureGame.display.simpleMessage(("You died : " + player.getDeathOrigin()));
        }
       
    }
    
}
