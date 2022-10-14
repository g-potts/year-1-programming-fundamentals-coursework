package lab3_exercise2;

public class AnnualSalary {
	
	private double salary;
	
	public AnnualSalary() {
		super();
		this.salary = 0;
	}
	
	public double calculateTax() {
		double tax40 = 0; // set to 0 since if 12500<income<50000 tax40 is not applicable but is used in calculation
		double tax20;
		double salaryWorking = this.salary; // salary value for workings
		
		if (this.salary <= 12500) {
			return 0; // no calculations since income is less than allowance
		} else {
			if (this.salary > 50000) { //calculates higher tax if applicable
				tax40 = (salaryWorking - 50000) * 0.4;
				salaryWorking = 50000;
			}
			tax20 = (salaryWorking - 12500) * 0.2; //calculates lower tax
			return (tax40 + tax20); //returns total tax
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
 /*
  * if salary over 50k
  * 	40pc tax on above
  * then 20pc tax on under 50k - allowance
  * 
  * total income = salary - taxes
  * */
