package badmintonbyOO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Cashier {
	Scissors scissors = new Scissors();
	Bill bill= new Bill();
	public boolean bookbill(String infoF,ArrayList<Bill> bills){
    	bill.book(infoF,bills);
    	return true;
    }
	public boolean cancelbill(String infoF,ArrayList<Bill> bills){
    	bill.cancel(infoF, bills);
    	return true;
    }
	public void show(ArrayList<Bill> bills){
		System.out.println("收入汇总：");
		System.out.println("A场地：");
		int a = 0;
		for(int i=0;i<bills.size();i++){
			if(Scissors.getcourtname(bills.get(i).getinfo()).equals("A")){
				System.out.println(Scissors.getdate(bills.get(i).getinfo())+" "+Scissors.gettime(bills.get(i).getinfo())+" "+bills.get(i).getState()+" "+bills.get(i).getmoney());
				a = a + bills.get(i).getmoney();
			}
		}
		System.out.println("小记："+ a);
		System.out.println();
		System.out.println("B场地：");
		int b = 0;
		for(int i=0;i<bills.size();i++){
			if(Scissors.getcourtname(bills.get(i).getinfo()).equals("B")){
				System.out.println(Scissors.getdate(bills.get(i).getinfo())+" "+Scissors.gettime(bills.get(i).getinfo())+" "+bills.get(i).getState()+" "+bills.get(i).getmoney());
				b = b + bills.get(i).getmoney();
			}
		}
		System.out.println("小记："+ b);
		System.out.println();
		System.out.println("C场地：");
		int c = 0;
		for(int i=0;i<bills.size();i++){
			if(Scissors.getcourtname(bills.get(i).getinfo()).equals("C")){
				System.out.println(Scissors.getdate(bills.get(i).getinfo())+" "+Scissors.gettime(bills.get(i).getinfo())+" "+bills.get(i).getState()+" "+bills.get(i).getmoney());
				c = c + bills.get(i).getmoney();
			}
		}
		System.out.println("小记："+ c);
		System.out.println();
		System.out.println("D场地：");
		int d = 0;
		for(int i=0;i<bills.size();i++){
			if(Scissors.getcourtname(bills.get(i).getinfo()).equals("D")){
				System.out.println(Scissors.getdate(bills.get(i).getinfo())+" "+Scissors.gettime(bills.get(i).getinfo())+" "+bills.get(i).getState()+" "+bills.get(i).getmoney());
				d = d + bills.get(i).getmoney();
			}
		}
		System.out.println("小记："+ d);
		System.out.println();
		int sum = a+b+c+d;
		System.out.println("总计："+sum);
	}
	
}
