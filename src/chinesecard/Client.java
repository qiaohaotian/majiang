package chinesecard;
import java.net.*;
import java.util.ArrayList;
import java.io.*;
 

public class Client {
	public static void main(String [] args)
	   {
		if(args.length == 0)
        {
            return;
        }
		  String serverName;
	      serverName = args[0];
	      int port = Integer.parseInt(args[1]);
	      try
	      {
	         System.out.println("请输入“开始游戏”以开始游戏");
	         String a = null;
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			          a = reader.readLine();
				}catch (IOException e) {
					e.printStackTrace();
				}
	         Socket client = new Socket(serverName, port);
	         DataOutputStream out = new DataOutputStream(client.getOutputStream());	 
	         if(a.equals("开始游戏")){
	        	 out.writeUTF(a);
	         }
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in = new DataInputStream(inFromServer);
	         String inStr = in.readUTF();
	         System.out.println(inStr);
	         ArrayList<Card> handcard = Rules.transformArr(inStr);
	         for(int i=0;i<handcard.size();i++){
				 System.out.print((i+1)+":"+handcard.get(i));
			 }
	         client.close();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	   }
}
