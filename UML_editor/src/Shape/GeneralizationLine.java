package Shape;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;

public class GeneralizationLine extends LineObj{
	
	public GeneralizationLine(Port start, Port end) {
		this.start = start;
		this.end = end;
	}
	
	public void draw(Graphics g) {
		
		Graphics g_l = g.create();
		int x1 = (int)start.getX();
		int y1 = (int)start.getY();
		int x2 = (int)end.getX();
		int y2 = (int)end.getY();
		g_l.drawLine(x1, y1, x2, y2);
		
		int dx =  x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - 10, xn = xm, ym = 10, yn = -10, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};
        
        Polygon polygon = new Polygon(xpoints, ypoints, xpoints.length);
        g_l.setColor(Color.WHITE);
        g_l.fillPolygon(polygon);
        g_l.setColor(Color.BLACK);
        g_l.drawPolygon(polygon);
	}

}
