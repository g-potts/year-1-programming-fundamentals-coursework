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
		for (int i = 0; i < soldCars.size(); i++) {
			output.append(soldCars.);
		}
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
		unsoldCars.remove(advert);
	}
	
	public boolean placeOffer(Advert carAdvert, User user, double value) {
		if (this.checkExistence(carAdvert.getCar())) {
			carAdvert.placeOffer(user, value);
			return true;
		} else {
			return false;
		}
	}
	
	public void registerCar(Advert carAdvert, User user, String colour, CarType type, CarBody body, int noOfSeats) {
		//registers car IF not registered yet. 
	}
	
	//getters setters
	
}
