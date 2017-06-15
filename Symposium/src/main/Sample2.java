package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Sample2 extends JPanel implements ActionListener{
	
	Timer t = new Timer(5, this);
	private int x = 550;
	private int y = 550;
	private double deltaX = 2;
	private double deltaY = 2;
	private Image s;

	public Sample2(){
		t.start();
	}
	
	public void PaintComponent(Graphics g){
		super.paintComponent(g);
		ImageIcon slime = new ImageIcon ("resources/Enemy/Slime.png");
		s = slime.getImage();
		Graphics2D gg = (Graphics2D) g;
		gg.drawImage(s, x, y, this);
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(x < 0 || x > 750){
			deltaX = -deltaX;
		}
		x += deltaX;
		repaint();
		
	}
}
	
