package Shape;

import java.awt.Point;

import java.awt.Graphics;

import java.awt.Color;

public class Port extends Point{
	
	private int range = 3; // square size
	
	
	public Port(int x, int y) {
		super(x, y);
	}
	
	public void showPort(Graphics g) {
		int center_x = (int)this.getX();
		int center_y = (int)this.getY();
		
		int x_left = x-range;
		int y_left = y-range;
		
		Graphics g2 = g.create();
		
		g2.setColor(Color.RED);
		g2.fillRect(x_left, y_left, range*2, range*2);
	}
	
	public void resetLocation(int moveX, int moveY) {
		int x = (int)this.getX() + moveX;
		int y = (int)this.getY() + moveY;
		super.setLocation(x, y);
	}
}
