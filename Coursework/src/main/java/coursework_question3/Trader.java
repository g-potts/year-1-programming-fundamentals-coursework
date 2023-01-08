package coursework_question3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Trader extends Dealership {
	
	protected String name;
	private List<Seller> sellers;
	
	public Trader(String name) {
		super(name);
		sellers = new ArrayList<Seller>();
	}
	
	private boolean checkExistence(Car car) { 
		for (Advert a : carsForSale.keySet()) {
			if (a.getCar() == car) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String displaySoldCars() {
		DecimalFormat d = new DecimalFormat("0.00");
		StringBuffer output = new StringBuffer();
		output.append("SOLD CARS:\n");
		for (Advert advert : soldCars.keySet()) {
			output.append(advert.getCar().getId());
			output.append(" - Purchased by ");
			output.append(advert.getHighestOffer().getBuyer().toString());
			output.append(" with a successful £" + d.format(advert.getHighestOffer().getValue()) + " bid.\n"); 
		}
		return output.toString();
		
	}
	
	@Override
	public String displayStatistics() {
		return "Statistics";
	}
	
	@Override
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
		if (advert == null) {
			throw new IllegalArgumentException("cannot take null parameters");
		}
		unsoldCars.remove(advert);
		if (advert.getHighestOffer().getValue() >= advert.getCar().getPrice()) {
			soldCars.put(advert, advert.getHighestOffer().getBuyer());
		} else {
			unsoldCars.put(advert, carsForSale.get(advert));
		}
		carsForSale.remove(advert);
	}
	
	@Override
	public boolean placeOffer(Advert carAdvert, User user, double value) {
		if (carAdvert == null || user == null || value < 0) {
			throw new IllegalArgumentException("cannot take null parameters");
		} else {			
			if (carsForSale.containsKey(carAdvert) && carAdvert.getCar().getType() == SaleType.FORSALE && value >= carAdvert.getCar().getPrice()) {
				carAdvert.placeOffer(user, value);
				endSale(carAdvert);
				return true;
			} else {
				return false;
			}
			
		}
	}
	
	@Override
	public void registerCar(Advert carAdvert, User user, String colour, CarType type, CarBody body, int noOfSeats) {
		try {
			if (!checkExistence(carAdvert.getCar()) && carAdvert.getCar().getType() == SaleType.FORSALE) {
				carAdvert.getCar().setBody(body);
				carAdvert.getCar().setColour(colour);
				carAdvert.getCar().setGearbox(type);
				carAdvert.getCar().setNumberOfSeats(noOfSeats);
				
				carsForSale.put(carAdvert, (Seller) user); //TODO more casting i am like a wizard
				unsoldCars.put(carAdvert, (Seller) user);
			}
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("parameters should not be null");
		}
		
	}
}
