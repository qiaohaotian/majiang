package chinesecard;

import java.util.ArrayList;
public class Game {
	public static void main(String[] args){
        Cards mycard = new Cards();
		ArrayList<Card> mycards=mycard.create();
		 for(int i=0;i<mycards.size();i++){
			 System.out.println(mycards.get(i));
		 }
	}
}
