package coursework_question1;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gp00652
 *
 */
public class Auctioneer { //TODO add comments in professional style
  /** name of auctioneer. */
  protected String name;
  /** map relating an advert for a car to the seller, while the advert is active.*/
  protected Map<Advert, User> carsForSale; //cars currently for sale
  /** map relating an advert for a car to the buyer once the car is bought.*/
  protected Map<Advert, User> soldCars; //cars bid on, sale ended successfully
  /** map relating an advert for a car to the seller when the car is not sold and taken off of market. */
  protected Map<Advert, User> unsoldCars; //cars with sale ended unsuccessfully
  
  
  /**
   * Constructor for Auctioneer, to define a new Auctioneer.
   * @param name the auctioneer's name.
   */
  public Auctioneer(String name) {
    this.name = name;
    this.carsForSale = new HashMap<Advert, User>();
    this.soldCars = new HashMap<Advert, User>();
    this.unsoldCars = new HashMap<Advert, User>();
  }

  /**
   * checks if the car given in the parameters is in the carsForSale map, and therefore if the car is for sale.
   * 
   * @param car the car that the method checks exists in carsForSale.
   * @return true if the car is for sale, false if it is not.
   */
  private boolean checkExistence(Car car) { //searches carsforsale by car, rather than advert or user
    for (Advert a : carsForSale.keySet()) {
      if (a.getCar() == car) {
        return true;
      }
    }
    return false;
  }

  /**
   * generates a String containing details about the adverts stored in soldCars.
   * 
   * @return text describing which cars were sold and who they were sold to.
   */
  public String displaySoldCars() {
    DecimalFormat d = new DecimalFormat("0.00");
    StringBuffer output = new StringBuffer();
    output.append("SOLD CARS:\n");
    for (Advert advert : soldCars.keySet()) {
      output.append(advert.getCar().getId());
      output.append(" - Purchased by ");
      output.append(advert.getHighestOffer().getBuyer().getName());
      output.append(" with a successful £" + d.format(advert.getHighestOffer().getValue()) + " bid.\n"); 
    }
    return output.toString();

  }

  /**
   * placeholder for future method, only returns the literal word 'Statistics'.
   * 
   * @return the word Statistics.
   */
  public String displayStatistics() {
    return "Statistics";
  }

  /**
   * generates a String containing details about the adverts stored in the unsoldCars map.
   * 
   * @return text describing cars which were not sold successfully.
   */
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

  /**
   * ends the sale on the given advert, and moves details to either sold or unsold cars depending on if a high enough offer was made.
   * 
   * @param advert the advert that the sale will end for.
   */
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

  /**
   * attempts to place an offer of a certain amount on an advert.
   * successfully places offer if the value is higher than the asking price or other offers on the car.
   * 
   * @param carAdvert the advert having an offer placed on it.
   * @param user the user wanting to buy the car associated to the advert.
   * @param value the price they are offering for the car.
   * @return true if their offer is accepted, false if their offer is too low or not accepted.
   */
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

  /**
   * adds given values to fields of car, and adds the related advert and seller to the carsForSale map.
   * 
   * @param carAdvert the advert associated to the car being registered with the auctioneer.
   * @param user the user looking to sell the car.
   * @param colour the colour of the car.
   * @param type the gearbox type of the car, either manual or automatic.
   * @param body the model of the car.
   * @param noOfSeats the number of seats the car has.
   */
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
