package coursework_question4;

public class Seller extends User {
	
	private int sales = 0;
	
	public Seller(String fullname) {
		super(fullname);
	}
	
	public String identifyRating() {
		if (sales > 10) {
			return "Level 3";
		} else if (sales >=6 ){
			return "Level 2";
		} else if (sales > 0) {
			return "Level 1";
		} else {
			return "Level 0";
		}
	}
	
	@Override
	public String toString() {
		//FORMAT: First L. (Sales: n, Rating: Level n)
		String output = getName() + " " + getFullName().split(" ")[1].charAt(0) + ". "; //first name last initial
		output += "(Sales: " + sales + ", Rating: " + identifyRating() + ")"; //bracket part
		return output;
	}
	
	public int getSales() {
		return sales;
	}
	
	public void increaseSale() {
		sales++;
	}

}
