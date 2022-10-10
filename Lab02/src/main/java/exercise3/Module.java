package exercise3;

public class Module {
	
	private Assessment assessment1;
	private Assessment assessment2;
	
	public Module(Assessment assessment1, Assessment assessment2) {
		this.assessment1 = assessment1;
		this.assessment2 = assessment2;
	}
	
	public double calculateAverage() {
		return (  (20 * (assessment1.getMark() / assessment1.getMaximum()) ) + (80 * (assessment2.getMark() / assessment2.getMaximum()) ) );
		
	}

	@Override
	public String toString() { //gives bracket part of output
		return ("COM1027 Average = " + this.calculateAverage() + "% [" + assessment1.getName() + "(20%) = " + assessment1.getMark() + "% ," + assessment2.getName() + "(80%) = " + assessment2.getMark() + "% ]");
		
	}
	
	
	
}
