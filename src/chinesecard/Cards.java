package chinesecard;

import java.util.ArrayList;

public class Cards {
	 static String[] NUMBER = new String[]{"1","2","3","4","5","6","7","8","9"};
	 static String[] COLOR = new String[]{"tiao","bing","wang"};
	 public  ArrayList<Card> create(){
		    ArrayList<Card> cards= new ArrayList<Card>();
			addBaseCards(cards);
			return cards;
	 }


	private void addBaseCards(ArrayList<Card> cards) {

		for( int i=0;i<NUMBER.length ;i++){
			 for(int j=0;j<COLOR.length;j++){
				 Card card = new Card(NUMBER[i],COLOR[j]);
				 cards.add(card);
			 }
		 }		
	}
}