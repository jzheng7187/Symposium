package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;

public class GameScreen extends Screen implements KeyListener {

	private int x = 15;
	private int y = 450;
	private int deltaX = 1;
	private int deltaY = 1;
	//private Sprite character;
	private TextLabel text;
	private Button healthBar;
	
	public GameScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(20, 150, 500, 40, "Some Text");
		viewObjects.add(text);
		healthBar = new Button(0, 0, 100, 20, "HP" + Player.getHP(), Color.RED, new Action() {

			@Override
			public void act() {

			}
		});

	}

	public KeyListener getKeyListener() {
		return this;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
			if(code == KeyEvent.VK_UP){
				move(0,deltaY);
			}else if(code == KeyEvent.VK_LEFT){
				move(-deltaX,0);
			}
			else if(code == KeyEvent.VK_RIGHT){
				move(deltaX,0);
		}
	}

	private void move(int i, int j) {
		x = i + x;
		y = j + y;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
//	public void HealthBar(){
//		//show healthbar
//	}
	
	@Override
	public void drawBackground(Graphics2D g){
		Color c = new Color(0,0,255);
		g.setColor(c);
		g.fillRect(0, 0, 800, 800);
	}
	
	public static void gameOver(){
		//changeScreen
	}

}
