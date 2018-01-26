package chinesecard;

import java.util.ArrayList;
public class Game {
	public static void main(String[] args){
		 final ArrayList<String> COLOR = new ArrayList<String>();
		 String[] NUMBER = new String[]{"1","2","3","4","5","6","7","8","9"};
		 COLOR.add("条");
		 COLOR.add("wan");
		 COLOR.add("bing");
		 ArrayList<Card> cards= new ArrayList<Card>();
		 
		 for( int i=0;i<NUMBER.length ;i++){
			 for(int j=0;j<COLOR.size();j++){
				 Card card = new Card(NUMBER[i],COLOR.get(j));
				 cards.add(card);
			 }
		 }
		 for(int i=0;i<cards.size();i++){
			 System.out.println(cards.get(i));
		 }
	}
}
