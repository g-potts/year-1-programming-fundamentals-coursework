package coursework_question1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdvertJTest { //TODO wholeass jtest [q1 advert test]
	User buyer = new User("Bob Smith");
	Car car = new Car(1234, "Fiat 500", 5000, Condition.USED);
	Advert advert = new Advert(car);
			
	//test null construction
	@Test(expected = IllegalArgumentException.class)
	public void coursework_testInvalidAdvertConstruction() {
		Advert nullAdvert = new Advert(null);
	}
	//test place offer successfully
	@Test
	public void coursework_testPlaceOffer(){
		assertEquals(advert.placeOffer(buyer, 6000), true);
	}
	
	//test low offer
	@Test
	public void coursework_testUnsuccessfulOffer() {
		advert.placeOffer(buyer, 6000);
		assertEquals(advert.placeOffer(buyer, 200), false);
	}
	
	//TODO test get highest offer successfully
//	@Test
//	public void coursework_testGetHighestOffer() {
//		advert.placeOffer(buyer, 6000);
//		advert.placeOffer(buyer, 7000);
//		assertEquals(advert.getHighestOffer(), new Offer(buyer, 700));
//	}
	//test to string
	@Test
	public void coursework_advertToString() {
		System.out.println(advert.toString());
		assertEquals(advert.toString(), "");
	}
	//test car getter
	
	
	
}
