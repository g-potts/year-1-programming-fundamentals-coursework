package coursework_question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
		System.out.println(offers.toString());
		Offer highestOffer = offers.get(0);
		System.out.println("before for each loop in highestoffer");
		for (int i = 0; i < offers.size(); i++) {
			
				if (offers.get(i).getValue() >= highestOffer.getValue()) {
					highestOffer = offers.get(i);
				}
			
			
		}
		return highestOffer;
		
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
