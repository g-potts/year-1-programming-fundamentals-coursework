package lab9_exercise3;

public class TV extends AbstractItem {

	private static final double SALE_PERCENTAGE = 0.8;
	private int size;
	
	public TV(double price, int size) {
		super(price);
		this.size = size;
	}

	@Override
	public double calculateSalePrice() {
		return this.getPrice() * SALE_PERCENTAGE;
	}

	@Override
	public String getName() {
		StringBuffer output = new StringBuffer();
		output.append("TV (");
		output.append(size);
		output.append("\")");
		return output.toString();
	}
	
	public int getSize() {
		return this.size;
	}
}
