package View;

import java.util.ArrayList;
import java.awt.Color;
import java.util.EventListener;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Controller.Mode;
import Shape.GroupObj;
import Shape.LineObj;
import Shape.Shape;

public class Canvas extends JPanel{

	private static Canvas instance = null;
	private String currentObjType = null;
	public List<Shape> shapes = new ArrayList<Shape>();
	public List<Shape> selectedShapes = new ArrayList<Shape>();
	public List<Shape> temp = new ArrayList<Shape>();
	private EventListener mode = null;
	private String new_name = ""; //for changing objects' name
	public List<JButton> buttons = null;
	
	private Canvas() {}
	private Mode currentMode;
	
	public static Canvas getInstance() { // Singleton design pattern
		if(instance==null) {
			instance = new Canvas();
		}
		return instance;
	}
	
	public void setListener() {
		removeMouseListener((MouseListener) mode);
		removeMouseMotionListener((MouseMotionListener) mode);
		mode = currentMode;
		addMouseListener((MouseListener) mode);
		addMouseMotionListener((MouseMotionListener) mode);
	}
	
	public void setMode(Mode mode) {
		this.currentMode = mode;
	}
	
	public void setCurrentObj(String objName) {
		this.currentObjType = objName;
	}
	
	public String getCurrentObj() {
		return this.currentObjType;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0; i<shapes.size(); i++) {
			shapes.get(i).draw(g);
			shapes.get(i).show(g);
		}
		for(int i=0; i<temp.size(); i++) {
			temp.get(i).draw(g);
		}
	}
	
	public void setNewName(String new_name) {
		for(int i=0; i<selectedShapes.size(); i++) {
			selectedShapes.get(i).setNewName(new_name);
		}
		repaint();
	}
	
	public void initBtn() {
		for(int i=0; i<buttons.size(); i++) {
			buttons.get(i).setBackground(Color.PINK);
		}
	}
	
	public void Group() {
		GroupObj g = new GroupObj(selectedShapes);
		for(int i=0; i<selectedShapes.size(); i++) {
			if(!(selectedShapes.get(i) instanceof LineObj)) {
				shapes.remove(selectedShapes.get(i));
			}
		}
		selectedShapes.clear();
		shapes.add(g);
		repaint();
	}
	
	public void Ungroup() {
		for(int i=0; i<selectedShapes.size();i++) {
			((Shape)selectedShapes.get(i)).unGroup();
		}
	}
}
