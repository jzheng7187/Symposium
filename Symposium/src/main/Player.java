package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import gui.components.AnimatedComponent;

public class Player extends AnimatedComponent implements KeyListener{
	
	private int hpoints;
	private boolean isAlive = true;
	private int x;
	private int y;
	private int deltaX;
	private int deltaY;
	private Image image;
	private int w;
	private int h;
	private boolean load;
	private String imageSrc = "resources/Player/Luminous.png";
	private boolean jump;
	private Graphics2D global;
	private long startJump;
	private double initialV;
	private double grav;
	private boolean damaged;
	
	public Player(int x, int y, int w, int h, String imageLocation){
		super(x, y, w, h);
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.hpoints = 100;
		this.load = false;
		this.jump = false;
		
		this.initialV = 9;
		this.grav = 1.5;
		
		this.deltaX = 5;
		this.deltaY = 20;
	
		setX(x);
		setY(y);
		Thread gameover = new Thread(new Runnable() {

			@Override
			public void run() {
				while(isAlive()){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(getHpoints() <= 0){
						Game.scr.setScreen(Game.GameOverScreen);
					}

				}
			}
		}); 
		
		loadImage();
		play();
		gameover.start();
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
	
	public void update(Graphics2D g){
		if(load){
			global = g;
			if(jump){
				g.drawImage(image, 0, 0, getWidth(), getHeight(), 0,0,image.getWidth(null), image.getHeight(null), null);
				setPosy(getPosy() + getVy());
				super.setY((int)getPosy());
			}else{
				g.drawImage(image, 0, 0, getWidth(), getHeight(), 0,0,image.getWidth(null), image.getHeight(null), null);
			}
		}
	}
	
	
	public void death(){
		if(isAlive == false){
			Game.scr.setScreen(Game.GameOverScreen);
		}
	}
	
	public void move(int i, int j){
		x = x + 40;
		y = y + 0;
	}
	
	public void checkBehaviors(){
		if(jump){
			long current = System.currentTimeMillis();
			int difference = (int)(current - startJump);
			double newV = initialV - grav*(double)(difference/100);
			if(getY() > 372){
				setJump(false);
				setY(370);
			}
			else{
				super.setVy(-newV);
			}
		}
	}

	public void run(){
		setRunning(true);
		while(isRunning()){
			try {
				Thread.sleep(REFRESH_RATE);
				checkBehaviors();
				if(damaged){
					flicker(global);
				}
				else{
					update();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void flicker(Graphics2D g) {
		try {
			clear();
			Thread.sleep(500);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), 0,0,image.getWidth(null), image.getHeight(null), null);
			damaged = !damaged;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void play(){
		if(!isRunning()){
			Thread start = new Thread(this);
			start.start();
		}
	}
	
	public int getHpoints() {
		return hpoints;
	}

	public void setHpoints(int hpoints) {
		this.hpoints = hpoints;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_SPACE){
			move(0, deltaY);
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

	public boolean isAlive() {
		return isAlive;
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public boolean getJump() {
		return jump;
	}
	
	public void setJump(boolean b) {
		clear();
		jump = b;
		startJump = System.currentTimeMillis();
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
	
	public void setDamaged(boolean b) {
		this.damaged = b;
		
	}

}
