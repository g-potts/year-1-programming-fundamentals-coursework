package exercise2;

public class Meal {
	
	private Food mainCourse;
	private Food dessert;
	
	public Meal(Food mainCourse, Food dessert) { //creates meal object using two food objects
		this.mainCourse = mainCourse;
		this.dessert = dessert;
	}
	
	public double calculateTotalSugarLevel( ) {
		return (mainCourse.getAmountOfSugar() + dessert.getAmountOfSugar());
	}

	@Override
	public String toString() {
		return "Meal [mainCourse = " + mainCourse.getName() + ", dessert = " + dessert.getName() + "]";
	}
	
	
}
