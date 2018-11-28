package badminton;

import java.util.ArrayList;

public class Cancel {
	Rule rule = new Rule();
	public ArrayList<Court> cancel(String[] info,ArrayList<Court> courts,ArrayList<Bill> bills){
		if(rule.judge(info,courts)){
			for(int i=0;i<courts.size();i++){
				if(rule.judgeorder(info,i,courts)){
					courts.remove(i);
					break;
				}
			}
			if(rule.judgebills(info, bills)){
				for(int i=0;i<bills.size();i++){
					if(rule.judgebill(info, i, bills)){
						bills.remove(i);
						rule.addbillc(info, bills);
					}
				}
			}
			System.out.println("订单取消成功");
		}else{
			System.out.println("订单不存在");			
		}
		return courts;
	}
}
