package lab7_exercise3;

public class Module {
	
	private String name;
	
	public Module(String name) {
		if (name.matches("[A-Z]{3}[0-9]{4}")) {
			this.name = name;
		} else {
			this.name = "Error";
		}
	}
	
	public String getName() {
		return name;
	}
	
}
