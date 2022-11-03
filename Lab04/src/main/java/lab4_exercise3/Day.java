package lab4_exercise3;

public class Day {
	
	private String name;
	private Session[] sessions;
	
	public Day(String name) {
		this.name = name;
		this.sessions = new Session[] {null, null, null, null};
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSession(int index, String moduleName, int StartTime, int Endtime) {
		this.sessions[index] = new Session();
		this.sessions[index].setSessionName(moduleName);
		this.sessions[index].setStartTime(StartTime);
		this.sessions[index].setEndTime(Endtime);
	}
	
	@Override
	public String toString() {
		//module name: start time - end time
		String output = "";
		for (int i = 0; i < 4; i++) {
			if (this.sessions[i] != null) {
			output += (this.sessions[i].getSessionName() + ": " + this.sessions[i].getStartTime() + " - " + this.sessions[i].getEndTime() + "\n");
			}
		}
		return output;
	}
	
	public void display() {
		System.out.println(this.toString());
	}
	
}
