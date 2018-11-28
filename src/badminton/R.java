package badminton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import badminton.Book;
public class R {
	public static void main(String[] args){
		ArrayList<Court> courts = new ArrayList<Court>();
		ArrayList<Bill> bills = new ArrayList<Bill>();
		Book book = new Book();
		Rule rule = new Rule();
		Cancel cancel = new Cancel();
		Check check = new Check();
		while(true){
			System.out.println("请输入指令, 输入 quit，停止程序;输入 【space】，汇总");
			String a = null;
			try {
				  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		          a = reader.readLine();
		          
			}catch (IOException e) {
				e.printStackTrace();
			}
			if(check.check(a)){
				if( a.equals("quit")){
		        	  System.exit(0);
		          }else if(a.equals(" ")){
						rule.show(bills);
		          }else{
						String[] message=a.split("\\s+");
						//String starttime = message[2].substring(0, 2);
						//String endtime = message[2].substring(6, 9);
						//System.out.println(starttime+endtime);
						if(message.length == 5){
							courts = cancel.cancel(message,courts,bills);
						}else{
							courts = book.bookc(message,courts,bills);
							bills = rule.addbill(message, bills);
						} 
		          }
			
			}else {
				System.out.println("输入错误");
			}
		}
	}
	
}
