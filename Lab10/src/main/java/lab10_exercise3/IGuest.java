package lab10_exercise3;

public interface IGuest {
	
	public abstract void addCharge(Service service, double charge);
	public abstract double calculateTotalChargeWithoutVAT();
	public abstract double calculateVATChargeAtRate(VATRate rate);
	@Override
	public abstract String toString();
	
}
