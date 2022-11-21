package coursework_question1;

import java.util.StringTokenizer;

public class User {
	
	private String fullname;
	
	public User(String fullname) {
		if (fullname.matches("[A-Z][a-z]* [A-Z][a-z]*")) {
			this.fullname = fullname;
		} else {
			throw new IllegalArgumentException("name invalid");
		}
	}
	
	public String getName() {
		//only first name!!
		StringTokenizer namesplit = new StringTokenizer(fullname);
		return namesplit.nextToken();
	}
	
	@Override
	public String toString() {
		return fullname;
	}
}
