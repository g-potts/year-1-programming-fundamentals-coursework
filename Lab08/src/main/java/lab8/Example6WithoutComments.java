package lab8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Example6.java
 */

/**
 * A simple class used to explore reading a text file
 * 
 * @author Stella Kazamia
 */
public class Example6WithoutComments {

	/**
	 * Main entry point: this is the first method that is run.
	 * 
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		BufferedReader buffer = null;

		try {
			FileReader in = new FileReader("words.txt");
			buffer = new BufferedReader(in);

			String line = buffer.readLine();

			while (line != null) {
				System.out.println(line);
				line = buffer.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Cannot read the file");
			e.printStackTrace();
		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
					System.out.println("Could not close the file");
					e.printStackTrace();
				}
			}
		}
	}

}
