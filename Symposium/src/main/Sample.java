package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Sample extends JPanel implements ActionListener, KeyListener{

	Timer t = new Timer(5, this);
	int x = 850;
	int y = 680;
	private double deltaX = 2;
	private double deltaY = 2;
	double deltaX1 = 0;
	double deltaY1 = 2;
	private Image l;
	private int x1 = 0;
	private int y1 = 650;
	private Image b;
	private Image s;
	private int score;
	private int hpoints = 100;
	
	public Sample(){
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D gg = (Graphics2D) g;
		ImageIcon player = new ImageIcon("resources/Player/luminous1.png");
		l = player.getImage();
		
		ImageIcon back = new ImageIcon("resources/Background/game_Back.png");
		b = back.getImage();
		
		ImageIcon slime = new ImageIcon ("resources/Enemy/Slime.png");
		s = slime.getImage();
		
		gg.drawImage(b,0,0,1000,800,this);
		gg.drawImage(l, x1, y1, this);
		gg.drawImage(s, x, y, 100, 50, this);
		
		gg.draw(new Rectangle2D.Double(100, 100,200,100));
		gg.setColor(Color.GREEN);
		gg.fillRect(700, 100, 200, 100);
		gg.setFont(new Font("Courier New", Font.PLAIN, 25));
		gg.setColor(Color.BLACK);
		gg.drawString("Score: " + score ,725, 150);
		
		gg.setColor(Color.RED);
		gg.draw(new Rectangle2D.Double(100, 100,200,100));
		gg.fillRect(100, 100, 200, 100);
		gg.setColor(Color.BLACK);
		gg.setFont(new Font("Courier New", Font.PLAIN, 25));
		gg.drawString("Health: " + hpoints , 125 , 160);
		
		if(deltaX > 0){
			ImageIcon player1 = new ImageIcon("resources/Player/luminous1.png");
			l = player1.getImage();
			gg.drawImage(l, x1, y1,this);
		}
		if(deltaX < 0){
			ImageIcon player1 = new ImageIcon("resources/Player/luminous.png");
			l = player1.getImage();
			gg.drawImage(l, x1, y1,this);
		}
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		x1 += deltaX1;
		y1 += -deltaY1;
		
		x += -deltaX;
		
		if(x1 < 0){
			deltaX1 = -deltaX1;
		}
		
		if(x1 > 950){
			deltaX1 = -deltaX1;
		}
		if(x < 0 || x > 950){
			x = 850;
			score++;
		}
		
		if(y1 < 500){
			deltaY1 = -deltaY1;
		}
		
		if(y1 > 651){
			deltaY1 = 0;
		}
		
		repaint();
		
	}

	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();	

		if (code == KeyEvent.VK_W){
			deltaY1 = 1; 
		}

		if (code == KeyEvent.VK_LEFT){
			deltaX1 = 1;
		}

		if (code == KeyEvent.VK_RIGHT){
			deltaX1 = 1;
		}
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		deltaX1 = 0;
		deltaY1 = 0;
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
