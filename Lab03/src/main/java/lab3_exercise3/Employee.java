package lab3_exercise3;

public class Employee {
	
	private int id;
	private String forename;
	private String surname;
	private AnnualSalary salary;
	private Position companyPosition;
	
	public Employee(int id, String forename, String surname, AnnualSalary salary, Position companyPosition) {
		this.id = id;
		this.forename = forename;
		this.surname = surname;
		this.salary = salary;
		this.companyPosition = companyPosition;
	}
	
	public int getId() {
		return id;
	}
	
	public String getForename() {
		return forename;
	}
	
	public String getSurname() {
		return surname;
	}

	public double getSalary() {
		return this.salary.getSalary();
	}

	public String getPositionName() {
		return this.companyPosition.getRoleName();
	}

	public void displayEmployeeName() {
		System.out.println(this.getForename() + this.getSurname());
	}
	
	private boolean eligibleForBonus() {
		return (this.salary.getSalary() >= 40000);
	}

	@Override
	public String toString() {
		int eligible = 1;
		if (this.eligibleForBonus() == true) {
			eligible = 0;
		}
		
		return (this.getSurname() + ", " + this.getForename() + " (" + this.getId() + "): " + this.companyPosition.getRoleName()
		+ " at £" + this.salary.getSalary() + " (£" + this.salary.calculateTax() + " tax) and is " + ("not ".repeat(eligible)) + "eligible for bonus.");
	}
	
}
// lastname, firstname (id): role at income (tax) and is/isn't eligible for bonus
