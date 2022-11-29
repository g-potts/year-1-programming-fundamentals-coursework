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
		return new Offer(new User("Aa Bb"), 2000);
	}
	
	public boolean placeOffer(User buyer, double value) {
		for (Offer o : offers) {
			if (o.getBuyer() == buyer) {
				if (o.getValue() > value) {
					return false;
				} else {
					this.offers.add(new Offer(buyer, value));
					return true;
				}
			}
		}
		return false;
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
