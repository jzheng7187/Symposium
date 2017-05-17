package main;

public class Player implements ActionListener, KeyListener{
	
	private static int hpoints;
	private boolean isAlive;
	private int x = 0;
	private int y = 0
	private int deltaX = 2;
	private int deltaY = 10;
	Timer tm = new Timer(5,this);
	
	public static void main(String[] args){
		hpoints = 100;
		isAlive = true;
		player = new Player(//state positions
		);
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
			gameScreen.GameOver();
			//change screen to ending screen
		}
	}
	
	public void move(){
		if(//space bar is pressed
		){
			y = y + deltaY;
		}if(//left arrow key is pressed
		){
			x = x - deltaX;
		}if(//right arrow key is pressed
		){
			x = x + deltaX;
		}
	}
	
	
}
