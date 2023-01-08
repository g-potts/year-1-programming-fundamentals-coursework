package coursework_question3;

public abstract class User {
	
	private String fullname;
	
	public User(String fullname) {
		if (fullname.matches("[A-Z][a-z]* [A-Z][a-z]*")) {
			this.fullname = fullname;
		} else {
			throw new IllegalArgumentException("name invalid");
		}
	}
	
	public String getName() {
		return (fullname.split(" ")[0]);
	}
	
	public String getFullName() {
		return fullname;
	}
	
	@Override
	public abstract String toString();
}
