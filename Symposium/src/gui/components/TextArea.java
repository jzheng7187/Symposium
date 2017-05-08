package gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TextArea extends TextLabel {

	public TextArea(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
		// TODO Auto-generated constructor stub
	}

	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font(getFont(), Font.PLAIN, getSize()));
		FontMetrics fm = g.getFontMetrics();
		if(getText()!= null){
			g.setColor(Color.black);
			String t = getText();
			String[] words = t.split(" ");
			if(words.length > 0){
				int i = 0;
				final int SPACING = 2;
				int y = 0 + fm.getHeight() + SPACING;
				String line = words[i] + " ";
				i++;
				while(i < words.length){
					while(i < words.length && fm.stringWidth(line) + fm.stringWidth(words[i]) < getWidth()){
						line += words[i] + " ";
						i++;
					}
					if(y < getHeight()){
						g.drawString(line, 2 , y);
						y += fm.getDescent() + fm.getHeight() + SPACING;
						line = "";
					}else{
						break; //print no more text
					}
				}
			}
		}
	}
}
