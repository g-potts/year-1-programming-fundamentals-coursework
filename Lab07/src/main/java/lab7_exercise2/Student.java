package lab7_exercise2;
import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private String name;
	private int urn;
	private List<Module> moduleList;
	
	public Student(String name, int urn) {
		this.moduleList = new ArrayList<Module>();
		if (name.matches("[A-Z][a-z]* [A-Z][a-z]*") && (urn >= 10000) && (urn <= 99999)) {
			this.name = name;
			this.urn = urn;
		} else {
			this.name = "INVALID STUDENT";
			this.urn = 0;
		}
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
				output.append(" ");
			} else {
				output.append(", ");
			}
			
		}
		return output.toString();
	}
	
}
