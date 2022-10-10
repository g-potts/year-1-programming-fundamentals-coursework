package lab2;

public class ClockDisplayTest {

	public static void main(String[] args) {
		ClockDisplay clock = new ClockDisplay();
		for (int i = 0; i < 1440; i++) {
			clock.timeTick();
			System.out.println(clock.toString());
		}
	}

}
