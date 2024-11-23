package Shape;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import View.Canvas;

import java.awt.Color;

public class GroupObj extends Shape{
	
	private List<Shape> member = new ArrayList<Shape>(); //list of group member
	private Rectangle bound = new Rectangle(); // boundary
	private Canvas canvas;
	
	public GroupObj(List<Shape> list) {
		this.canvas = Canvas.getInstance();
		for(int i=0; i<list.size(); i++) {
			member.add(list.get(i));
		}
		int lu_x = Integer.MAX_VALUE;
		int lu_y = Integer.MAX_VALUE;
		int rd_x = Integer.MIN_VALUE;
		int rd_y = Integer.MIN_VALUE;
		
		for(int i=0; i<member.size(); i++) {
			Shape shape = member.get(i);
			int half_width = shape.getWidth()/2;
			int half_height = shape.getHeight()/2;
			int x = shape.get_center_x();
			int y = shape.get_center_y();
			int x1 = x-half_width;
			int y1 = y-half_height;
			int x2 = x+half_width;
			int y2 = y+half_height;
			if(x1<lu_x) {lu_x = x1;}
			if(y1<lu_y) {lu_y = y1;}
			if(x2>rd_x) {rd_x = x2;}
			if(y2>rd_y) {rd_y = y2;}
		}
		
		bound.setBounds(lu_x, lu_y, rd_x-lu_x, rd_y-lu_y);
		this.width = rd_x - lu_x;
		this.height = rd_y - lu_y;
		this.center_x = (int)bound.getX()+width/2;
		this.center_y = (int)bound.getY()+height/2;
		this.select = true;
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < member.size(); i++) {
			Shape shape = member.get(i);
			shape.draw(g);
		}
	}
	
	public void resetBound(int moveX, int moveY) {
		int x = (int)bound.getX();
		int y = (int)bound.getY();
		x += moveX;
		y += moveY;
		bound.setLocation(x, y);
		this.center_x = (int)bound.getX()+width/2;
		this.center_y = (int)bound.getY()+height/2;
	}
	
	public void resetLocation(int moveX, int moveY) {
		for (int i = 0; i < member.size(); i++) {
			Shape shape = member.get(i);
			shape.resetLocation(moveX, moveY);
		}
		resetBound(moveX, moveY);
	}
	
	public boolean judgeSelect(int x, int y) {
		if(bound.x<x && x<bound.x+bound.width && bound.y<y && y<bound.y+bound.height) {
			this.select = true;
			return true;
		}
		else {
			this.select = false;
			return false;
		} 
	}
	
	public void show(Graphics g) {
		if(this.select) {
			Graphics g_g = g.create();
			g_g.setColor(Color.RED);
			g_g.drawRect((int)bound.getX(), (int)bound.getY(), (int)bound.getWidth(), (int)bound.getHeight());
			for(int i=0; i<member.size(); i++) {
				member.get(i).show(g);
			}
		}
	}
	
	public boolean defineMultiSelected(int x1, int y1, int x2, int y2) {
		//find the most left up and right down point
		int x_max = Math.max(x1, x2);
		int x_min = Math.min(x1, x2);
		int y_max = Math.max(y1, y2);
		int y_min = Math.min(y1, y2);
		if(x_min<(int)bound.getX() && (int)bound.getX()+width <x_max && y_min<(int)bound.getY() && (int)bound.getY()+height<y_max) {
			this.select = true;
			return true;
		}
		else return false;
	}
	
	public List<Shape> getGroupItem(){
		return this.member;
	}
	
	public void unGroup() {
		List group_item = this.getGroupItem();
		for(int j=0; j<group_item.size(); j++) {
//			((Shape) group_item.get(j)).initSelect();
			canvas.shapes.add((Shape)group_item.get(j));
		}
		group_item.clear();
		canvas.shapes.remove(this);
		canvas.repaint();
	}
}
