package lab9_exercise3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Shop{
	
	private List<IItem> items;
	
	public Shop() {
		this.items = new ArrayList<IItem>();
	}
	
	public void addItem(IItem item) {
		items.add(item);
	}
	
	public String displayCatalogue() {
		DecimalFormat d = new DecimalFormat("0.00");
		StringBuffer output = new StringBuffer();
		output.append("Shop Catalogue\n\nItem\t\tPrice\tSale Price\n");
		for (IItem i : items) {
			output.append(i.getName());
			output.append("\t£");
			output.append(d.format(i.getPrice()));
			output.append("\t£");
			output.append(d.format(i.calculateSalePrice()));
			output.append("\n");
		}
		return output.toString();
	}

}
