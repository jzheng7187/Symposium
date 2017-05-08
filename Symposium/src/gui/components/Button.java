package gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends TextLabel implements Clickable{

	private Color color;
	private Action action;
	
	public Button(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text);
		this.action = action;
		this.color = color;
		update();
	}

	public Color getColor(){
		return color;
	}
	
	public void setColor(Color c){
		color = c;
		update();
	}
	
	@Override
	public void update(Graphics2D g){
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
		g.setFont(new Font(getFont(), Font.PLAIN, getSize()));
		FontMetrics fm = g.getFontMetrics();
		if(getText() != null){
			g.setColor(Color.white);
			String t = getText();
			int cutoff = t.length();
			while(cutoff > 0 && fm.stringWidth(t) > getWidth()){
				cutoff --;
				t = t.substring(0,cutoff); 
			}
			g.drawString(t, (getWidth()-fm.stringWidth(t))/2, (getHeight()+fm.getHeight()-fm.getDescent())/2);
//			g.drawString(getText(), 4, (getHeight()-5));
		}	
	}

	@Override
	public boolean isHovered(int x, int y) {
		return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}

	@Override
	public void act() {
		action.act();
	}

}
