package badminton;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
public class Bill {
	private String name;
	private String num;
	private String date;
	private String time;
	private String state;
	private int money;
	public Bill(String name,String date,String time,String num,String state,int money){
		this.name = name;
		this.num = num;
		this.date = date;
		this.time = time;
		this.state  = state;
		this.money = money;
		}
	public String getName(){
		return name;
}
	public String getNum(){
		return num;
}
	public String getDate(){
		return date;
	}
	public String getTime(){
		return time;
	}
	public String getState(){
		return state;
	}
	public int getMoney(){
		return money;
	}
	Rule rule = new Rule();
	
}
