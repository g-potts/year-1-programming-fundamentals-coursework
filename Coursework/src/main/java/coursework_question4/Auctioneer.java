package coursework_question4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Auctioneer extends Dealership { //TODO add comments after made in q1
	
	private Map<Seller, Integer> sales;
	private Seller topSeller;
	
	//constructor
	public Auctioneer(String name) {
		super(name);
		this.sales = new HashMap<Seller, Integer>();
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
		//TODO auctioneer - name + txt file contents
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
		
		if (advert.getHighestOffer().getValue() >= advert.getCar().getPrice()) {
			Seller seller = carsForSale.get(advert);
			updateStatistics(seller); 
			
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
			if (carsForSale.containsKey(carAdvert)) {
				carAdvert.placeOffer(user, value);
				return true;
			} else {
				return false;
			}
		}
	}
	
	@Override
	public void registerCar(Advert carAdvert, User user, String colour, CarType type, CarBody body, int noOfSeats) {
		if (!(user instanceof Seller)) {
			throw new IllegalArgumentException("user must be seller");
		}
		try {
			if (!checkExistence(carAdvert.getCar())) {
				carAdvert.getCar().setBody(body);
				carAdvert.getCar().setColour(colour);
				carAdvert.getCar().setGearbox(type);
				carAdvert.getCar().setNumberOfSeats(noOfSeats);
				
				carsForSale.put(carAdvert, (Seller) user); //TODO another cast
			}
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("parameters should not be null");
		}
		
	}
	
	private void updateStatistics(Seller seller) {
		//TODO updates number of automatic and manual cars, and their top seller. top = most sales. can add more private methods
		//gets most recent sale? and type?
		Seller s = null;
		Advert advert = null;
		for (Advert a : carsForSale.keySet()) {
			s = carsForSale.get(a);
			if (s == seller) {
				advert = a;
				break;
			}
		}
		//get numbers from file
		
		int totalSales = seller.getSales();
		int manualSales = 0;
		int autoSales = 0;
		double pcM = 0;
		double pcA = 0;
		
		File stats = new File("auction_statistics.txt");
		try {
			if (stats.createNewFile()) { //make new file if need to
				
			} else {
				//read from file
				//get number from automatic, line 2
				//get numebr from manual, line 3
				BufferedReader b = new BufferedReader(new FileReader(stats));
				String line = b.readLine();
				while (b != null) {
					System.out.println(line);
					line = b.readLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		switch (advert.getCar().getGearbox()) {
		case MANUAL:
			break;
		case AUTOMATIC:
			break;
		default:
			throw new IllegalArgumentException("gearbox is not proper type");
		}
		//calls save in file to get new values and change values
	}
	
	private void saveInFile(int noOfSales, double percentageOfAutomatic, double percentageOfManual) {
		//TODO auction_statistics.txt no calculcations just saves file
		/*
		 * Total Auction Sales: n
		 * Automatic Cars: 0.0%
		 * manual same
		 * top seller: seller.tostring
		 */
	}
	
	//getters setters
	
}
