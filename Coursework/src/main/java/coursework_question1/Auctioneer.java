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
			output.append(advert.getHighestOffer().getBuyer());
			output.append(" with a successful £" + advert.getHighestOffer().getValue() + "bid.\n"); 
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
				output.append(advert.toString()); //TODO not returning anything? because endsale isnt doing the right thing?
			}
		}
		return output.toString();
	}
	
	public void endSale(Advert advert) {
		if (unsoldCars.containsKey(advert)) {	//unsoldCars.containsKey(advert) && 
			System.out.println("first if works");
			
				if ((advert.getHighestOffer()).getValue() <= advert.getCar().getPrice()) {
					soldCars.put(advert, unsoldCars.get(advert)); //TODO user from placeOffer with highest bid
					unsoldCars.remove(advert);
					System.out.println("sale ended");
				}
			
			
			//System.out.println("price not lower / not working");
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
			} catch (NullPointerException e) {
				throw new IllegalArgumentException("parameters should not be null");
			}
		}
	}
	
	//getters setters
	
}
