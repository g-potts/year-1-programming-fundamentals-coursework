package lab5_exercise1;

public class RainfallYear {
	private int year;
	private double[] rainfallMonths;
	
	public RainfallYear(int year) {
		this.year = year;
		this.rainfallMonths = new double[12];
	}
	
	public int getYear() {
		return year;
	}
	
	public double calculateMeanRainfall() {
		double total = 0;
		for (int i = 0; i < rainfallMonths.length; i++) {
			total += rainfallMonths[i];
		}
		return (total / rainfallMonths.length);
	}
	
	public double calculateHighestRainfall() {
		double highest = 0;
		for (int i = 0; i < rainfallMonths.length; i++) {
			if (rainfallMonths[i] > highest) {
				highest = rainfallMonths[i];
			}
		}
		return highest;
	}
	
	public void enterData(double[] rainfall) {
		this.rainfallMonths = rainfall;
	}
	
	public double getRainfallMonth(String month) {
		int monthNumber = 0;
		switch (month) {
		case "JANUARY":
			monthNumber = 0;
			break;
		case "FEBRUARY":
			monthNumber = 1;
			break;
		case "MARCH":
			monthNumber = 2;
			break;
		case "APRIL":
			monthNumber = 3;
			break;
		case "MAY":
			monthNumber = 4;
			break;
		case "JUNE":
			monthNumber = 5;
			break;
		case "JULY":
			monthNumber = 6;
			break;
		case "AUGUST":
			monthNumber = 7;
			break;
		case "SEPTEMBER":
			monthNumber = 8;
			break;
		case "OCTOBER":
			monthNumber = 9;
			break;
		case "NOVEMBER":
			monthNumber = 10;
			break;
		case "DECEMBER":
			monthNumber = 11;
			break;
		default:
			break;
		}
		
		return rainfallMonths[monthNumber];
	}
	
}
