package lab9;

public class TV implements IItem {
	
	private double price;
	private int size;
	
	public TV(double price, int size) {
		this.price = price;
		this.size = size;
	}
	
	@Override
	public double calculateSalePrice() {
		return (price * 0.8);
	}

	@Override
	public String getName() {
		StringBuffer output = new StringBuffer();
		output.append("TV (");
		output.append(size);
		output.append("\")");
		return output.toString();
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getSize() {
		return this.size;
	}

}
