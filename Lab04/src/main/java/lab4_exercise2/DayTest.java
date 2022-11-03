package lab4_exercise2;

public class DayTest {

	public static void main(String[] args) {
		
		Day test = new Day("Monday");
		test.setSession(0, "COM1027", 9, 10);
		test.setSession(1, "COM1025", 15, 17);
		
		test.display();
		
	}

}
