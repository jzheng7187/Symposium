package main;

import gui.GUIApplication;
import gui.Screen;

public class Game extends GUIApplication {

	public static Game scr;
	public static Screen IntroScreen;
	public static Screen GameScreen;
	public static Screen GameOverScreen;
	
	public Game(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		IntroScreen = new IntroScreen(getWidth(),getHeight());
		GameScreen = new GameScreen(getWidth(),getHeight());
		GameOverScreen = new GameOver(getWidth(),getHeight());
		setScreen(IntroScreen);
	}

	public static void main(String[] args) {
		scr = new Game(800, 700);
		Thread go = new Thread(scr);
		go.start();
	}
}
