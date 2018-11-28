package badmintonbyOO;

public class Reservition {
	private String user;
	private String courtName;
	private String date;
	private int startime;
	private int endtime;
	public Reservition(String user, String date, int starttime, int endtime,String courtName){
		this.user = user;
		this.date = date;
		this.courtName = courtName;
		this.startime = starttime;
		this.endtime = endtime;
	}
	
	public static Reservition parse(String info){
		if(!checkFormat())
			return null;
		String[] message=info.split("\\s+");
		String date = message[1];
		return new Reservition(message[0],message[1],Integer.parseInt(message[2].substring(0, 2)),Integer.parseInt(message[2].substring(6, 8)),message[3]);
	}
	private static boolean checkFormat(){
		return false;
	}
}
