package badminton;

public class Court {
	private String name;
	private String num;
	private String date;
	private int time;
	private String state;

	public Court(String name, String date, int time, String num, String state) {
		this.name = name;
		this.num = num;
		this.date = date;
		this.time = time;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public String getNum() {
		return num;
	}

	public String getDate() {
		return date;
	}

	public int getTime() {
		return time;
	}

	public String getState() {
		return state;
	}
}
