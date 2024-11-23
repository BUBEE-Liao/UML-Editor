package Shape;

import java.awt.Graphics;
import java.awt.Color;

public class Square extends Shape{
	
	private Port start;
	private Port end;

	public void setStart(Port start) {
		this.start = start;
	}
	
	public void setEnd(Port end) {
		this.end = end;
	}
	
	public void Relocation(Port p) {
		this.end.setLocation(p.getX(), p.getY());
	}
	
	public void draw(Graphics g) {
		int x1=start.x; 
		int y1=start.y;
		int x2=end.x;
		int y2=end.y;
		Graphics g_square = g.create();
		
		g_square.setColor(Color.BLUE);
		g_square.drawLine(x1, y1, x2, y1);
		g_square.drawLine(x2, y1, x2, y2);
		g_square.drawLine(x2, y2, x1, y2);
		g_square.drawLine(x1, y2, x1, y1);
	}
}
