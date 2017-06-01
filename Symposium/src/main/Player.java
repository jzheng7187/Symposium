package main;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

import gui.components.AnimatedComponent;

public class Player implements KeyListener{
	
	private static int hpoints = 100;
	private static boolean isAlive = true;
	private static Player player;
	private int x = 0;
	private int y = 0;
	private int deltaX = 5;
	private int deltaY = 20;
	private Image image;
	private ArrayList<Image> movement;
	
	public Player(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	
	public void hit(){
		//makes contact with enemy
//		if(){
//			hpoints -= (Math.random() * 5) + 1;
//			move(-15, 0);
//		}if(hpoints == 0){
//			isAlive = false;
//		}
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

	public static int getHpoints() {
		return hpoints;
	}

	public static void setHpoints(int hpoints) {
		Player.hpoints = hpoints;
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

	public static boolean isAlive() {
		return isAlive;
	}
	
	public static void setAlive(boolean isAlive) {
		Player.isAlive = isAlive;
	}
	
	public int getWidth(){
		return getWidth();
	}
	
	public int getHeight(){
		return getHeight();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return x;
	}
	
}
