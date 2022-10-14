package lab3;

public class Email {
	
	public static final String DEFAULT_ADDRESS = "unknown@unknown";
	private String emailAddress = DEFAULT_ADDRESS;
	
	public Email(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	
}
