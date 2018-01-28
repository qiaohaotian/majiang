package chinesecard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Player {
	ArrayList<Card> mycards;

	public void setHandhards(ArrayList<Card> handcards) {
		mycards = handcards;
	}
	public ArrayList<Card> drawCard(ArrayList<Card> cards,ArrayList<Card> allcards){
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
