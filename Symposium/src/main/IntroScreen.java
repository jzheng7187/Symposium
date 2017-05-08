package main;

import gui.GUIApplication;

public class IntroScreen extends GUIApplication {

	public static IntroScreen scr;
	
	public IntroScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		GameScreen ss = new GameScreen(getWidth(),getHeight());
		setScreen(ss);
	}

	public static void main(String[] args) {
		scr = new IntroScreen(800, 700);
		Thread go = new Thread(scr);
		go.start();
	}
}
