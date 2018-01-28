package chinesecard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Cards {
	 static String[] NUMBER1 = new String[]{"1","2","3","4","5","6","7","8","9"};
	 static String[] COLOR1 = new String[]{"条","饼","万"};
	 static String[] NUMBER2 = new String[]{"东","西","南","北"};
	 static String[] COLOR2 = new String[]{"风"};
	 static String[] COLOR3 = new String[]{"色"};
	 static String[] NUMBER3 = new String[]{"红","绿","白"};
	 public  ArrayList<Card> create(){
		    ArrayList<Card> cards= new ArrayList<Card>();
			addBaseCards(cards);
			addFJCards(cards);
			addCards(cards);
			addBaseCards(cards);
			addFJCards(cards);
			addCards(cards);
			addBaseCards(cards);
			addFJCards(cards);
			addCards(cards);
			addBaseCards(cards);
			addFJCards(cards);
			addCards(cards);
			return cards;
	 }

	private void addBaseCards(ArrayList<Card> cards) {

		for( int i=0;i<NUMBER1.length ;i++){
			 for(int j=0;j<COLOR1.length;j++){
				 Card card = new Card(NUMBER1[i],COLOR1[j],i);
				 cards.add(card);
			 }
		 }		
	}
	private void addFJCards(ArrayList<Card> cards){
		for(int i=0;i<NUMBER2.length;i++){
			Card card = new Card(NUMBER2[i],COLOR2[0],i);
			cards.add(card);
		}
	}
	
	private void addCards(ArrayList<Card> cards) {

		for( int i=0;i<NUMBER3.length ;i++){
				 Card card = new Card(NUMBER3[i],COLOR3[0],i);
				 cards.add(card);
			 }
		 		
	}
	//手牌
	public ArrayList<Card> firstDraw(ArrayList<Card> cards){
		ArrayList<Card> handcards= new ArrayList<Card>();
		int a = 136;
		for(int i=0;i<14;i++){
			int n = new Random().nextInt(a-i) ;
			handcards.add(cards.remove(n));
		}
		return handcards;
	}
	public ArrayList<Card> drawCard(ArrayList<Card> cards,ArrayList<Card> allcards){
		ArrayList<Card> handcards = new ArrayList<Card>();
		int n = new Random().nextInt(allcards.size());
		cards.add(allcards.remove(n));
		cards = Rules.sorthandcard(cards);
		return cards;
	}
	public Card playCard(ArrayList<Card> cards){
		int a=0;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        a = Integer.parseInt(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Card deleted = cards.remove(a-1);
		return deleted;
	}
	
	
	
}