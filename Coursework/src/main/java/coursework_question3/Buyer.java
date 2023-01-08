package coursework_question3;

public class Buyer extends User {
	
	private int age;
	
	public Buyer(String name, int age) {
		super(name);
		if (age >= 18) {
			this.age = age;
		} else {
			throw new IllegalArgumentException("buyers must be at least 18 years old");
		}
		
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return (getName().charAt(0) + "***" + getName().charAt(getName().length()-1));
	}

}
