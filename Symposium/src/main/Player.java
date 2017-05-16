package main;

public class Player {
	
	private static int hpoints;
	private boolean isAlive;
	
	public static void main(String[] args){
		hpoints = 100;
		isAlive = true;
	}
	
	public void hit(){
		if(//make contact
			){
			hpoints -= (Math.random() * 5) + 1;
		}if(hpoints == 0){
			isAlive = false;
		}
	} 
	
	public void death(){
		if(isAlive == false){
			game.GameOver();
			//change screen to ending screen
		}
	}
}
