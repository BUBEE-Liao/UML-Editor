package Shape;

import java.awt.Graphics;

public class CompositionLine extends LineObj{
	
	private int diamondW = 7;
	private int diamondH = 7;
	
	public CompositionLine(Port start, Port end) {
		this.start = start;
		this.end = end;
	}
	
	public void draw(Graphics g) {
		
		g.drawLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
		int x1 = (int)start.getX();
		int y1 = (int)start.getY();
		int x2 = (int)end.getX();
		int y2 = (int)end.getY();
		
		int dx = x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - diamondW, xn = xm, ym = diamondH, yn = -diamondH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;
        
        double xq = (diamondH*2/D)*x1 + ((D-diamondH*2)/D)*x2;
        double yq = (diamondH*2/D)*y1 + ((D-diamondH*2)/D)*y2;
   
        int[] xpoints = {x2, (int) xm, (int) xq, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yq, (int) yn};

        g.fillPolygon(xpoints, ypoints, 4);
	}
	
	

}
