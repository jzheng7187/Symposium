package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui.components.Visible;
import gui.screens.ClickableScreen;

public class IntroScreen extends ClickableScreen implements MouseListener{

	public IntroScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void drawBackground(Graphics2D g){
		Color c = new Color(0,255,0);
		g.setColor(c);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
	
}
