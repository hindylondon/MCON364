package week3;

public class LinkedHashEntry {
	//fields
	String key;
	int value;
	LinkedHashEntry next;
	
	//constructor
	LinkedHashEntry(String key, int value){
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public String getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Key: " + key + ", Value: " + value;
	}

}
