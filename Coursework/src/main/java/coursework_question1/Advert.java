package coursework_question1;

import java.util.ArrayList;
import java.util.List;

public class Advert {
	
	private Car car;
	private List<Offer> offers;
	
	//constructor
	public Advert(Car car) { 
		this.car = car;
		this.offers = new ArrayList<Offer>();
	}
	//methods
	public Offer getHighestOffer() {
		//TODO what
	}
	
	public boolean placeOffer(User buyer, double value) {
		//only add and return true if car is for sale
		if (this.car )
		offers.add(new Offer(buyer, value));
	}
	
	@Override
	public String toString() {
		return ("Ad: " + car.displayCarSpecification() + "\n");
	}
	//getters setters
	public Car getCar() {
		return this.car;
	}
}
