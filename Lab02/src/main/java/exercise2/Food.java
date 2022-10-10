package exercise2;

public class Food {
	private String name;
	private double amountOfSugar;
	
	public Food(String name, double amountOfSugar) { //constructor 
		this.name = name;
		this.amountOfSugar = amountOfSugar;
	}
	
	public String getName() {
		return name;
	}
	public double getAmountOfSugar() {
		return amountOfSugar;
	}
	
	
}
