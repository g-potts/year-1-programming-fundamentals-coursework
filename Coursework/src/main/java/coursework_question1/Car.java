package coursework_question1;

public class Car {
	
	private int id;
	private String name;
	private String colour;
	private double reservedPrice;
	private CarType gearbox;
	private CarBody body;
	private int numberOfSeats;
	private Condition condition;
	
	//constructor - id, name, price, condition
	public Car(int id, String name, double price, Condition condition) { // TODO illegal argument exception on id, name, price
		this.id = id;
		this.name = name;
		this.reservedPrice = price;
		this.condition = condition;
	}
	//methods:
	public String displayCarSpecification() {
		/*OUTPUT LAYOUT:
		 * id - name (£price.00)\n 			OR 			car.toString() (£price.00)
		 * tab	Type: gearbox\n
		 * 		Style: body\n
		 * 		no. of seats: number\n
		 * 		Condition: condition
		 * */
	}

	@Override
	public String toString() {
		/*
		 * layout: id - name
		 * */
	}
	
	
	//getters: id, name, price, body, colour, gearbox, seats
	//setters: body, colour, gearbox, seats
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public CarType getGearbox() {
		return gearbox;
	}

	public void setGearbox(CarType gearbox) {
		this.gearbox = gearbox;
	}

	public CarBody getBody() {
		return body;
	}

	public void setBody(CarBody body) {
		this.body = body;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getReservedPrice() {
		return reservedPrice;
	}
}
