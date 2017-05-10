package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.TextArea;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class IntroScreen extends ClickableScreen implements MouseListener{
	
	private Button button;
	private TextArea text;
	
	
	public IntroScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void drawBackground(Graphics2D g){
		Color c = new Color(0,0,255);
		g.setColor(c);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(button.isHovered(e.getX(),e.getY())){
			button.act();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		button = new Button(225, 375, 350, 200, "Button", new Color(100,100,250), new Action() {
			
			@Override
			public void act() {
				Game.scr.setScreen(Game.GameScreen);
			}
		});
			viewObjects.add(button);
			text = new TextArea(200, 150, 500, 100, "Welcome to Maplestory Platformer!");
			viewObjects.add(text);
		
	}
	
}
