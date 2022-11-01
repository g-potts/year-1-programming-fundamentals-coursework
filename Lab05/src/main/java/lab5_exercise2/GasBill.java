package lab5_exercise2;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class GasBill {
	
	private String accountNumber;
	private double amount;
	private Customer customer;
	
	public GasBill(String accnumber, double amount, Customer customer) {
		if (Pattern.matches("[0-9]{4}\\-[0-9]{4}\\-[0-9]{4}", accnumber)) {
			this.accountNumber = accnumber;
		} else {
			this.accountNumber = "Invalid Account";
		}
		this.amount = amount;
		this.customer = customer;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public boolean checkAccountAccuracy() {
		return !(accountNumber.equals("Invalid Account"));
	}
	
	public String getCustomer() {
		return customer.toString();
	}
	
	private String displayAmountDue() {
		//use formatting and tostring
		DecimalFormat style = new DecimalFormat("00.00");
		return style.format(amount);
	}
	
	public String displayAccountDetails() {
		return ("Gas Bill\n Account Number:" + this.getAccountNumber() + "\n Customer:" + this.getCustomer() + "\n Amount due:" + this.displayAmountDue());
	}
	
}
