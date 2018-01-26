package chinesecard;

public class Card {
	private String color;
	private String number;
	
	public Card(String number,String color){
		this.color = color;
		this.number = number;
	}
	public String getColor(){
		return color;
	}
	public String getNumber(){
		return number;
	}
	@Override
	public String toString(){
		return number +" "+color;
	}

}
