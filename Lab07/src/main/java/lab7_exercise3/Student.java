package lab7_exercise3;
import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private String name;
	private int urn;
	private List<Module> moduleList;
	
	public Student(String name, int urn) {
		this.moduleList = new ArrayList<Module>();
		if (name.matches("[A-Z][a-z]* [A-Z][a-z]*")) {
			this.name = name;
		} else {
			this.name = "Error";
		}
		this.urn = urn;
	}

	public String getName() {
		return name;
	}

	public int getUrn() {
		return urn;
	}
	
	public void addModuleList(Module module) {
		if (!moduleList.contains(module)) {
			moduleList.add(module);
		}
	}
	
	public String printModules() {
		StringBuffer output = new StringBuffer();
		for (Module m : moduleList) {
			output.append(m.getName());
			if (moduleList.indexOf(m) == (moduleList.size() - 1)) {
				//output.append(" ");
			} else {
				output.append(", ");
			}
			
		}
		return output.toString();
	}
	
}
