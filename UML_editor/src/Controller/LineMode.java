package Controller;

import java.awt.event.MouseEvent;

import Shape.Port;
import Shape.Shape;


public class LineMode extends Mode{
	private Port start_pt = null; // start port
	private Port end_pt = null; // end port
	private ShapeFactory factory=new ShapeFactory();
	private Shape startOBJ; //make sure obj can't line to itself
	
	public void mousePressed(MouseEvent e) {
		start_pt = null;
		for(int i=0; i<canvas.shapes.size(); i++) {
			Shape obj = canvas.shapes.get(i);
			if(obj.InputPointInsideOrNot((int)e.getX(), (int)e.getY())) {
				factory.setType(canvas.getCurrentObj());
				start_pt = obj.getMinDisePort((int)e.getX(), (int)e.getY());
				startOBJ = obj;
			}
		}
	}
	public void mouseReleased(MouseEvent e) {
		
		end_pt = null;
		for(int i=0; i<canvas.shapes.size(); i++) {
			Shape obj = canvas.shapes.get(i);
			if(obj.InputPointInsideOrNot((int)e.getX(), (int)e.getY())) {
				if(!(obj.equals(startOBJ))) { //make sure obj can't line to itself
					end_pt = obj.getMinDisePort((int)e.getX(), (int)e.getY());
					break;} // make sure line only created once
			}
		}
		if(start_pt!=null && end_pt!=null) { 
			Shape line = factory.createLine(start_pt, end_pt);
			canvas.shapes.add(line);
		}
		canvas.repaint();
	}
	public void mouseClicked(MouseEvent e) {
		start_pt=null;
		end_pt=null;
	}
}
