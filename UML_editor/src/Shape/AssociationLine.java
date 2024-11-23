package Shape;

import java.awt.Graphics;

public class AssociationLine extends LineObj{
	
	public AssociationLine(Port start, Port end) {
		this.start = start;
		this.end = end;
	}
	
public void draw(Graphics g) {
		g.drawLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
	}

}
