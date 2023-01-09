package coursework_question4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    String output = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader("auction_statistics.txt"));
      String line = br.readLine();
      String fullFile = line;
      line = br.readLine(); //adds first line outside of loop so that a line break is not added to the very end, which causes the jtest to fail
      while (line != null) {
        fullFile += "\n";
        fullFile += line;
        line = br.readLine();
      }
      br.close();
      output += "** Auctioneer - " + name + "**\n";
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

    if (advert.getHighestOffer().getValue() >= advert.getCar().getPrice()) {
      Seller seller = carsForSale.get(advert);
      seller.increaseSale();
      if (sales.replace(seller, seller.getSales()) == null) {
        sales.put(seller, 1);
      }
      soldCars.put(advert, advert.getHighestOffer().getBuyer());
      updateStatistics(seller);
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
    int totalSales = soldCars.size();
    int manualSales = 0;
    int autoSales = 0;
    double pcM = 0;
    double pcA = 0;

    for (Advert a : soldCars.keySet()) {
      if (a.getCar().getGearbox() == CarType.MANUAL) {
        manualSales++;
      } else if (a.getCar().getGearbox() == CarType.AUTOMATIC) {
        autoSales++;
      }

    }

    if (totalSales != 0) {
      pcM = ((double) (manualSales) /totalSales) * 100.0;
      pcA = ((double) (autoSales) / totalSales) * 100.0;
    }
    setTopSeller();
    saveInFile(totalSales, pcA, pcM);
  }

  private void setTopSeller() {
    for (Seller s : sales.keySet()) {
      if (topSeller == null) {
        topSeller = s;
      } else if (sales.get(s) > sales.get(topSeller)) {
        topSeller = s;
      }
    }
  }

  private void saveInFile(int noOfSales, double percentageOfAutomatic, double percentageOfManual) {
    //TODO auction_statistics.txt no calculations just saves file
    /*
     * Total Auction Sales: n
     * Automatic Cars: 0.0%
     * manual same
     * top seller: seller.tostring
     */
    DecimalFormat d = new DecimalFormat("#00.0");
    File stats = new File("auction_statistics.txt");	
    //delete file if need to
    stats.delete();
    //make new file
    try {
      stats.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //add values to file
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(stats));

      bw.write("Total Auction Sales: " + noOfSales + "\n");
      bw.write("Automatic Cars: " + d.format(percentageOfAutomatic) + "%\n");
      bw.write("Manual Cars: " + d.format(percentageOfManual) + "%\n");
      bw.write("Top Seller: " + topSeller);

      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //close connection
  }

  //getters setters

}
