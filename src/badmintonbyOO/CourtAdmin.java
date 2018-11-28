package badmintonbyOO;

import java.util.HashMap;

public class CourtAdmin {
	private HashMap<String, Court> allcourt= new HashMap<String, Court>();
	public CourtAdmin(){
		allcourt.put("A", new Court("A"));
		allcourt.put("B", new Court("B"));
		allcourt.put("C", new Court("C"));
		allcourt.put("D", new Court("D"));
	}
    public boolean booking(String courtName, String date, int starttime, int endtime){
    	Court court = allcourt.get(courtName);
    	boolean result = court.book(date,starttime, endtime);
    	return result;
    }
    public boolean canceling(String courtName, String date, int starttime, int endtime){
    	Court court = allcourt.get(courtName);
    	boolean result = court.cancel(date, starttime, endtime);
    	return result;
    }
}
