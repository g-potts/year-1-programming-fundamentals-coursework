package coursework_question4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Trader extends Dealership {
	
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
	
	private int getTotalSales() {
		int sales = 0;
		for (Seller s : sellers) {
			sales += s.getSales();
		}
		return sales;
	}
	
	@Override
	public String displayStatistics() {
		String output = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("trade_statistics.txt"));
			String line = br.readLine();
			String fullFile = line;
			line = br.readLine();
			while (line != null) {
				fullFile += "\n";
				fullFile += line;
				line = br.readLine();
			}
			br.close();
			output += "** Trader - " + name + "**\n";
			output += fullFile;
		} catch (IOException e) {
			//TODO check all exceptions in this class and make print errors
			e.printStackTrace();
		}
		return output;
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
			Seller s = carsForSale.get(advert);
			soldCars.put(advert, advert.getHighestOffer().getBuyer());
			updateStatistics(s);
			
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
	
	private void updateStatistics(Seller seller) {
		seller.increaseSale();
		if (!sellers.contains(seller)) {
			sellers.add(seller);
		}
		
		
		saveInFile(getTotalSales());
		//sellers.sort(null);
	}
	
	private void saveInFile(int noOfSales) {
		File file = new File("trade_statistics.txt");
		
		file.delete();
		//make new file
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//add values to file
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			bw.write("Total Sales: " + noOfSales + "\n");
			bw.write("All Sellers:\n");
			for (Seller s : sellers) {
				bw.write("\t" + s.toString() + "\n");
			}
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
