package badminton;

import java.util.ArrayList;

import badminton.Court;;

public class Book {
	Rule rule = new Rule();
	public  ArrayList<Court> bookc(String[] info,ArrayList<Court> courts,ArrayList<Bill> bills){
		if(rule.judge(info,courts)){
			System.out.println("已预订，请重新选择");
		}else{
			int starttime = Integer.parseInt(info[2].substring(0, 2));
			int endtime = Integer.parseInt(info[2].substring(6, 8));
			for(int i =starttime;i<endtime;i++){
				Court court = new Court(info[0],info[1],i,info[3],"A");
				courts.add(court);
			}
			
		}
		return courts;
	}
	
}
