package lab10_exercise3;

public class Service {
	
	private String code;
	private String name;
	private VATRate rate; 
	private double standardCharge;
	
	
	public Service(String code, String name, VATRate rate, double standardCharge) {
		if (code == null || name == null || rate == null) {
			throw new NullPointerException();
		} else {
			if (code.matches("[A-Z]{4}[0-9]{4}") && standardCharge > 0) {
				this.code = code;
				this.standardCharge = standardCharge;
			} else {
				throw new IllegalArgumentException("code does not match requirements");
			}
			this.name = name;
			this.rate = rate;
		}
	}


	public String getCode() {
		return code;
	}


	public String getName() {
		return name;
	}


	public VATRate getRate() {
		return rate;
	}


	public double getStandardCharge() {
		return standardCharge;
	}
	
	
}
