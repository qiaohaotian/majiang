package chinesecard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Player {
	private ArrayList<Card> mycards;

	public  ArrayList<Card> getHandhards() {
		return mycards;
	}

	public void setHandhards(ArrayList<Card> handcards) {
		mycards = handcards;
		Rules.sorthandcard(mycards);
	}
	public ArrayList<Card> drawCard(Card card){
		
		mycards.add(card);
		mycards = Rules.sorthandcard(mycards);
		return mycards;
	}
	public void ShowCards(){
		for(int i=0;i<mycards.size();i++){
			 System.out.print((i+1)+":"+mycards.get(i));
		 }
		System.out.println(" ");
	}
	public Card playCard(int a){
		Card deleted = mycards.remove(a-1);
		return deleted;
	}
}
