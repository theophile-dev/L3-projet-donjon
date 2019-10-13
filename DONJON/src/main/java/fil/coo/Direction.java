package fil.coo;

import java.util.ArrayList;
import java.util.Arrays;

public enum Direction implements Displayable {
    UP("Up"), 
    DOWN("Down"), 
    LEFT("Left"), 
    RIGHT("Right");

 
    private String typeOfDirection;
 
    Direction(String typeOfDirection) {
        this.typeOfDirection = typeOfDirection;
    }
      
    public static ArrayList<Direction> arrayList() {
        return new ArrayList<Direction>(Arrays.asList(Direction.values()));
    }

	@Override
	public String getDescription() {
		return this.typeOfDirection;
	}

}
