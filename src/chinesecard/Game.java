package chinesecard;
public class Game {
	private Card lastCard =null;
	private Player[] player = {new Player(),new Player(),new Player(),new Player()};
	
	public void run(){
        CardSet cardSet = new CardSet();
        cardSet.create();
        for(int i=0;i<4;i++){
    		player[i]= new Player();
    		player[i].setHandhards(cardSet.firstDraw());
        }
        int i=0;
        int j=0;
		while(!cardSet.empty()){
			System.out.println("p"+i+"玩家的牌");
			player[i].ShowCards();
			player[i].drawCard(cardSet.randomCard());			 
			lastCard = player[i].playCard();
			cardSet.gether(lastCard);
			player[i].ShowCards();
			
		}		
	}
	public static void main(String[] args){
		Game game= new Game();
		game.run();
	}
}
