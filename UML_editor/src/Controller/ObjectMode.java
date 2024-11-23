package Controller;

import java.awt.event.MouseEvent;

import Shape.RectObject;
import Shape.Shape;

import java.awt.Point;

public class ObjectMode extends Mode{
	
	private ShapeFactory factory = new ShapeFactory();
	
	public void mousePressed(MouseEvent e) {
		factory.setType(canvas.getCurrentObj());
		Shape obj = this.factory.createObject((int)e.getX(), (int)e.getY());
		canvas.shapes.add(obj);
		canvas.repaint();
	}
}
