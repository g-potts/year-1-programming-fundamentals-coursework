package lab5_exercise3;

public class Pizza {
	
	private String[] toppings;
	
	public Pizza() {
		this.toppings = new String[0]; // maximum of 10 toppings on pizza, unused slots can stay null
	}
	
	public void addToppings(String[] toppings) {
		this.toppings = new String[toppings.length];
		this.toppings = toppings;
		
	}
	
	public String printToppings() {
		String o = toppings[0];
		for (int i = 1; i < toppings.length; i++) {
			o += ("," + toppings[i]);
		}
		return o;
	}
	
	public double calculateCost() {
		if (toppings.length == 0) {
			return 0;
		} else if (toppings.length < 4) {
			return 8.99;
		} else {
			return (4.99 + toppings.length);
		}		
	}
}
