package main;

import java.io.IOException;
import javax.imageio.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game2 {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Maplestory Platformer");	
		
		GamezS l = new GamezS();
		GamezS b = new GamezS();
		
		f.add(l);
		f.add(b);
		
		f.setVisible(true);
		JOptionPane.showMessageDialog(f, "Welcome to the game. This is called Maplestory Platformer.");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 800);
		
	}

}
