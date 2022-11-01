package lab5_exercise2;

public class Customer {
	
	private String name;
	private String surname;
	
	public Customer(String firstName, String surname) {
		this.name = firstName;
		this.surname = surname;
	}
	
	public char getName() {
		return this.name.toCharArray()[0];
	}
	
	public String getSurname() {
		return surname;
	}

	@Override
	public String toString() {
		return (this.getName() + ". " + this.getSurname());
	}
	
}
