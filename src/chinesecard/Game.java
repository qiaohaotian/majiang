package chinesecard;

import java.util.ArrayList;
public class Game {
	public static void main(String[] args){
        Cards mycard = new Cards();
		ArrayList<Card> mycards=mycard.create();
		ArrayList<Card> handcards=mycard.hands(mycards);
		Rules sorted= new Rules();
		handcards=sorted.sorthandcard(handcards);
		 for(int i=0;i<handcards.size();i++){
			 System.out.print(handcards.get(i));
		 }
	}
}
