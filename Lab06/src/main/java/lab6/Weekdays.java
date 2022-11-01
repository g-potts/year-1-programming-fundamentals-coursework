package lab6;


/**
 * A more complex enumerated type to represent week days with working day
 * parameters.
 *
 * @author Stella Kazamia
 * 
 */
public enum Weekdays {
	MONDAY("working day"), TUESDAY("working day"), WEDNESDAY("working day"), THURSDAY("working day"),
	FRIDAY("working day"), SATURDAY("weekend"), SUNDAY("weekend");

	/**
	 * To add a parameter to each enum we need a field of the correct type to hold
	 * the value.
	 */
	private String dayType;

	/**
	 * We also need a constructor to allow the parameter to be put into the field.
	 * Note that the constructor is private as we do not create objects from an
	 * enum.
	 * 
	 * @param dayType the type of day as specified in the parameter for each value.
	 */
	private Weekdays(String dayType) {
		this.dayType = dayType;
	}

	/**
	 * To retrieve the parameter for a given value, we need a getter.
	 * 
	 * @return the type of day.
	 */
	public String getDayType() {
		return this.dayType;
	}
}

