package lab4_exercise1;

public class Neighbourhood {
	
	House[] houses = new House[3];
	
	public Neighbourhood() {
		
		houses[0] = new House(3, 4);
		houses[1] = new House(5, 1);
		houses[2] = new House(7, 2);
		
	}
	
	public void setHouses(int index, int houseNumber, int bottles) {
		houses[index] = new House(houseNumber, bottles);
	}
	
	public House getHouses(int index) {
		return houses[index];
	}
	
	public int calculateTotal() {
		int n = 0;
		for (House i : houses) {
			n += i.getNumberBottles();
		}
		return n;
	}
	
	public String displayArray() {
		String s = "";
		for (House x : houses) {
			s += ("Number of bottles in House number " + x.getNumberOfHouse() + " is " + x.getNumberBottles() + "\n");
		}
		s += ("Total number of bottles to be delivered: " + this.calculateTotal());
		return s;
	}
	
	
}
