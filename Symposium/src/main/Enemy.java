package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Enemy implements ActionListener{

	private static double hpoints;
	private static boolean isAlive;
	private int x = 800;
	private int deltaX = -15;
	Timer tm = new Timer(5,this);
	private ActionEvent move;
	
	public static void main(String[] args) {
		hpoints = (Math.random() * 6) + 1;
		isAlive = true;
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

}
