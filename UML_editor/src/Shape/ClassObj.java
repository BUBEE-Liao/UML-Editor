package Shape;

import java.awt.Graphics;

public class ClassObj extends RectObject{
	
	public ClassObj(int x, int y) {
		this.obj_name = "Class";
		this.center_x = x;
		this.center_y = y;
		this.width=120;
		this.height=90;
		createPorts(width, height);
	}
	
	public void draw(Graphics g) {
		
		g.drawRect(center_x-width/2, center_y-height/2, width, height);
		
		int portion = height / 3;
		g.drawLine(center_x-width/2, center_y-height/2 + portion, center_x+width/2, center_y-height/2 + portion);
		g.drawLine(center_x-width/2, center_y-height/2 + portion * 2, center_x+width/2, center_y-height/2 + portion * 2);
		int stringWidth = g.getFontMetrics(font).stringWidth(obj_name);
		int stringHeight = g.getFontMetrics(font).getHeight();
		g.setFont(font);
		g.drawString(obj_name, center_x-stringWidth/2, center_y+stringHeight/2);
	}

}
