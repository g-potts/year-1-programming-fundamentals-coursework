package lab8_exercise1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Counting {
	
	public Counting() {
		super();
	}
	
	public String readTextFile() {
		StringBuffer textfile = new StringBuffer();
		FileReader filereader = null;
		try {
			filereader = new FileReader("words.txt");
			BufferedReader reader = new BufferedReader(filereader); 
			String line = reader.readLine();
			int i = 1;
			while (line != null) {
				textfile.append(displayLine(line, i));
				textfile.append("\n");
				line = reader.readLine();
				i++;
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("could not read file");
		}
		return (textfile.toString());		
	}
	
	private String displayLine(String line, int counter) {
		StringBuffer output = new StringBuffer();
		output.append(line);
		output.append(" : ");
		output.append(counter);
		return output.toString();
	}
	
}
