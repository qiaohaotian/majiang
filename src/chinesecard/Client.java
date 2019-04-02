package chinesecard;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		if (args.length == 0) {
			return;
		}
		String serverName;
		serverName = args[0];
		int port = Integer.parseInt(args[1]);
		try {
			System.out.println("请输入“开始游戏”以开始游戏");
			String a = null;
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				a = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Socket client = new Socket(serverName, port);
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			Player player = new Player();
			if (a.equals("开始游戏")) {
				out.writeUTF("1:start");
			}
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			String inStr = in.readUTF();
			ArrayList<Card> handcard = Rules.transformArr(inStr);
			player.setHandhards(handcard);
			while (!Hule.hule(player.getHandhards())) {
				if (player.getHandhards().size() < 14) {
					out.writeInt(1);
					String ll = "";
					ll = in.readUTF();
					if (ll == "胡了") {
						player.setHandhards(Rules.transformArr(in.readUTF()));
						player.ShowCards();
						System.out.println("aaaa");
						break;
					} else {
						player.setHandhards(Rules.transformArr(ll));
						System.out.println("你的手牌：");
						player.ShowCards();
						int b = 0;
						System.out.println("请打一张牌");
						try {
							BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
							b = Integer.parseInt(reader.readLine());
						} catch (IOException e) {
							e.printStackTrace();
						}
						out.writeInt(b);
						player.setHandhards(Rules.transformArr(in.readUTF()));
						player.ShowCards();
					}

				}
			}
			System.out.println("恭喜");
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
