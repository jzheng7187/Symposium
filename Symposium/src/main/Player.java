package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import gui.components.AnimatedComponent;

public class Player extends AnimatedComponent implements KeyListener{
	
	private int hpoints = 100;
	private boolean isAlive = true;
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
		super(x, y, w, h);
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.hpoints = 100;
		this.load = false;
		this.jump = false;
		
		addFrame(new BufferedImage(new ImageIcon("resources/Player/Luminous.png")), 500);
	
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
			if(jump){
				g.drawImage(image, 0, 0, getWidth(), getHeight(), 0,0,image.getWidth(null), image.getHeight(null), null);
				setPosy(getPosy() + getVy());
				super.setY((int)getPosy());
			}
		}
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

	public boolean isAlive() {
		return isAlive;
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public boolean isJump() {
		return jump;
	}
	
	public void setJump(boolean b) {
		clear();
		this.jump = b;
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
