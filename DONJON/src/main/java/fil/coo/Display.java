package fil.coo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Display is a set of tools used to display informations and allow the user to
 * interact with a text interface
 * 
 * This class use the design pattern Singleton
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton</a>
 */
public class Display {

	private Scanner scanner = new Scanner(System.in);

	private Display() {
	}

	private static Display INSTANCE = new Display();

	public static Display getInstance() {
		return INSTANCE;
	}

	public void simpleMessage(String msg) {
		System.out.println(msg);
	}

	/**
	 * Display a the key-value pairs of a Hashmap of Displayable object
	 * 
	 * @param <T1>
	 * @param <T2>
	 * @param hashmap  	 
	 */
	public <T1 extends Displayable, T2 extends Displayable> void displayHashMap(HashMap<T1, T2> hashmap) {
		for (Map.Entry<T1, T2> entry : hashmap.entrySet()) {
			System.out.println(entry.getKey().getDescription() + " : " + entry.getValue().getDescription());
		}
	}

	/**
	 * Display a list of object and their index int the list
	 * 
	 * @param <T>
	 */
	public <T extends Displayable> void displayList(ArrayList<T> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + " :" + list.get(i).getDescription());
		}
	}

	/**
	 * listChoose display use and Object list and allow the user to chose one by
	 * typing the index of the object in the list
	 * 
	 * @param <T>    The type of the object implementing Displayable
	 * @param choice An array list of object to choose from
	 * @return The chosen object
	 * @throws EmptyListException
	 */
	public <T extends Displayable> T listChoose(ArrayList<T> choice) throws EmptyListException {

		if (choice.size() == 0) {
			throw new EmptyListException("Can't choose from an empty list");
		}

		int choiceIndex = -1;
		do {
			System.out.println("Choose one of the options below, enter a number between 1 and " + choice.size());
			this.displayList(choice);
			try {
				choiceIndex = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Input invalid");
				scanner.nextLine();
			}
		} while ((choiceIndex < 0) || (choiceIndex > choice.size()));

		return choice.get(choiceIndex - 1);
	}

}
