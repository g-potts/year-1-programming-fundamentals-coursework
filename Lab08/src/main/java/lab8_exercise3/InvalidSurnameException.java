package lab8_exercise3;

public class InvalidSurnameException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidSurnameException() {
		super("Surname is invalid");
	}
	
}
