package main;

public class Player {
	
	private static int hpoints;
	
	public static void main(String[] args){
		hpoints = 100;
	}
	
	public void hit(){
		if(//make contact
			){
			hpoints -= (Math.random() * 5) + 1;
		}
	} 
}
