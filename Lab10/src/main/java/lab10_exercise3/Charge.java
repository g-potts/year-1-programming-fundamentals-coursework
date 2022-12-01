package lab10_exercise3;

public class Charge {
	
	private Service service;
	private double charge;
	
	public Charge(Service service, double charge) {
		this.service = service;
		this.charge = charge;
	}
	
	public double calculateVAT() {
		return service.getRate().getPercentage();
	}

	public Service getService() {
		return service;
	}

	public double getCharge() {
		return charge;
	}
	
}
