package qht;

import static org.junit.Assert.*;

import org.junit.Test;

import chinesecard.Card;
import chinesecard.Hule;
import chinesecard.Rules;

import java.util.ArrayList;
public class HuleTest {

	public void print(ArrayList<Card> mycards){
		for(int i=0;i<mycards.size();i++){
			 System.out.print((i+1)+":"+mycards.get(i));
		}
	}

	@Test
	public void testIsPinghu() {
			ArrayList<Card> handcards = new ArrayList<Card>();
			for(int i=1;i<10;i++){
				handcards.add(new Card(String.format("%d",i),"条",i));			
			}
			handcards.add(new Card("1","条",1));
			handcards.add(new Card("1","条",1));
			handcards.add(new Card("9","条",9));
			handcards.add(new Card("9","条",9));
			handcards.add(new Card(String.format("%d", 1),"条",1));
			assertTrue(Hule.hule(handcards));
	}
	public void testTakeShuizi() {
			ArrayList<Card> handcards = new ArrayList<Card>();
			for(int i=1;i<10;i++){
				handcards.add(new Card(String.format("%d",i),"条",i));			
			}
			Hule.takeShunzi(handcards);
	}

}
