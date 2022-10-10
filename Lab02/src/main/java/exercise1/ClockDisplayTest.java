package exercise1;

public class ClockDisplayTest {

	public static void main(String[] args) {
		
		boolean format12Hour = true; // true for 12hr, false for 24hr clock
		
		ClockDisplay clock = new ClockDisplay(format12Hour); 
		
		for (int i = 0; i < 1440; i++) { //1440 to show 24hr cycle
			clock.timeTick();
			System.out.println(clock.toString());
		}
	}

}
