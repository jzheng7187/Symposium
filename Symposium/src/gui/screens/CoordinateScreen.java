package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.ClickableGraphic;
import gui.components.Graphic;
import gui.components.MovingComponent;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.MouseCoordinateGame;

public class CoordinateScreen extends Screen implements MouseMotionListener, MouseListener{

	private Button button;
	private TextLabel text;
	private TextArea area;
	private ClickableGraphic luminous;

	public CoordinateScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		button = new Button(20, 100, 80, 40, "Button", new Color(100,100,250), new Action() {
			
			@Override
			public void act() {
				MouseCoordinateGame.game.setScreen(MouseCoordinateGame.myScreen);
			}
		});
		viewObjects.add(button);
		text = new TextLabel(20, 150, 500, 40, "Some Text");
		viewObjects.add(text);
		area = new TextArea(20, 200, 500, 1000, "This is really long text. It prints over multiple lines, as you can see"
				+ " we worked on this in class. This is called Text Area.");
		viewObjects.add(area);
		
//		luminous  = new ClickableGraphic(500, 30, "resources/sampleImages/Luminous.png", new Action(){
//			@Override
//			public void act(){
//				MouseCoordinateGame.game.setScreen(MouseCoordinateGame.myScreen);
//			}
//		});
		viewObjects.add(luminous);
		
		MovingComponent c = new MovingComponent(20, 20, 100, 100);
		viewObjects.add(c);
		c.setVy(2);
		c.setVx(1);
		c.play();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();//get X coordinate
		int my = e.getY();//get Y coordinate
		text.setText("Mouse at (" + mx + "," + my + ")");
	}

	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

	@Override
	public MouseListener getMouseListener(){
		return this;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(button.isHovered(e.getX(), e.getY())){
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
	
}
