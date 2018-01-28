package chinesecard;

import java.util.ArrayList;
public class Game {
	public static void main(String[] args){
        Cards mycard = new Cards();
		ArrayList<Card> mycards=mycard.create();
		Player p1= new Player();
		ArrayList<Card> handcards=mycard.firstDraw(mycards);
		p1.setHandhards(handcards);
		Player p2= new Player();
		handcards=mycard.secondDraw(mycards);
		p2.setHandhards(handcards);
		
		

		p1.mycards=Rules.sorthandcard(p1.mycards);
		p2.mycards=Rules.sorthandcard(p2.mycards);
		System.out.println("p1玩家的牌");
		for(int i=0;i<p1.mycards.size();i++){
			 System.out.print(p1.mycards.get(i));
		 }
		System.out.println(" ");
		System.out.println("p2玩家的牌");
		for(int i=0;i<p2.mycards.size();i++){
			 System.out.print(p2.mycards.get(i));
		 }
		for(int i=5;i>0;i--){
			 System.out.println("p1玩家出牌");
			 Card deleted1 = p1.playCard(p1.mycards);
			 //choupai
			 p1.mycards = p1.drawCard(p1.mycards, mycards);
			 p1.setHandhards(p1.mycards);
			 for(int a=0;a<handcards.size();a++){
				 System.out.print(p1.mycards.get(a));
			 }
			 System.out.println("p2玩家出牌");
			 Card deleted2 = p2.playCard(p1.mycards);
			 //choupai
			 p2.mycards = p2.drawCard(p2.mycards, mycards);
			 p2.setHandhards(p2.mycards);
			 for(int a=0;a<handcards.size();a++){
				 System.out.print(p2.mycards.get(a));
			 }
		 }
	}
}
