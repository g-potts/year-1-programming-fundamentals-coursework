package lab10_exercise3;

public enum VATRate {
	
	ZERO(0.0), LOW(5.0), STANDARD(17.5);
	
	private double percentage;
	
	private VATRate(double percentage) {
		this.percentage = percentage;
	}
	
	public double getPercentage() {
		return percentage;
	}
}
