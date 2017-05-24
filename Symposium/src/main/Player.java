package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Player implements KeyListener{
	
	private static int hpoints;
	private static boolean isAlive;
	private static Player player;
	private int x = 0;
	private int y = 0;
	private int deltaX = 5;
	private int deltaY = 20;
	
	public Player(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public static void main(String[] args){
		hpoints = 100;
		isAlive = true;
		player = new Player(500, 15);
	}
	
	public void hit(){
		//makes contact with enemy
		if(){
			hpoints -= (Math.random() * 5) + 1;
			move(-15, 0);
		}if(hpoints == 0){
			isAlive = false;
		}
	} 
	
	public void death(){
		if(isAlive == false){
			GameScreen.gameOver();
			//change screen to ending screen
		}
	}
	
	public void move(int i, int j){
		x = x + i;
		y = y + j;
	}
	
	public static int getHP(){
		return hpoints;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_SPACE){
			move(0,deltaY);
		}if(code == KeyEvent.VK_LEFT){
			move(-deltaX,0);
		}if(code == KeyEvent.VK_RIGHT){
			move(deltaX,0);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
