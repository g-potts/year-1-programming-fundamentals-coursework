package exercise1;
import java.text.DecimalFormat;

public class ClockDisplay {
	private NumberInfo hours;
	private NumberInfo minutes;
	private boolean am = true;
	
	public ClockDisplay(boolean format12) { //creates a clock with format of either 12 or 24 hours depending on boolean parameter
		
		if (format12 ==  true) {
			this.hours = new NumberInfo(12);
		} else {
			this.hours = new NumberInfo(24);
		}
		
		this.minutes = new NumberInfo(60);
	}
	
	public void timeTick() {
		//increment minutes
		minutes.increment();
		
		if (minutes.getValue() == 0) {
			//change hour after 60 mins
			hours.increment();
			
			if (hours.getValue() == 0 && hours.getLimit() == 12) {
				am = !am; //changes between am and pm when clock cycles round, only in 12hr format
				if (am == false) {
					hours.setValue(12); //clock shows 0am and 12pm for 12hr clock, rather than 0pm or 12am
				}
			}
			
		}
	}
	
	@Override
	public String toString() {
		DecimalFormat styleHR = new DecimalFormat("0"); //different format for hours to show 3:00 instead of 03:00
		DecimalFormat styleMIN = new DecimalFormat("00");
		
		String suffix = "";
		if (this.hours.getLimit() == 12) { //adds am or pm to end of 12hr clock
			if (am) {
				suffix = "am";
			} else {
				suffix = "pm";
			}
		}
		String prefix; //following if statement makes 3:00 for 12hr and 03:00 for 24hr view
		if ((this.hours.getLimit() == 24) && this.hours.getValue() < 10) {
			prefix = "0";
		} else {
			prefix = "";
		}
		
		return (prefix + styleHR.format(this.hours.getValue()) + ":" + styleMIN.format(this.minutes.getValue()) + suffix);
	}
	
	
}
