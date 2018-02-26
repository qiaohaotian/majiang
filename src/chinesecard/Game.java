package chinesecard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
	private Card lastCard =null;
	private Player[] player = {new Player(),new Player(),new Player(),new Player()};
	
	public void run(){
        CardSet cardSet = new CardSet();
        cardSet.create();
        for(int i=0;i<2;i++){
    		player[i]= new Player();
    		player[i].setHandhards(cardSet.firstDraw());
        }
        int i=0;
		while(!cardSet.empty()){
			if(lastCard == null){
				nomalOrder(cardSet, i);
			}else{
				if(Rules.judgement(lastCard, player[i].getHandhards())){
					System.out.println("p"+i+"玩家的牌");
					player[i].ShowCards();
					System.out.println("是否吃牌，写要或者不要");
					String a = null;
					try {
						BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				          a = reader.readLine();
					}catch (IOException e) {
						e.printStackTrace();
					}
					if( a.equals("e")){
						System.out.println(lastCard);
						player[i].drawCard(lastCard);
						player[i].ShowCards();
						lastCard = player[i].playCard();
						cardSet.gether(lastCard);
						player[i].ShowCards();
						System.out.println(lastCard);
					}else{
						nomalOrder(cardSet,i);
					}
				}else{
					nomalOrder(cardSet,i);
				}
			}
			i = (i+1)%2;
		}		
	}
	private void nomalOrder(CardSet cardSet, int i) {
		System.out.println("p"+i+"玩家的牌是");
		player[i].drawCard(cardSet.randomCard());			 
		player[i].ShowCards();
		lastCard = player[i].playCard();
		cardSet.gether(lastCard);
		System.out.println("打出的是"+lastCard);
		player[i].ShowCards();
		System.out.println("*******************************");
	}
	public static void main(String[] args){
		Game game= new Game();
		game.run();
	}
}
