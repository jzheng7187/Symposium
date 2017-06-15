package main;

import java.io.IOException;
import javax.imageio.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Sam {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Maplestory Platformer");
		
		Sample2 s = new Sample2();
		Sample l = new Sample();
		Sample b = new Sample();
		
		f.add(s);
		f.add(l);
		f.add(b);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 800);
		
		JOptionPane.showMessageDialog(f,
				"Welcome to the game. This is called Maplestory Platformer.");
	}

}
