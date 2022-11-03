package lab4_exercise3;

public class WeekTimetable {
	
	private Day[] days;
	
	public WeekTimetable() {
		this.days = new Day[5];
		
	}
	
	public void addDailySessions(int index, Day day) {
		this.days[index] = day;
	}
	
	public String printTimetable() {
		String output = "";
		String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		for (int i = 0; i < 5; i++) {
			output += (weekdays[i] + "\n" + days[i].toString() + "\n");
		}
		return output;
	}
	
}
