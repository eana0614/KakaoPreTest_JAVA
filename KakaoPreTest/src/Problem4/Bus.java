package Problem4;

public class Bus {

	private int peopleMax;
	private int onTheBusPeople;
	private String time;
	
	public Bus(int pm, String time) {
		this.peopleMax = pm;
		this.onTheBusPeople = 0;
		this.time = time;
	}
	
	public int getOnTheBusPeople() {
		return this.onTheBusPeople;
	}
	
	public String getTime() {
		return this.time;
	}
}
