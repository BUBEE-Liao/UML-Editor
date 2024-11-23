package Shape;

import java.awt.Graphics;

public class UseCaseObj extends RectObject{
	
	public UseCaseObj(int x, int y) {
		this.obj_name = "Use Case";
		this.width=120;
		this.height=90;
		this.center_x = x;
		this.center_y = y;
		createPorts(width, height);
	}

	public void draw(Graphics g) {
		g.drawOval(center_x-width/2, center_y-height/2, width, height);
		g.setFont(font);
		int stringWidth = g.getFontMetrics(font).stringWidth(obj_name);
		int stringHeight = g.getFontMetrics(font).getHeight();
		g.setFont(font);	
		g.drawString(obj_name, center_x-stringWidth/2, center_y+stringHeight/2);
	}
}
