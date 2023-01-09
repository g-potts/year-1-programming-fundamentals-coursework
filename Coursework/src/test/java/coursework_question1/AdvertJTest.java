package coursework_question1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdvertJTest { //TODO wholeass jtest [q1 advert test]
	//User buyer = new User("Bob Smith");
	//Car car = new Car(1234, "Fiat 500", 5000, Condition.USED);
	Advert advert = null;
			
	//test null construction
	@Test(expected = IllegalArgumentException.class)
	public void coursework_testInvalidAdvertConstruction() {
		advert = new Advert(null);
	}
	//test place offer successfully
	@Test
	public void coursework_testPlaceOffer(){
		User buyer = new User("Bob Smith");
		Car car = new Car(1234, "Fiat 500", 5000, Condition.USED);
		advert = new Advert(car);
		
		assertEquals(advert.placeOffer(buyer, 6000), true);
	}
	
	//test low offer
	@Test
	public void coursework_testUnsuccessfulOffer() {
		User buyer = new User("Bob Smith");
		Car car = new Car(1234, "Fiat 500", 5000, Condition.USED);
		advert = new Advert(car);
		
		advert.placeOffer(buyer, 6000);
		assertEquals(advert.placeOffer(buyer, 200), false);
	}
	
	//TODO test get highest offer successfully
	@Test
	public void coursework_testGetHighestOffer() {
		User buyer = new User("Bob Smith");
		Car car = new Car(1234, "Fiat 500", 5000, Condition.USED);
		advert = new Advert(car);
		
		advert.placeOffer(buyer, 6000);
		advert.placeOffer(buyer, 7000);
		assertEquals(advert.getHighestOffer().getValue(), 7000, 0);
	}
	//test to string
	@Test
	public void coursework_advertToString() {
		Car car = new Car(1234, "Fiat 500", 5000, Condition.USED);
		advert = new Advert(car);
		
		assertEquals("Ad: 1234 - Fiat 500 (£5000.00)\n"
				+ "	Type: null\n"
				+ "	Style: null\n"
				+ "	Colour: null\n"
				+ "	No. of Seats: 0\n"
				+ "	Condition: USED\n", advert.toString());
	}
	//test car getter
	
	
	
}
