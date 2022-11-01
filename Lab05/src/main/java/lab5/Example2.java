package lab5;

/**
 * A simple class used to demonstrate deficiencies in arrays.
 * 
 * @author Stella Kazamia
 * 
 */
public class Example2 {

	public static void main(String[] args) {

		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j <= 3; j++) {
				System.out.print((i + j*2) + " ");
			}
			System.out.println();
		}
		
	}
}
