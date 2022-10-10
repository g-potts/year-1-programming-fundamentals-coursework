package exercise3;

public class ModuleTest {

	public static void main(String[] args) {
		
		Assessment assessment1 = new Assessment("Labs", 90.0);
		Assessment assessment2 = new Assessment("Coursework", 72.0);
		
		Module module = new Module(assessment1, assessment2);
		
		System.out.println(module.toString());
	}

}
