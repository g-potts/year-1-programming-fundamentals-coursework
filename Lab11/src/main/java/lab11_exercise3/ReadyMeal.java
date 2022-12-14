package lab11_exercise3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadyMeal {
	
	private String name;
	private ProductType type;
	private Factory factory;
	private Date productionDate = null;
	private List<IItem> items;
	
	public ReadyMeal(String name, ProductType type, Factory factory) {
		this.name = name;
		this.type = type;
		this.factory = factory;
		this.items = new ArrayList<IItem>();
	}
	
	public void addItem(IItem biscuit) { //why is it a biscuit lol
		items.add(biscuit);
		productionDate = new Date();
	}
	
	public String printContent() {
		/*format::
		 * [type] [name] Ready Meal [cooked weight]g
		 * 
		 * Contents
		 * Calories: [total]kcal
		 * Meat (fat): [total]g
		 * Vegetable (sodium): [total]g
		 * 
		 * [factory desc print]
		 * */
		double weight = 0;
		double calories = 0;
		double fat = 0;
		double sodium = 0;
		
		for (IItem i : items) {
			weight += i.getTotalWeight();
			calories += i.getTotalCalories();
			fat += i.getTotalFat(IngredientType.MEAT);
			sodium += i.getTotalSodium(IngredientType.VEGETABLE);
		}
		
		StringBuffer output = new StringBuffer();
		output.append(type.getDescription() + " " + name + " Ready Meal " + weight + " g\n\n");
		output.append("Contents");
		output.append("\nCalories: " + calories + "kcal");
		output.append("\nMeat (fat): " + fat + "g");
		output.append("\nVegetable (sodium): " + sodium + "g\n\n");
		output.append(factory.getAddress());
		
		return output.toString();
		
	}

	public String getName() {
		return name;
	}

	public ProductType getType() {
		return type;
	}

	public Factory getFactory() {
		return factory;
	}
	
}
