package main;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.TextArea;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class IntroScreen extends ClickableScreen implements MouseListener{
	
	
	private BufferedImage image;
	private Button button;
	private TextArea text;
	private Graphic background;
	
	
	public IntroScreen(int width, int height) {
		super(width, height);
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
		background = new Graphic(0, 0, 800, 800, "resources/background1.png");
		viewObjects.add(background);
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
	
//	public void update(){
//		Graphics2D g = image.createGraphics();
//		//smooth the graphics
//		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		drawBackground(g);
//		g.setColor(Color.black);
//	}
}
