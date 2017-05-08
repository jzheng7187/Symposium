package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

import gui.components.Visible;

//ABSTRACT CLASS CANNOT BE INSTANTIATED

public abstract class Screen {
	//declaration Array: int[] numbs (Primitive Type)
				//Array List: ArrayList<Integer> numbs
					//<Integer> is a wrapper class
	//instantiation Array: nums = new int[5];
				  //ArrayList: nums = new ArrayList<Integer>();
					//don't have to say how large it is
	//adding items Array: num[i] = 4;
						//overrides the value at said item
				 //ArrayList: nums.add(new Integer 5);
						//appends to List
						//increase the size of List
	//length/size Array: nums.length;
				//ArrayList: nums.size();
	

	private BufferedImage image;
	private ArrayList<Visible> viewObjects;
	
	
	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initObjects(viewObjects);
		initImage(width,height);
	}

	public abstract void initObjects(ArrayList<Visible> viewObjects);
	//ArrayList is a subclass of an abstract class
	//subclass of class called List
	
	
	public void initImage(int width, int height) {
		image = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
		update();
	}

	public BufferedImage getImage(){
		return image;
	}
	
	public int getWidth(){
		return image.getWidth();
	}
	
	public int getHeight(){
		return image.getHeight();
	}
	
	public void update() {
		Graphics2D g = image.createGraphics();
		//smooth the graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
		for(int i = 0; i < viewObjects.size(); i++){
			Visible v = viewObjects.get(i);
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
//		for(Visible v: viewObjects){
//			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
//		}
	}

	
	//represents ABILITY to listen to mouse
	//isn't actually doing something 
	public MouseMotionListener getMouseMotionListener(){
		return null;
	}
	
	
	public MouseListener getMouseListener(){
		return null;
	}
	
	public void addObject(Visible v){
		viewObjects.add(v);
	}
	
	public void remove(Visible v){
		/**
		 * Note: In this implementation, we have 
		 * a very simple command: remove(v)
		 * however, remove is sort of a big deal on the 
		 * AP exam. Here's why:
		 * 
		 * When an object is removed from a List, every 
		 * other objects AFTER that object is moved up in order.
		 * Therefore, all of their respective indices change. You
		 * MUST, MUST MUST be aware of this.
		 * 
		 * Here is a CLASSIC example:
		 * 
		 * The Following is WRONG
		 * -Suppose you have a List<Integer> with
		 * {4,8,7,1}
		 * and you want to remove all Integers greater than 5.
		 * You do this:
		 * for(int i = 0; i < list.size(); i++){
		 * 	if(list.get(i) > 5){
		 * 		list.remove(i);
		 *  }
		 * }
		 * You FAIL!!!
		 * 
		 * Why do you fail?
		 * i = 0, nothing changes
		 * i = 1, the "8" is removed
		 * now we have: {4,7,1}
		 * i = 2, nothing changes
		 * i = 3, exit the loop. 
		 * We have: {4,7,1}
		 * 
		 * These TWO ways are correct:
		 *  	For(int i = 0; i < list.size(); i++){
		 *  		while(list.get(i) > 5){
		 *  			list.remove(i);
		 *  		}
		 *  	}
		 *  
		 * 	for(int i = 0; i < list.size(); i++){
		 * 		if(list.get(i) > 5){
		 * 			list.remove(i);
		 * 			i--;
		 *  	}
		 * 	}
		 * 
		 * for the same reason, this doesn't even work
		 * (because the size can be changed)
		 * 	for(Integer i: list){
		 * 		if(i > 5){
		 * 			list.remove(i);
		 * 		}
		 * 	}
		 * 
		 * 
		 * ONE MORE NOTE:
		 * if you call list.remove(int), it will return the 
		 * object being removed at that index. So you could 
		 * do something like this
		 * System.out.println(list.remove(0).toString() + "was removed.");
		 */
		viewObjects.remove(v);
	}
	
	public void moveToBack(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			//the "back" is index 0
			viewObjects.add(0, v);
			//this moves everything else forward in the list
		}
	}
	
	public void moveToFront(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(v);
		}
	}
}
