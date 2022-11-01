package lab6_exercise3;

public class MedalTable {
	
	private int[][] medals;
	
	public MedalTable() {
		this.medals = new int[Countries.values().length][Medals.values().length];
	}
	
	public void addMedal(Countries country, Medals medal) {
		medals[country.getIndex()][medal.getIndex()] += 1;
	}
	
	public int getMedals(Countries country, Medals medal) {
		return medals[country.getIndex()][medal.getIndex()];
	}
	
	public int getEUMedalCount() {
		int output = 0;
		for (Countries c : Countries.values()) {
			if (c.isEU()) {
				for (Medals m : Medals.values()) {
					output += medals[c.getIndex()][m.getIndex()];	
				}
			}
		}
		return output;
	}
}
