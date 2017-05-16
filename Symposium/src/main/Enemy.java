package main;

public class Enemy {

	private static int hpoints;
	private boolean isAlive;
	
	public static void main(String[] args) {
		hpoints = (Math.random() * 6) + 1;
		isAlive = true;
	}
	
	public void hit(){
		if(//makes contact
		){
			hpoints--;
		}if(hpoints == 0){
			isAlive = false;
		}
	}
	
	public void dead(){
		if(isAlive = false){
			//image disappears
		}
	}
	
	public void move(){
		while(isAlive){
			//move method
		}
	}
}
