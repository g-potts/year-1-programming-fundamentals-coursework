package lab2;

public class NumberTest {

	
	public static void main(String[] args) {
		NumberInfo number = new NumberInfo(3);
		System.out.println(number.getValue());
		number.increment();
		System.out.println(number.getValue());
		number.increment();
		System.out.println(number.getValue());
		number.increment();
		System.out.println(number.getValue());
	}

}
