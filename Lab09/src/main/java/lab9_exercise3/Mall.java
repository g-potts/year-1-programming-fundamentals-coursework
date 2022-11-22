package lab9_exercise3;

import java.util.HashMap;
import java.util.Map;

public class Mall {
	
	private Map<Integer, Shop> shops;
	
	public Mall() {
		shops = new HashMap<Integer, Shop>();
	}
	
	public void addShop(int number, Shop shop) {
		if (number < 0) {
			throw new IllegalArgumentException();
		} else if (shop == null) {
			throw new NullPointerException();
		} else {
			shops.put(number, shop);
		}
	}
	
	public String displayAllShops() {
		StringBuffer output = new StringBuffer();
		for (int i : shops.keySet()) { //number : shopdisplay
			output.append(i);
			output.append(" : ");
			output.append(shops.get(i).displayCatalogue());
		}
		return output.toString();
	}
}
