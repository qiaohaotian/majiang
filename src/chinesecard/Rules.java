package chinesecard;

import java.util.ArrayList;

public class Rules {
	public static ArrayList<Card> groupby(ArrayList<Card> handcards, String type){
		ArrayList<Card> sorted = new ArrayList<Card>();
		
		for(int i=0;i<handcards.size();i++){
			if(handcards.get(i).getColor().equals(type)){
				sorted.add(handcards.get(i));
			}
		}
		return sorted;
	}
	public static ArrayList<Card> sorthandcard(ArrayList<Card> handcards) {
		ArrayList<Card> sorted = new ArrayList<Card>();
		//分组
		ArrayList<Card> tiaosorted = groupby(handcards,"条");
		ArrayList<Card> bingsorted = groupby(handcards,"饼");		
		ArrayList<Card> wansorted = groupby(handcards,"万");
		ArrayList<Card> fengsorted = groupby(handcards,"风");
		ArrayList<Card> sesorted = groupby(handcards,"色");

		tiaosorted = sort(tiaosorted);
		bingsorted = sort(bingsorted);
		wansorted = sort(wansorted);
		fengsorted = sort(fengsorted);
		sesorted = sort(sesorted);
		sorted.addAll(tiaosorted);
		sorted.addAll(bingsorted);
		sorted.addAll(wansorted);
		sorted.addAll(fengsorted);
		sorted.addAll(sesorted);
		return sorted;
	}
	//排序方法
	private static ArrayList<Card> sort(ArrayList<Card> cards){
		//ArrayList<Card> handcard = sorthandcard(cards);

		Object[] unsorted = cards.toArray();
		Object temp;
		for(int i =0;i<unsorted.length;i++){
			for(int j=i+1;j<unsorted.length;j++){
				if(((Card)unsorted[i]).biggerthan((Card)unsorted[j])){
					temp = unsorted[i];
					unsorted[i]=unsorted[j];
					unsorted[j]=temp;
				}
			}
		}
		ArrayList<Card> sorted = new ArrayList<Card>();		
		for(int i=0;i<unsorted.length;i++){
			sorted.add((Card)unsorted[i]);
			
		}
		return sorted;
	}  
	
}
