package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import gui.components.Action;
import gui.components.AnimatedComponent;

public class Enemy extends AnimatedComponent implements ActionListener{

	private static double hpoints;
//	private static boolean isAlive;
	private int x = 800;
	private int deltaX = -15;
	Timer tm = new Timer(5,this);
	private ActionEvent move;
	private int y;
	private double vx;
	private double vy;
	private String imageLoc;	
	private boolean load;
	private Action action;
	private Image image;
	
	
	public Enemy(int x, int y, int w, int h, double vx, double vy, String imageLocation) {
		super(x, y, w, h);
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.imageLoc = imageLocation;
		this.load = false;
		setX(x);
		setY(y);
		setVx(vx);
		setVy(vy);
		loadImage();
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


	public static void main(String[] args) {
		hpoints = (Math.random() * 6) + 1;
		//isAlive = true;
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
		while(isAlive){
			actionPerformed(move);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x = x + deltaX;
	}

	public void update(Graphics2D g){
		
	}
	
	public void action(){
		action.act();
	}
	
	public void setAction(Action action){
		this.action = action;
	}
}
