package badmintonbyOO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Bill {
	private int money;
	private String info;
	private String state;

	public Bill(){
		this.info = null;
		this.money = 0;
		this.state = null;
	}
	public Bill(String info, int money, String state) {
		this.info = info;
		this.money = money;
		this.state = state;
	}

	public String getinfo() {
		return info;
	}

	public String getState() {
		return state;
	}
	public int getmoney(){
		return money;
	}
	public void book(String infoF, ArrayList<Bill> bills) {
		Cashier cashier = new Cashier();
		bills.add(new Bill(infoF, calculate(infoF), "预定"));
	}

	public void cancel(String infoF, ArrayList<Bill> bills) {
		Cashier cashier = new Cashier();
		for (int i = 0; i < bills.size(); i++) {
			if (judgebill(infoF,i, bills)) {
				bills.remove(i);
				bills.add(new Bill(infoF, 5*calculate(infoF)/10, "违约金"));
				break;
			}
		}
	}
	public boolean judgebill(String infoF, int x, ArrayList<Bill> bills) {
		String[] info = infoF.split("\\s+");
		if (info[1].equals(Scissors.getdate(bills.get(x).getinfo()))) {
			if (info[2].equals(Scissors.gettime(bills.get(x).getinfo()))) {
				if (info[3].equals(Scissors.getcourtname(bills.get(x).getinfo()))) {
					if (bills.get(x).getState().equals("预定")) {
						return true;
					}else{
						return false;
					}
				}
			}
		}
		return false;
	}

	private int calculate(String infoF) {
		int a = 0;
		int starttime = Scissors.getstarttime(infoF);
		int endtime = Scissors.getendtime(infoF);
		for (int i = starttime; i < endtime; i++) {
			a = a + moneyperhour(infoF, i);
		}
		return a;
	}

	private int moneyperhour(String infoF, int time) {
		String day = getweek(Scissors.getdate(infoF));
		int a = 0;
		if (day.equals("星期六") || day.equals("星期日")) {
			switch (time) {
			case 9:
			case 10:
			case 11:
				a = 40;
				break;
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
				a = 50;
				break;
			case 18:
			case 19:
			case 20:
			case 21:
				a = 60;
				break;
			}
		} else {
			if (8 < time && time < 12) {
				a = 30;
			} else if (11 < time && time < 18) {
				a = 50;
			} else if (17 < time && time < 20) {
				a = 80;
			} else {
				a = 60;
			}

		}
		return a;
	}

	private String getweek(String datetime) {// 获取周几
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		java.util.Date datet = null;
		try {
			datet = f.parse(datetime);
			cal.setTime(datet);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK); // 指示一个星期中的某天。
		return weekDays[w];
	}

	

}
