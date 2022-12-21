package coursework_question2;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Auctioneer { //TODO add comments after made in q1
	
	protected String name;
	protected Map<Advert, User> carsForSale; //cars currently for sale
	protected Map<Advert, User> soldCars; //cars bid on, sale ended successfully
	protected Map<Advert, User> unsoldCars; //cars with sale ended unsuccessfully
	
	//constructor
	public Auctioneer(String name) {
		this.name = name;
		this.carsForSale = new HashMap<Advert, User>();
		this.soldCars = new HashMap<Advert, User>();
		this.unsoldCars = new HashMap<Advert, User>();
	}
	
	//methods
	private boolean checkExistence(Car car) { //searches carsforsale by car, rather than advert or user
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
		DecimalFormat d = new DecimalFormat("0.00");
		StringBuffer output = new StringBuffer();
		output.append("SOLD CARS:\n");
		//for each advert in soldCars:
		for (Advert advert : soldCars.keySet()) {
			output.append(advert.getCar().getId());
			output.append(" - Purchased by ");
			output.append(advert.getHighestOffer().getBuyer().getName());
			output.append(" with a successful £" + d.format(advert.getHighestOffer().getValue()) + " bid.\n"); 
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
			if (unsoldCars.containsKey(advert)) {
				output.append(advert.toString());
			}
		}
		return output.toString();
	}
	
	public void endSale(Advert advert) {
		//if highest offer is greater than asking price, add to sold cars
		//if price not reached, add to unsold cars
		//remove from carsforsale
		
		if (advert == null) {
			throw new IllegalArgumentException("cannot take null parameters");
		}
		
		if (advert.getHighestOffer().getValue() >= advert.getCar().getPrice()) {
			soldCars.put(advert, advert.getHighestOffer().getBuyer());
		} else {
			unsoldCars.put(advert, carsForSale.get(advert));
		}
		carsForSale.remove(advert);
	}
	
	public boolean placeOffer(Advert carAdvert, User user, double value) {
		//check parameters are valid, and car is for sale
		//return true if offer is placed
		//false if not
		
		if (carAdvert == null || user == null || value < 0) {
			throw new IllegalArgumentException("cannot take null parameters");
		} else {
			if (carsForSale.containsKey(carAdvert)) {
				carAdvert.placeOffer(user, value);
				return true;
			} else {
				return false;
			}
		}
	}
	
	public void registerCar(Advert carAdvert, User user, String colour, CarType type, CarBody body, int noOfSeats) {
		try {
			if (!checkExistence(carAdvert.getCar())) {
				carAdvert.getCar().setBody(body);
				carAdvert.getCar().setColour(colour);
				carAdvert.getCar().setGearbox(type);
				carAdvert.getCar().setNumberOfSeats(noOfSeats);
				
				carsForSale.put(carAdvert, user);
			}
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("parameters should not be null");
		}
		
	}
	
	//getters setters
	
}
