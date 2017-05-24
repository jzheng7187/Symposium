package main;

import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class GameOver extends Screen{

	private TextLabel text;
	private TextLabel text1;

	public GameOver(int width, int height) {
		super(width,height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(350, 150, 500, 40, "Game Over");
		viewObjects.add(text);
		text1 = new TextLabel(350, 400, 500, 40, "You Lose");
		viewObjects.add(text1);
	}

}
