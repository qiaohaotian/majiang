package chinesecard;
import java.net.*;
import java.io.*;
 
public class Server 
{
   private ServerSocket serverSocket;
   
   public Server(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(1000000000);
   }
   public void excute(){
	      while(true)
	      {
	         try
	         {
	        	Socket server = serverSocket.accept();
	            DataInputStream in = new DataInputStream(server.getInputStream());
	            String instr=in.readUTF();
	            if(instr.equals("开始游戏")){
	            	Card lastCard =null;
	            	Player player = new Player();
	            	CardSet cardSet = new CardSet();
	                cardSet.create();
	            	player.setHandhards(cardSet.firstDraw());
	            	player.ShowCards();           	
	            	DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            	String outStr= Rules.transformStr(player.getHandhards());
	            	out.writeUTF(outStr);
	            }
	            server.close();
	         }catch(IOException e)
	         {
	            e.printStackTrace();
	            break;
	         }
	      }

   }
   public static void main(String [] args)
   {
	   try {
		Server server = new Server(12345);
		server.excute();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
