package lab4_exercise3;

public class Session {
	
	private String sessionName;
	private int startTime;
	private int endTime;
	
	public Session() {
		super();
	}
	
	public String getSessionName() {
		return sessionName;
	}
	
	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
}
