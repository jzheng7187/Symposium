package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import gui.components.Action;
import gui.components.AnimatedComponent;

public class Enemy extends AnimatedComponent implements Action{

	private static double hpoints;
//	private static boolean isAlive;
	private int x = 800;
	private int deltaX = -15;
	private int y;
	private double vx;
	private double vy;
	private String imageLoc;	
	private boolean load;
	private Action action;
	private Image image;
	private ArrayList<Image> slimeFrames;
	private int currentFrame;
	private long startTime;
	private long frameStart;
	private long checkRate;
	private int w;
	private int h;
	
	
	public Enemy(int x, int y, int w, int h, double vx, double vy, String imageLocation) {
		super(x, y, w, h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.vx = vx;
		this.vy = vy;
		this.imageLoc = imageLocation;
		this.load = false;
		
		slimeFrames = new ArrayList<Image>();
		slimeFrames.add(image = new ImageIcon(imageLoc).getImage());
		slimeFrames.add(image = new ImageIcon("resources/Enemy/slime1.png").getImage());
		slimeFrames.add(image = new ImageIcon("resources/Enemy/slime2.png").getImage());
		slimeFrames.add(image = new ImageIcon("resources/Enemy/slime3.png").getImage());
		slimeFrames.add(image = new ImageIcon("resources/Enemy/slime4.png").getImage());
		slimeFrames.add(image = new ImageIcon("resources/Enemy/slime5.png").getImage());
		slimeFrames.add(image = new ImageIcon("resources/Enemy/slime6.png").getImage());
		slimeFrames.add(image = new ImageIcon("resources/Enemy/slime7.png").getImage());
		
		
		setX(x);
		setY(y);
		setVx(vx);
		setVy(vy);
		loadImage();
		
		startTime = System.currentTimeMillis();
		frameStart = System.currentTimeMillis();	
		checkRate = 500;
		
		this.play();
	}

	
	private void loadImage() {
		try {
			image = new ImageIcon(imageLoc).getImage();
			load = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void hit(){
//		if(//makes contact
//		){
//			hpoints--;
//		}if(hpoints == 0){
//			isAlive = false;
//		}
//	}
//	
//	public void dead(){
//		if(isAlive = false){
//			//image disappears
//		}
//	}
	
	public void move(){
//		while(isAlive){
//			actionPerformed(move);
//		}
	}

	public void update(Graphics2D g){
		if(load){
			if(getX() > 0){
				slimeFrames.remove(this);
				setRunning(false);
			} else{
				g.drawImage(slimeFrames.get(currentFrame), 0, 0, getWidth(), getHeight(), 0, 0, 
						slimeFrames.get(currentFrame).getWidth(null),
						slimeFrames.get(currentFrame).getHeight(null), null);
				setPosx(getPosx() + getVx());
				setPosy(getPosy() + getVy());
				super.setX((int) getPosx());
				super.setY((int) getPosy());
			}
		}
	}
	
	private void setPosy(double d) {
		// TODO Auto-generated method stub
		
	}


	private double getPosy() {
		// TODO Auto-generated method stub
		return 0;
	}


	private void setPosx(double d) {
		// TODO Auto-generated method stub
		
	}


	private int getPosx() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setAction(Action action){
		this.action = action;
	}


	@Override
	public void act() {
		action.act();
	}
	
	public void run(){
		setRunning(true);
		while(isRunning()){
			try {
				Thread.sleep(REFRESH_RATE);
				update();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
