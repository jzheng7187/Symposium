package main;

import gui.GUIApplication;

public class Game extends GUIApplication {

	public static Game scr;
	
	public Game(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		IntroScreen ss = new IntroScreen(getWidth(),getHeight());
		setScreen(ss);
	}

	public static void main(String[] args) {
		scr = new Game(800, 700);
		Thread go = new Thread(scr);
		go.start();
	}
}
