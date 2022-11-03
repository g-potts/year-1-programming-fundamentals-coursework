package lab4;

/**
 * A simple class used to demonstrate deficiencies in arrays.
 * 
 * @author Stella Kazamia
 * 
 */
public class Example2 {

	/**
	 * Main entry point: this is the first method that is run.
	 * 
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		// Add the code here
		// Code needing a new variable for each house.
		/*int house1 = 3;
		int house2 = 0;
		int house3 = 4;
		
		System.out.println("How many bottles in house 1 is " + house1);
		System.out.println("How many bottles in house 2 is " + house2);
		System.out.println("How many bottles in house 3 is " + house3);*/
		
		int[] houses = new int[3];
		
		houses[0] = 3;
		houses[1] = 0;
		houses[2] = 4;
		
		for (int i : houses) {
			System.out.println("How many bottles in house is " + i);
			}
	}
}
