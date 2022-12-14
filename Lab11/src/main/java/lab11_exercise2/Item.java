package lab11_exercise2;

import java.util.ArrayList;
import java.util.List;

public class Item implements IItem {
	
	private List<Ingredient> ingredients;
	
	public Item() {
		this.ingredients = new ArrayList<Ingredient>();
	}
	
	@Override
	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}

	@Override
	public double getTotalWeight() {
		double weight = 0;
		for (Ingredient i : ingredients) {
			weight += i.getCookedWeight();
		}
		return weight;
	}

	@Override
	public double getTotalCalories() {
		double calories = 0;
		for (Ingredient i : ingredients) {
			calories += i.getCalories();
		}
		return calories;
	}

	@Override
	public double getTotalFat(IngredientType type) {
		double fat = 0;
		for (Ingredient i : ingredients) {
			if (i.getType() == type) {
				fat += i.getFat();
			}
		}
		return fat;
	}

	@Override
	public double getTotalSodium(IngredientType type) {
		double sodium = 0;
		for (Ingredient i : ingredients) {
			if (i.getType() == type) {
				sodium += i.getSodium();
			}
		}
		return sodium;
	}

}
