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
	            	DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            	String outStr= Rules.transformStr(player.getHandhards());
	            	out.writeUTF(outStr);
	            	while(true){
	            		if(in.readInt()==1){
	            			player.drawCard(cardSet.randomCard());
	            			if(Hule.hule(player.getHandhards())){
	            				out.writeUTF("胡了");
	            				out.writeUTF(Rules.transformStr(player.getHandhards()));
	            				break;
	            			}else{
	            				out.writeUTF(Rules.transformStr(player.getHandhards()));	            				
	            				player.playCard(in.readInt());	            				
	            				cardSet.gether(lastCard);	            				
	            				out.writeUTF(Rules.transformStr(player.getHandhards()));
            			    }	            			
	            		}
	            	}
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
