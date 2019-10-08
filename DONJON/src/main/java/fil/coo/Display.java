package fil.coo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Display {
    /** Constructeur privé */
    private Display()
    {}
 
    /** Instance unique pré-initialisée */
    private static Display INSTANCE = new Display();
     
    /** Point d'accès pour l'instance unique du Display */
    public static Display getInstance()
    {   return INSTANCE;
    }
    
    public <T extends Displayable> T listChoose(ArrayList<T> choice) throws EmptyListException {
    	
    	if (choice.size() == 0) {
    		throw new EmptyListException("Can't choose from an empty list");
    	}
    	Scanner scanner = new Scanner(System.in);
    	int choiceIndex = -1;
    	do {
	    	System.out.println("Choose one of the options below, enter a number between 1 and" + choice.size());
	    	try {
	    	choiceIndex = scanner.nextInt();
	    	} catch(InputMismatchException e) {
	    		System.out.println("Input invalid");
	    	}
			for (int i = 0; i < choice.size(); i++) {
				System.out.println((i+1)+ " :" + choice.get(i).getDescription());
			}
    	} while(choiceIndex > 0 && choiceIndex <= choice.size());
    	
    	return choice.get(choiceIndex + 1);
    }
}
