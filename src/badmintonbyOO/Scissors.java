package badmintonbyOO;

public class Scissors {
	public static String getdate(String infoF){
		String[] message=infoF.split("\\s+");
		String date = message[1];
		return date;
	}
	public static int getstarttime(String infoF){
		String[] message=infoF.split("\\s+");
		int starttime = Integer.parseInt(message[2].substring(0, 2));
		return starttime;
	}
	public static int getendtime(String infoF){
		String[] message=infoF.split("\\s+");
		int endtime = Integer.parseInt(message[2].substring(6, 8));
		return endtime;
	}
	public  static String getcourtname(String infoF){
		String[] message=infoF.split("\\s+");
		String courtname = message[3];
		return courtname;
	}
	public static String getname(String infoF){
		String[] message=infoF.split("\\s+");
		String name = message[0];
		return name;
	}
	public static String gettime(String infoF){
		String[] message=infoF.split("\\s+");
		String time = message[2];
		return time;
	}
}
