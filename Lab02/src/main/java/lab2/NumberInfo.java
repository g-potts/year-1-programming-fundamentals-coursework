package lab2;

public class NumberInfo {
	private int limit;
	private int value;
	
	public NumberInfo(int limit) {
		super();
		this.limit = limit;
	}

	public int getValue() {
		return value;
	}

	/*public void setValue(int value) {
		this.value = value;
	}*/
	
	public void increment(){
		this.value++;
		this.value = (this.value) % this.limit;
	}
	
}
