package lab6_exercise3;

public enum Medals {
	
	GOLD(2), SILVER(1), BRONZE(0);
	
	int index = 0;
	
	private Medals(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public static Medals[] orderedMedals() {
		// Use the index as an array index.
		Medals[] medals = new Medals[Medals.values().length];
		for (Medals medal : Medals.values()) {
			medals[medal.getIndex()] = medal;
		}
		return medals;
	}
	
}
