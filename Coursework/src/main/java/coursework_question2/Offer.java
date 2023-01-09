package coursework_question2;

import java.text.DecimalFormat;

public class Offer {

  private double value;
  private User buyer;

  public Offer(User buyer, double value) { 
    if (value > 0 && buyer != null) {
      this.value = value;
      this.buyer = buyer;
    } else {
      throw new IllegalArgumentException("offer has invalid amount");
    }
  }

  //getters/setters
  public User getBuyer() {
    return this.buyer;
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
