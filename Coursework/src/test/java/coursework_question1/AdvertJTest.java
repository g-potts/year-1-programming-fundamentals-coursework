package coursework_question1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdvertJTest { //TODO wholeass jtest
	Advert advert = new Advert(new Car(/*parameters ugh*/));
			
	//test null construction
	@Test(expected = IllegalArgumentException.class)
	public void coursework_testInvalidAdvertConstruction() {
		Advert advert = new Advert(null);
	}
	//test successful construction
	
	//test get highest offer successfully
	
	//test place offer returns false when needed
	
	//test to string
	
	
	
}
