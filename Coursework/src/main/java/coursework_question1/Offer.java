package coursework_question1;

import java.text.DecimalFormat;

public class Offer {
	
	private double value;
	private User buyer;
	
	//constructor, checks for invalid offer amt
	public Offer(User buyer, double value) { 
		if (value > 0) {
			this.value = value;
		} else {
			throw new IllegalArgumentException("offer has invalid amount");
		}
		if (buyer != null) {
			this.buyer = buyer;
		} else {									// TODO should this be try catch?
			throw new IllegalArgumentException();
		}

	}
	//simple accessor
	public User getBuyer() {
		return this.buyer;
	}
	
	public double getValue() {
		return this.value;
	}
	
	//tostring: fullname offered £value
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
