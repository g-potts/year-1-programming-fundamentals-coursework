package lab10_exercise3;

import java.util.ArrayList;
import java.util.List;

public class Guest implements IGuest {
	
	private String forename;
	private String surname;
	private String address;
	private String telephone;
	private List<Charge> charges;
	
	public Guest(String forename, String surname, String address, String telephone) {
		this.forename = forename;
		this.surname = surname;
		this.address = address;
		this.telephone = telephone;
		this.charges = new ArrayList<Charge>();
	}
	
	@Override
	public void addCharge(Service service, double charge) {
		Charge c = new Charge(service, charge);
		charges.add(c);
	}

	@Override
	public double calculateTotalChargeWithoutVAT() {
		//= total charge
		double count = 0;
		for (Charge c : charges) {
			count += c.getCharge();
		}
		return count;
	}

	@Override
	public double calculateVATChargeAtRate(VATRate rate) {
		// = sum of charges multiplied by vat rate
		double count = this.calculateTotalChargeWithoutVAT();
		return (count * rate.getPercentage() / 100);
	}
	
	@Override
	public String toString() {
		return (forename + " " + surname + ", " + address + ", " + telephone);
	}

	public String getForename() {
		return forename;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return address;
	}

	public String getTelephone() {
		return telephone;
	}

	public List<Charge> getCharges() {
		return charges;
	}
	
}
