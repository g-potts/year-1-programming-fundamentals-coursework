package exercise2;

public class MealTest {

	public static void main(String[] args) {
		
		Food BLTSandwich = new Food("BLT Sandwich", 4.7);
		Food darkChocolate = new Food("Dark Chocolate", 48);
		
		Meal meal = new Meal(BLTSandwich, darkChocolate);
		
		System.out.println(meal.toString());
		System.out.println("Total amount of sugar: " + meal.calculateTotalSugarLevel() + "g");
		
	}

}
