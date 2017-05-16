package main;

public class Enemy implements ActionListener{

	private static int hpoints;
	private boolean isAlive;
	private int x = 800;
	private int deltaX = -15;
	Timer tm = new Timer(5,this);
	
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
	
	public void ActionPerformed(ActionEvent e){
		x = x + deltaX;
	}
}
