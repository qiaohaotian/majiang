package chinesecard;

import java.util.ArrayList;
public class Game {
	public static void main(String[] args){
        Cards mycard = new Cards();
		ArrayList<Card> mycards=mycard.create();
		ArrayList<Card> handcards=mycard.firstDraw(mycards);
		System.out.println(mycards.size());
		for(int i=0;i<mycards.size();i++){
			 System.out.print(mycards.get(i));
		 }
		System.out.println(" ");
		handcards=Rules.sorthandcard(handcards);
		for(int i=0;i<handcards.size();i++){
			 System.out.print(handcards.get(i));
		 }
		
		for(int i=5;i>0;i--){
			 Card deleted = mycard.playCard(handcards);
			 //choupai
			 handcards = mycard.drawCard(handcards,mycards);
			 for(int a=0;a<handcards.size();a++){
				 System.out.print(handcards.get(a));
			 }
			 
		 }
	}
}
