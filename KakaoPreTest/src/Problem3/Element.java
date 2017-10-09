package Problem3;

public class Element {
	
	String key;
	int time;
	
	public Element(String k, int time) {
		this.key = k;
		this.time = time;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public void setTime(int t) {
		this.time = t;
	}
}
