package gui;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public abstract class GUIApplication extends JFrame implements Runnable{

	//FIELDS
	private Screen currentScreen;
	
	
	//demo purposes only
//	public static void main(String[] args) {
//		new GUIApplication(800,600);
//	}
	
	public GUIApplication(int width, int height){
		super();
//		setUndecorated(true);
		setBounds(20, 20, width, height);
		//terminates program when window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initScreen();
		setVisible(true);
	}

	public abstract void initScreen(); 
		//method is not defined
		//currentScreen = new Screen(getWidth(),getHeight());
	
	public void paint(Graphics g){
		g.drawImage(currentScreen.getImage(), 0, 0, null);
	}
	
	public void setScreen(Screen s){
		//stop listening to previous screen
		if(currentScreen != null){
			MouseListener ml = currentScreen.getMouseListener();
			if(ml != null){
				removeMouseListener(ml);
			}
			MouseMotionListener mml = currentScreen.getMouseMotionListener();
			if(mml != null){
				removeMouseMotionListener(mml);
			}
			KeyListener kl = currentScreen.getKeyListener();
			if(kl != null){
				removeKeyListener(kl);
			}
		}
		currentScreen = s;
		if(currentScreen != null){
			addMouseListener(currentScreen.getMouseListener());
			addMouseMotionListener(currentScreen.getMouseMotionListener());
			addKeyListener(currentScreen.getKeyListener());
		}
	}
	
	public void run(){
		while(true){
			//redraws the display
			currentScreen.update();
			//updates the window
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//ABSTRACTIONS
//Interface has a description of methods 
//	- implements as many interfaces as you want
//Abstract class has descriptions of methods 
// 	- has methods(only useful to subclasses that inherit this class)
//	- mix between an interface and a class 
//	- only extends one class
//	- cannot be instantiated                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              


//declaration: int[] num;
//instantiation(initialize) num = new int[5];