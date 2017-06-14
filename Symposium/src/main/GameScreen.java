package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.TextLabel;
import gui.components.Visible;

public class GameScreen extends Screen implements KeyListener, Runnable {

	private int deltaX; 
	private int deltaY;
	//private Sprite character;
	private TextLabel text;
	private Button healthBar;
	private ArrayList<Enemy> enemies;
	private Enemy enemy;
	private int score = 0;
	private Player player;
	private Enemy slime;
	private Graphic background;

	public GameScreen(int width, int height) {
		super(width, height);
		
		this.deltaX = 5;
		this.deltaY = 20;

	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		background = new Graphic(0, 0, 800, 650, "resources/Background/game_Back.png");
		viewObjects.add(background);
		
		text = new TextLabel(600, 635, 150, 50, "Score " + score);
		viewObjects.add(text);
		
		player = new Player(200, 370, 75, 75, "resources/Player/Luminous.png");
		
		healthBar = new Button(0,650, 400, 50, "HP " + player.getHpoints(), Color.RED, new Action() {
			
			@Override
			public void act() {
				
			}
		});
		viewObjects.add(healthBar);
		
		player.play();
		viewObjects.add(player);
		
		slime = new Enemy(200, 30, 75, 75, -5, 0, "resources/Enemy/slime.png");
		viewObjects.add(slime);
	}

	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP){
			player.move(0, deltaY);
		}else if(code == KeyEvent.VK_LEFT){
			player.move(-deltaX,0);
		}
		else if(code == KeyEvent.VK_RIGHT){
			player.move(deltaX,0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void newEnemy(){
//		double chance = ((enemies.size() > 0) ? Math.log((double) score) : 1000);
//		double rand = ((Math.random()) * 1000) - (score/ 1000);
//		if(rand < chance){
//			enemy  = new Enemy(800, 650, 50, 50, -5, 0, "resources/Enemy/slime1.png");
//			enemy.setAction(new Action(){
//				@Override
//				public void act() {
//					if(player.isAlive()){
//						
//					}
//				}
//			});
//			enemies.add(enemy);
//			addObject(enemy);
//		}
	}

	private void score(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		score += 1;
	}


	public static void gameOver(){
	}

	@Override
	public void run() {
		enemies = (ArrayList<Enemy>) Collections.synchronizedList(new ArrayList<Enemy>());
		while(player.getHpoints() > 0){
			score();
			newEnemy();
		}
		gameOver();
	}


	public int getScore(){
		return this.score;
	}
}
