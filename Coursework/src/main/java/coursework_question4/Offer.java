package coursework_question4;

import java.text.DecimalFormat;

public class Offer {

  private double value;
  private User buyer;

  public Offer(User buyer, double value) { 
    if (value > 0 && buyer instanceof Buyer) {
      this.value = value;
      this.buyer = buyer;
    } else {
      throw new IllegalArgumentException("offer has invalid amount or user is not a buyer");
    }
  }

  //getters/setters
  public Buyer getBuyer() {
    return (Buyer) this.buyer; //TODO is this really meant to be cast?
  }

  public double getValue() {
    return this.value;
  }

  //toString format: fullname offered £value
  @Override
  public String toString() {
    DecimalFormat d = new DecimalFormat("0.00");
    StringBuffer output = new StringBuffer();
    output.append(this.buyer.toString());
    output.append(" offered £");
    output.append(d.format(value));
    return output.toString();
  }
}
