package badminton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Rule {
	public boolean judge(String[] info, ArrayList<Court> courts) {// 判断每一个预定
		boolean a = false;
		for (int i = 0; i < courts.size(); i++) {
			if (judgeorder(info, i, courts)) {
				a = true;
				break;
			}
		}
		return a;
	}

	public boolean judgeorder(String[] info, int x, ArrayList<Court> courts) {// 具体判断时间在不在
		boolean a = false;
		if (info[1].equals(courts.get(x).getDate())) {
			int starttime = Integer.parseInt(info[2].substring(0, 2));
			int endtime = Integer.parseInt(info[2].substring(6, 8));
			for (int i = starttime; i < endtime; i++) {
				if (i == (courts.get(x).getTime())) {
					if (info[3].equals(courts.get(x).getNum())) {
						if (courts.get(x).getState().equals("A")) {
							a = true;
							break;
						}
					}
				}
			}

		}
		return a;
	}

	public String getweek(String datetime) {// 获取周几
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

	public int billmoney(String[] info) {// 一个订单的总钱数
		int a = 0;
		int starttime = Integer.parseInt(info[2].substring(0, 2));
		int endtime = Integer.parseInt(info[2].substring(6, 8));
		for (int i = starttime; i < endtime; i++) {
			a = a + giveprice(info, i);
		}
		return a;
	}
	public int billmoneyc(String[] info) {// 一个订单的总钱数
		int a = 0;
		int starttime = Integer.parseInt(info[2].substring(0, 2));
		int endtime = Integer.parseInt(info[2].substring(6, 8));
		for (int i = starttime; i < endtime; i++) {
			a = a + 5*giveprice(info, i)/10;
		}
		return a;
	}

	public int giveprice(String[] info, int time) {// 计算每个小时的钱数
		String day = getweek(info[1]);
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

	public ArrayList<Bill> addbill(String[] info, ArrayList<Bill> bills) {// 添加账单

		Bill bill = new Bill(info[0], info[1], info[2], info[3], "A", billmoney(info));
		bills.add(bill);
		return bills;
	}
	public ArrayList<Bill> addbillc(String[] info, ArrayList<Bill> bills) {// 添加账单

		Bill bill = new Bill(info[0], info[1], info[2], info[3], "C", billmoneyc(info));
		bills.add(bill);
		return bills;
	}

	public boolean judgebills(String[] info, ArrayList<Bill> bills) {
		boolean a = false;
		for (int i = 0; i < bills.size(); i++) {
			if (judgebill(info, i, bills)) {
				a = true;
				break;
			}
		}
		return a;
	}

	public boolean judgebill(String[] info, int x, ArrayList<Bill> bills) {
		boolean a = false;
		if (info[1].equals(bills.get(x).getDate())) {
			if (info[2].equals(bills.get(x).getTime())) {
				if (info[3].equals(bills.get(x).getNum())) {
					if (bills.get(x).getState().equals("A")) {
						a = true;
						return a;
					}
				}
			}
		}
		return a;
	}

	public void show(ArrayList<Bill> bills) {
		System.out.println("总计");
		System.out.println("A:");
		for (int i = 0; i < bills.size(); i++) {
			if (bills.get(i).getNum().equals("A")) {
				System.out.println(bills.get(i).getName() + " " + bills.get(i).getDate() + " " + bills.get(i).getTime()
						+ " " + bills.get(i).getNum() + " " + bills.get(i).getMoney());
			}
		}
		System.out.println("B:");
		for (int i = 0; i < bills.size(); i++) {
			if (bills.get(i).getNum().equals("B")) {
				System.out.println(bills.get(i).getName() + " " + bills.get(i).getDate() + " " + bills.get(i).getTime()
						+ " " + bills.get(i).getNum() + " " + bills.get(i).getMoney());
			}
		}
		System.out.println("C:");
		for (int i = 0; i < bills.size(); i++) {
			if (bills.get(i).getNum().equals("C")) {
				System.out.println(bills.get(i).getName() + " " + bills.get(i).getDate() + " " + bills.get(i).getTime()
						+ " " + bills.get(i).getNum() + " " + bills.get(i).getMoney());
			}
		}
		System.out.println("D:");
		for (int i = 0; i < bills.size(); i++) {
			if (bills.get(i).getNum().equals("D")) {
				System.out.println(bills.get(i).getName() + " " + bills.get(i).getDate() + " " + bills.get(i).getTime()
						+ " " + bills.get(i).getNum() + " " + bills.get(i).getMoney());
			}
		}
	}
}
