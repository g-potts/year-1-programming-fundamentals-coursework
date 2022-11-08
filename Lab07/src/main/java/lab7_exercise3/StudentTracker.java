package lab7_exercise3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTracker {
	
	private List<Student> studentList;
	private Map<Integer, String> moduleList;
	
	public StudentTracker() {
		this.studentList = new ArrayList<Student>();
		this.moduleList = new HashMap<Integer, String>();
	}
	
	public String printStudents()  {
		StringBuffer output = new StringBuffer();
		for (Student s : studentList) {
			output.append(s.getName());
			output.append("(");
			output.append(s.getUrn());
			output.append(")\n");
		}
		return output.toString();
	}
	
	public void addStudent(Student student, List<Module> module) {
		for (Module m : module) {
			student.addModuleList(m);
		}
		studentList.add(student);
	}
	
	private void initialiseMap() {
		/// map int = urn, string = list of modules returned
		for (Student s : studentList) {
			moduleList.put(s.getUrn(), s.printModules());
		}
		
	}
	
	public String printModules(int urn) {
		initialiseMap();
		return ("URN " + urn + " is enrolled in:\n" + moduleList.get(urn));
	}
}
