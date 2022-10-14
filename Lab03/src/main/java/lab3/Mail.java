package lab3;


public class Mail {
	
	private User sender = null;
	private User recipient = null;
	private String message = null;

	public Mail(User sender, User recipient, String message) {
		this.sender = sender;
		this.recipient = recipient;
		this.message = message;
	}

	public String getSender() {
		return this.sender.toString();
	}

	public User getRecipient() {
		return recipient;
	}

	public String getMessage() {
		return message;
	}
	
	private void isEmpty() {
		
		if (this.getMessage() == null || this.getMessage() == "") {
			this.message = "** Something went wrong! **";
		}
		
	}

	public void print() {
		System.out.println("From: " + sender);
		System.out.println("To: " + recipient);
		
		this.isEmpty();
		System.out.println("Message: " + message);
	}
}

