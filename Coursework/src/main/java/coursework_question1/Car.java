package coursework_question1;

import java.text.DecimalFormat;

public class Car {

  private int id;
  private String name;
  private String colour;
  private double reservedPrice;
  private CarType gearbox;
  private CarBody body;
  private int numberOfSeats;
  private Condition condition;

  //constructor - id, name, price, condition
  public Car(int id, String name, double price, Condition condition) {
    if ((name == null) || (id < 0) || (price < 0)) {
      throw new IllegalArgumentException("invalid parameters");
    } else {
      this.id = id;
      this.name = name;
      this.reservedPrice = price;
      this.condition = condition;
    }

  }
  //methods:
  public String displayCarSpecification() {
    DecimalFormat d = new DecimalFormat("0.00");
    StringBuffer output = new StringBuffer();
    output.append(this.toString() + " (£" + d.format(reservedPrice) + ")\n");
    output.append("	Type: " + this.gearbox + "\n");
    output.append("	Style: " + this.body + "\n");
    output.append("	Colour: " + this.colour + "\n");
    output.append("	No. of Seats: " + this.numberOfSeats + "\n");
    output.append("	Condition: " + this.condition);
    return output.toString();
  }

  @Override
  public String toString() {
    //layout: id - name
    return (Integer.toString(this.id) + " - " + this.name);
  }


  //getters: id, name, price, body, colour, gearbox, seats
  //setters: body, colour, gearbox, seats
  public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  public CarType getGearbox() {
    return gearbox;
  }

  public void setGearbox(CarType gearbox) {
    this.gearbox = gearbox;
  }

  public CarBody getBodyStyle() {
    return body;
  }

  public void setBody(CarBody body) {
    this.body = body;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return reservedPrice;
  }
}
