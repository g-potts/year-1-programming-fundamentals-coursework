package exercise3;

public class Assessment {
	
	private String name;
	private int maximum = 100;
	private double mark;
	
	public Assessment(String name, double mark) {
		this.name = name;
		this.mark = mark;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMaximum() {
		return maximum;
	}
	
	public double getMark() {
		return mark;
	}
		
}
