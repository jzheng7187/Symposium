package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameScreen extends Screen implements KeyListener, Runnable, ActionListener {

	private double deltaX; 
	private double deltaY;
	//private Sprite character;
	private TextLabel text;
	private Button healthBar;
	private ArrayList<Enemy> enemies;
	private Enemy enemy;
	private int score = 0;
	public Player player;
	private Graphic slime;
	private Graphic background;
	
	Timer t = new Timer(5, this);
	private int x = 0;
	private int y = 0;
	private Graphics2D g;

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
		
		slime = new Graphic(700, 525, .5,"resources/Enemy/Slime.png", new Action(){
			
			public void act(){
				while(player.getHpoints() > 0){
					t.start();
					slime.setX((int)(x + deltaX));
					if(x > 0 || x < 800){
						deltaX = -deltaX;
					}
				}
			}
		});
		viewObjects.add(slime);
		
		player = new Player(10, 520, 75, 75, "resources/Player/Luminous.png");
		
		healthBar = new Button(0,650, 400, 50, "HP " + player.getHpoints(), Color.RED, new Action() {
			
			@Override
			public void act() {
				
			}
		});
		viewObjects.add(healthBar);
		
		viewObjects.add(player);
		player.play();
		
	}

	public KeyListener getKeyListener() {
		return this;
	}

//	@Override
//	public void keyPressed(KeyEvent e) {
//		if(e.getKeyCode() == KeyEvent.VK_UP){
//			player.move(0, -20);
//		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
//			player.move(-40,0);
//		}
//		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
//			player.move(40,0);
//		}
//	}

	@Override
	public void keyReleased(KeyEvent e) {
//		int code = e.getKeyCode();
//
//        if (code == KeyEvent.VK_UP){
//            deltaY = 0;
//        }
//        if (code == KeyEvent.VK_DOWN){
//            deltaY = 0;
//        }
//        if (code == KeyEvent.VK_LEFT){
//            deltaX = 0;
//        }
//        if (code == KeyEvent.VK_RIGHT){
//            deltaX = 0;
//        }

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
	
	@Override
	public void run() {
		enemies = (ArrayList<Enemy>) Collections.synchronizedList(new ArrayList<Enemy>());
		while(player.getHpoints() > 0){
			score();
			newEnemy();
		}
	}
	
	
	public int getScore(){
		return this.score;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        x += deltaX;
        y  += deltaY;

        if(x < 0 || x > 750){
			deltaX = -deltaX;
		}
        
        
        
    }

	public void up(){
        deltaY = -50;
        deltaX = 0;
    }

    public void down(){
    	deltaY = 50;
        deltaX = 0;
    }

    public void left(){
    	deltaX = -50;
    	deltaY = 0;
    }

    public void right(){
    	deltaX = 50;
    	deltaY = 0;
    }

    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP){
            player.up();
        }

        if (code == KeyEvent.VK_LEFT){
            player.left();
        }

        if (code == KeyEvent.VK_RIGHT){
            player.right();
        }
		
	}

		
}
