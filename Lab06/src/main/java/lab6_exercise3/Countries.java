package lab6_exercise3;

public enum Countries {
	
	BRITAIN(0, false), CANADA(1, false), CHINA(2, false), RUSSIA(3, false), FRANCE(4, true);
	
	int index = 0;
	boolean isInEU = false;
	
	private Countries(int index, boolean EU) {
		this.index = index;
		this.isInEU = EU;
	}

	public int getIndex() {
		return index;
	}

	public boolean isEU() {
		return isInEU;
	}
	
	public static Countries[] orderedCountries() {
		// Use the index as an array index.
		Countries[] output = new Countries[Countries.values().length];
		for (Countries country : Countries.values()) {
			output[country.getIndex()] = country;
			}
		return output;
	}
}
