package Controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Shape.Port;
import Shape.RectObject;
import Shape.Shape;
import Shape.Square;

public class SelectMode extends Mode{
	
	private Point prevPT; // initial condition
	private Port press_square_start; //for temp select square
	private Port press_square_end; //for temp select square
	private Square sq=new Square(); //for temp select square
	
	public void mousePressed(MouseEvent e) {
		prevPT = e.getPoint();
		
		if(canvas.selectedShapes.size()==0) { // create select square
			press_square_start = new Port(e.getX(), e.getY());
			press_square_end = new Port(e.getX(), e.getY());
			sq.setStart(press_square_start);
			sq.setEnd(press_square_end);
			canvas.temp.add(sq);
		}
	}
	public void mouseReleased(MouseEvent e) {
		canvas.temp.clear();
		canvas.repaint();
		
		for(int i=0; i<canvas.shapes.size(); i++) {
			Shape obj = canvas.shapes.get(i);
			if(press_square_start!=null && obj.defineMultiSelected((int)press_square_start.getX(), (int)press_square_start.getY(), (int)press_square_end.getX(), (int)press_square_end.getY())) 
			{
				canvas.selectedShapes.add(obj);
			}
		}
		canvas.repaint();
	}
	public void mouseDragged(MouseEvent e) {
		int moveX = e.getX() - prevPT.x;
		int moveY = e.getY() - prevPT.y;
		for(int i=0; i<canvas.selectedShapes.size(); i++) { // move selected object
			(canvas.selectedShapes.get(i)).resetLocation(moveX, moveY);
			prevPT.x = e.getX();
			prevPT.y = e.getY();
			canvas.repaint();
		}
		
		if(canvas.selectedShapes.size()==0) { // create select square
			press_square_end.setLocation(e.getX(), e.getY());
			sq.Relocation(press_square_end);
			canvas.repaint();
		}
	}
	public void mouseClicked(MouseEvent e) {
		canvas.selectedShapes.clear();
		for(int i=0; i<canvas.shapes.size(); i++) {
			canvas.shapes.get(i).initSelect();
		}
		for(int i=0; i<canvas.shapes.size(); i++) {
			Shape shape = canvas.shapes.get(i);
			if(shape.judgeSelect(e.getX(), e.getY())) {
				canvas.selectedShapes.add(shape);
				break; // select a object at a time, will take the earliest inserted object
			}
		}
		canvas.repaint();
	}
}
