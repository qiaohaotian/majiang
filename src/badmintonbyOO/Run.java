package badmintonbyOO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Run {
	public static void main(String[] args) {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		CourtAdmin admin = new CourtAdmin();
		Cashier cashier = new Cashier();
		while (true) {
			System.out.println("请输入指令, 输入 quit，停止程序;输入 【space】，汇总");
			String infoF = null;
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				infoF = reader.readLine();

			} catch (IOException e) {
				e.printStackTrace();
			}
			if (true) {
				if (infoF.equals("quit")) {
					System.exit(0);
				} else if (infoF.equals(" ")) {
					cashier.show(bills);
				} else {
					String[] message = infoF.split("\\s+");
					if (message.length == 5) {
						if(admin.canceling(Scissors.getcourtname(infoF), Scissors.getdate(infoF),Scissors.getstarttime(infoF),Scissors.getendtime(infoF))){
							cashier.cancelbill(infoF, bills);
							System.out.println("取消成功");
						}else{
							System.out.println("订单不存在");
						}
					} else {
						if(admin.booking(Scissors.getcourtname(infoF), Scissors.getdate(infoF),Scissors.getstarttime(infoF),Scissors.getendtime(infoF))){
							cashier.bookbill(infoF, bills);
							System.out.println("预定成功");
						}else{
							System.out.println("订单已存在");
						}
					}
				}

			} else {
				System.out.println("输入错误");
			}

		}

	}
}
