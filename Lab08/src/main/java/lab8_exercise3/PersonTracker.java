package lab8_exercise3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.StringTokenizer;

public class PersonTracker {
	
	private ArrayList<Person> peopleList;
	
	public PersonTracker() {
		this.peopleList = new ArrayList<Person>();
	}
	
	public void readTextFile(String filename) {
		// reads given text file and uses breakline to submit line
		//for each line in file, send to breakline
		FileReader filereader;
		try {
			filereader = new FileReader(filename);
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while (line != null) {
				breakLine(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void breakLine(String line) {
		//takes line and splits into forename, surname, age into addperson
//		StringTokenizer words = new StringTokenizer(line);
//		String fname = words.nextToken();
//		String lname = words.nextToken();
//		int age = Integer.parseInt(words.nextToken());
//		addPerson(fname, lname, age);
		String[] details = line.split(" ");
		addPerson(details[0], details[1], Integer.parseInt(details[2]));
	}
	
	private void addPerson(String forename, String surname, int age) {
		//adds details to arraylist
		Person p;
		try {
			p = new Person(forename, surname, age);
			this.peopleList.add(p);
		} catch (InvalidSurnameException | InvalidAgeException e) {
			e.printStackTrace();
		}
		
	}
	
	public String displayList() {
		//prints list
		StringBuffer output = new StringBuffer();
		for (Person p : peopleList) {
			output.append(p.toString());
			output.append("\n");
		}
		return output.toString();
	}
}
