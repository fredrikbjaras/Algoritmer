
public class Arc {
	
	private String a, b;
	private int capacity;
	private int flowAB;
	private int flowBA;
	
	public Arc(String a, String b, int capacity){
		this.a = a;
		this.b = b;
		this.capacity = capacity;
	}

}
