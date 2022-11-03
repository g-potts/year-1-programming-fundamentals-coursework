package lab4;
import java.util.ArrayList;
/**
 * A simple class to introduce ArrayLists
 * 
 * @author Stella Kazamia
 * 
 */

public class Example4 {

	// Add a field
	ArrayList<String> namesList = new ArrayList<String>();
	// Add a default constructor
	public Example4() {
		super();
	}
	
	public void addNames() {
		// Initialise the array list
		namesList.add("Helen");
		namesList.add("Stella");
	}

	public String displayNames() {
		// Loop through the array list
		String o = "";
		for (String i : namesList) {
			o += i;
		}
		return o;
	}
}
