package coursework_question2;

import java.util.ArrayList;
import java.util.List;

public class Advert {
	
	private Car car;
	private List<Offer> offers;
	
	//constructor
	public Advert(Car car) { 
		if (car == null) {
			throw new IllegalArgumentException("car cannot be null");
		}
		this.car = car;
		this.offers = new ArrayList<Offer>();
	}
	
	//methods
	public Offer getHighestOffer() {
		//if list is null, raise exception
		//set highest to first in list
		//for each item in list, compare and change if higher
		//return final offer object
		
		if (offers.size() == 0) {
			throw new NullPointerException("no offers under this advert");
		} else {
			Offer highest = offers.get(0);
			for (Offer o : offers) {
				if (o.getValue() > highest.getValue()) {
					highest = o;
				}
			}
			return highest;
		}
	}
	
	public boolean placeOffer(User buyer, double value) {
		if (offers.size() == 0) {
			this.offers.add(new Offer(buyer, value));
			return true;
		} else {
			for (Offer o : offers) {
				if (o.getBuyer() == buyer) {
					if (o.getValue() > value) {
						return false;
					} else {
						this.offers.add(new Offer(buyer, value));
						return true;
					}
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
