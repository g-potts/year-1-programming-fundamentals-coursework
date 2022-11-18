package lab8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A simple class used to test out IOExceptions.
 * 
 * @author Stella Kazamia
 */
public class Example3 {

	/**
	 * Main entry point: this is the first method that is run.
	 * 
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		File file = new File("test1.txt");
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
