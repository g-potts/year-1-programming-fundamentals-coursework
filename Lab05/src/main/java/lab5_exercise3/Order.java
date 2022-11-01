package lab5_exercise3;
import java.util.ArrayList;

public class Order {
	private ArrayList<Pizza> pizzas;
	private Customer customer;
	
	public Order(Customer customer) {
		this.customer = customer;
		this.pizzas = new ArrayList<Pizza>();
		
	}
	
	public void addPizza(Pizza pizza) {
		this.pizzas.add(pizza);
	}
	
	public double calculateTotal() {
		double total = 0;
		for (Pizza p : pizzas) {
			total += p.calculateCost();
		}
		return total;
	}
	
	public String printReceipt() {
		return ("Customer: " + this.customer.toString()
				+ "\nNumber of Pizzas: " + this.pizzas.size()
				+ "\nTotal Cost: " + this.calculateTotal());
	}
	
}
