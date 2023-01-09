package coursework_question4;

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
		return (getFullname().split(" ")[0]);
	}
	
	public String getFullName() {
		return getFullname();
	}
	
	@Override
	public abstract String toString();

	public String getFullname() {
		return fullname;
	}
}
