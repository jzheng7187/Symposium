package main;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
	private int w;
	private int h;
	private ArrayList<Image> frames;
	private boolean load;
	private String imageSrc;
	private boolean jump;
	
	public Player(int x, int y, int w, int h, String imageLocation){
		super(x,y, w, h);
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.hpoints = 100;
		this.load = false;
		this.jump = false;
		
		frames = new ArrayList<Image>();
		setX(x);
		setY(y);
		
	}
	

	private void loadImage() {
		try{
			image = new ImageIcon(imageSrc).getImage();
			load = true;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void setX(int x) {
		this.x = x;
		
	}

	private void setY(int y) {
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
			Game.scr.setScreen(Game.GameOverScreen);
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
	
	public boolean isJump() {
		return jump;
	}
	
	public void setJump(boolean b) {
		clear();
		this.jump = b;
	}
	
	private void clear() {
		// TODO Auto-generated method stub
		
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
	
	public void update(){
		while(isAlive){
			
		}
	}
	
	public void setImgSrc(String src){
		this.imageSrc = src;
		loadImage();
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
		update();
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
		update();
	}
}
