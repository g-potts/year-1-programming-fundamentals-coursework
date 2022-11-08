package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An example on how user-defined methods can be used to structure how
 * ArrayLists
 * 
 * @author Stella Kazamia
 *
 */
public class Example2 {

	// Create a list that holds Double values
	private List<Double> values;

	/**
	 * Define the list as an ArrayList in a default constructor
	 * 
	 */

	public Example2() {
		super();
		this.values = new ArrayList<Double>();
	}

	/**
	 * In a UML, this would look like this: + addElement(in value: double)
	 */
	public void addElement(double value) {
		values.add(value);
	}

	/**
	 * In a UML, this would look like this: + removeElement (in value: double)
	 */
	public void removeElement(double value) {
		if (checkifElementExists(value)) {
			values.remove(value);
		}
	}

	/**
	 * In a UML, this would look like this: - checkIfElementExists(in value:
	 * double): boolean
	 */
	private boolean checkifElementExists(double value) {
		if (values.contains(value)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * In a UML, this would look like this: + retrieveElement(in index: int)
	 */
	public double retrieveElement(int index) {
		double value = 0;
		value = values.get(index);
		return value;
	}

	/**
	 * In a UML, this would look like this: + displayList(): String
	 */
	public String displayList() {
		String output = "";
		for (double d : values) {
			output += d;
		}
		return output;

	}

	/**
	 * In a UML, this would look like this: + displaysortedList(): String
	 */
	public String displayOrderedList() {
		// add your code here
		StringBuffer output = new StringBuffer();
		Collections.sort(values);
		output.append("Ordered List\n");
		output.append(this.displayList());
		return output.toString();
		// add your code here

	}

	/**
	 * In a UML, this would look like this: + calculateAverage(): double
	 */
	public double calculateAverage() {
		double sum = 0;
		for (double d : values) {
			sum += d;
		}
		sum /= values.size();
		return sum;
	}

	/**
	 * The main method has been defined for you - Run the file as a Java Application
	 * and compare the output
	 */
	public static void main(String[] args) {
		Example2 test = new Example2();
		// add elements in the list
		test.addElement(75);
		test.addElement(100);
		test.addElement(50);

		// remove an element from the list
		test.removeElement(50);

		// printing empty lines and heading on console
		System.out.println();
		System.out.println("**Using the .get method");
		System.out.println();

		// retrieve elements and display them on the console
		System.out.println("This is the value at index 0: " + test.retrieveElement(0));
		System.out.println("This is the value at index 2: " + test.retrieveElement(2));

		// printing empty lines and heading on console
		System.out.println();
		System.out.println("**Displaying list");
		System.out.println();

		// display all the elements of the list
		System.out.println(test.displayList());

		// printing empty lines and heading on console
		System.out.println();
		System.out.println("**Using the .sort method");
		System.out.println();

		// add one more element in the list
		test.addElement(50);

		// display all the elements of the list
		System.out.println(test.displayList());

		// display all the elements of the list (in an order)
		System.out.println(test.displayOrderedList());

		// printing empty lines and heading on console
		System.out.println();
		System.out.println("**Applying arithmetic operations on list values");
		System.out.println();

		// calculate the average and display it on the console
		System.out.println(test.calculateAverage());

	}
}
