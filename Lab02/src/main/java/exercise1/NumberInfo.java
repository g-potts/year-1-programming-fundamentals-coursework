package exercise1;

public class NumberInfo {
	private int limit;
	private int value;
	
	public NumberInfo(int limit) { //constructor for  numberinfo object with limit
		super();
		this.limit = limit;
	}

	public int getValue() {
		return value;
	}
	
	public int getLimit() {
		return limit;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void increment(){ // value of numberinfo object increases but does not pass limit
		this.value++;
		this.value = (this.value) % this.limit;
		
	}
	
}
