package main;

import gui.components.Action;
import gui.components.Visible;

public interface Collided extends Visible {
	
	public boolean collided();
	public void setAction(Action action);
	public void act();
}
