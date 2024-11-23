package Shape;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import java.awt.Graphics;
import java.awt.Rectangle;

public class RectObject extends Shape{
	
	protected Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 14);
	protected List<Port> ports = new ArrayList<Port>();
		
	public void draw(Graphics g) {};
	
	public void createPorts(int width, int height) {
		int x_point[] = {center_x, center_x+width/2, center_x, center_x-width/2};
		int y_point[] = {center_y-height/2, center_y, center_y+height/2, center_y};
		ports.clear();
		for(int i=0; i<4; i++) {
			ports.add(new Port(x_point[i], y_point[i]));
		}
	}
	
	public void show(Graphics g) {
		if(this.select) {
			for(int i=0; i<ports.size(); i++) {
				ports.get(i).showPort(g);
			}
		}
	}
	
	public void resetLocation(int moveX, int moveY) {//objects all base on center
		this.center_x += moveX;
		this.center_y += moveY;
		for(int i = 0; i < ports.size(); i++) {
			ports.get(i).resetLocation(moveX, moveY);
		}
	}
	
	public boolean judgeSelect(int x, int y) {
		if(center_x-width/2<x && x<center_x+width/2 && center_y-height/2<y && y<center_y+height/2) {
			this.select = true;
			return true;
		}
		else {
			this.select = false;
			return false;
		} 
	}
	
	public boolean InputPointInsideOrNot(int x, int y) {
		if(center_x-width/2<x && x<center_x+width/2 && center_y-height/2<y && y<center_y+height/2) {
			return true;
		}
		else return false;
	}
	
	public Port getMinDisePort(int x, int y) {
		int dist = Integer.MAX_VALUE;
		Port return_port = null;
		for(int i = 0; i < ports.size(); i++) {
			int x_dist = (int) (ports.get(i).getX()- x);
			int y_dist = (int) (ports.get(i).getY()- y);
			int Distance_Result = (int) Math.sqrt(x_dist*x_dist + y_dist*y_dist);
			if (Distance_Result<dist) {
				dist = Distance_Result;
				return_port = ports.get(i);
			}
		}
		return return_port;
	}
	
	public boolean defineMultiSelected(int x1, int y1, int x2, int y2) {
		int x_max = Math.max(x1, x2);
		int x_min = Math.min(x1, x2);
		int y_max = Math.max(y1, y2);
		int y_min = Math.min(y1, y2);
		if(x_min<center_x-width/2 && center_x+width/2<x_max && y_min<center_y-height/2 && center_y+height/2<y_max) {
			this.select = true;
			return true;
		}
		else return false;
	}
	public int get_center_x() {
		return center_x;
	}
	public int get_center_y() {
		return center_y;
	}
	
}
