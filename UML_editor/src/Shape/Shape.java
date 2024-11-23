package Shape;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Shape {
	
	protected int center_x, center_y;
	protected int width=0, height=10;
	
	protected boolean select=false;
	protected String obj_name = "";
	
	protected List<Shape> member = new ArrayList<Shape>();
	
	public int get_center_x() {return this.center_x;}
	public int get_center_y() {return this.center_y;}
	
	public int getWidth() {return this.width;}
	public int getHeight() {return this.height;}
	
	public void draw(Graphics g) {};
	
	public void show(Graphics g) {};
	
	public void initSelect() {this.select=false;}
	
	public boolean checkSelect() {return this.select;}
	
	public boolean judgeSelect(int x, int y) {return false;}
	
	public boolean InputPointInsideOrNot(int x, int y) {return false;}
	
	public Port getMinDisePort(int x, int y) {return null;}
	
	public boolean defineMultiSelected(int x1, int y1, int x2, int y2) {return false;}
	
	public void setNewName(String new_name) {this.obj_name = new_name;}
	
	public void resetLocation(int x, int y) {}
	
	public List<Shape> getGroupItem(){return null;}
	
	public void unGroup(){}
	
}
