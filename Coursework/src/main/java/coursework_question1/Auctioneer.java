package coursework_question1;

import java.util.HashMap;
import java.util.Map;

public class Auctioneer {
	
	protected String name;
	protected Map<Advert, User> carsForSale;
	protected Map<Advert, User> soldCars;
	protected Map<Advert, User> unsoldCars;
	
	//constructor
	public Auctioneer(String name) {
		this.name = name;
		this.carsForSale = new HashMap<Advert, User>();
		this.soldCars = new HashMap<Advert, User>();
		this.unsoldCars = new HashMap<Advert, User>();
	}
	
	//methods
	private boolean checkExistence(Car car) {
		for (Advert a : carsForSale.keySet()) {
			if (a.getCar() == car) {
				return true;
			}
		}
		return false;
	}
	
	public String displaySoldCars() {
		/* OUTPUT:
		 * SOLD CARS:\N
		 * [advert.car.id] - Purchased by [user.fullname] with a successful £[advert.arrayoffers[offer].value] bid.\n
		 * */
		StringBuffer output = new StringBuffer();
		output.append("SOLD CARS:\n");
		//for each advert in soldCars:
		for (Advert advert : soldCars.keySet()) {
			output.append(advert.getCar().getId());
			output.append(" - Purchased by ");
			output.append(soldCars.get(advert).getName());
			output.append(" with a successful £" + advert.getHighestOffer() + "bid.\n");
		}
		return output.toString();
		
	}
	
	public String displayStatistics() {
		return "Statistics";
	}
	
	public String displayUnsoldCars() {
		StringBuffer output = new StringBuffer();
		output.append("UNSOLD CARS:\n");
		for (Advert advert : unsoldCars.keySet()) {
			output.append(advert.toString());
		}
		return output.toString();
	}
	
	public void endSale(Advert advert) {
		if (unsoldCars.containsKey(advert)) {
			unsoldCars.remove(advert);
		} else {
			throw new IllegalArgumentException("advert not in unsold cars");
		}
		
	}
	
	public boolean placeOffer(Advert carAdvert, User user, double value) {
		try {
			if (this.checkExistence(carAdvert.getCar())) {
				carAdvert.placeOffer(user, value);
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("advert does not exist");
		}
	}
	
	public void registerCar(Advert carAdvert, User user, String colour, CarType type, CarBody body, int noOfSeats) {
		if (!unsoldCars.containsKey(carAdvert)) {
			try {
				carAdvert.getCar().setBody(body);
				carAdvert.getCar().setColour(colour);
				carAdvert.getCar().setGearbox(type);
				carAdvert.getCar().setNumberOfSeats(noOfSeats);
				
				carsForSale.put(carAdvert, user);
				unsoldCars.put(carAdvert, user);
			} catch (IllegalArgumentException e) {
				//TODO exception stuff?
			}
		}
	}
	
	//getters setters
	
}
