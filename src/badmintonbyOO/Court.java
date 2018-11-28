package badmintonbyOO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Court {
	private String courtName;
	private HashMap<String, int[]> records = new HashMap<String, int[]>();

	public Court(String courtName) {
		this.courtName = courtName;
	}

	public boolean book(String date, int starttime, int endtime) {
		int start = starttime - 9;
		int end = endtime - 9;
		if (records.containsKey(date)) {
			int[] record = records.get(date);
			for (int i = start; i < end; i++) {
				if (record[i] == 1) {
					return false;
				}
			}
			for (int i = start; i < end; i++) {
				record[i] = 1;
			}
			return true;
		}
		int[] newrecords = new int[13];
		for (int i = start; i < end; i++) {
			newrecords[i] = 1;
		}
		records.put(date, newrecords);
		return true;
	}

	public boolean cancel(String date, int starttime, int endtime) {
		int start = starttime - 9;
		int end = endtime - 9;
		if (records.containsKey(date)) {
			int[] record = records.get(date);
			for (int i = start; i < end; i++) {
				if (record[i] == 0) {
					return false;
				}
			}
			for (int i = start; i < end; i++) {
				record[i] = 0;
			}
			return true;
		}
		return false;
	}

}
