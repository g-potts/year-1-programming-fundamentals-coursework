package lab11_exercise1;

public class Supplier {
	
	private String name;
	private String phone;
	
	public Supplier(String name, String phone) {
		this.name = name;
		if (phone.matches("0[0-9]{6,10}")) {
			this.phone = phone;
		} else {
			throw new IllegalArgumentException("invalid phone number");
		}
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	
}
