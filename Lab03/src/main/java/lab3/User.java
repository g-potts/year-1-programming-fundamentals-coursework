package lab3;

public class User {
	
	private String name = null;
	private Email email = null;
	
	public User(String fullName, Email emailAddress) {
		this.name = fullName;
		this.email = emailAddress;
	}

	@Override
	public String toString() {
		return this.name + " <" + this.email.getEmailAddress() + ">";	
	}
	
}
