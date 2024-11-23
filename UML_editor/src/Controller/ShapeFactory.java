package Controller;

import Shape.*;

public class ShapeFactory {
	
	private String type = null;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Shape createObject(int x, int y) {
		if(type.equals("UseCase")) {return new UseCaseObj(x, y);}
		if(type.equals("Class")) {return new ClassObj(x, y);}
		return null;
	}
	
	public Shape createLine(Port start, Port end) {
		if(type.equals("Composition")) {return new CompositionLine(start, end);};
		if(type.equals("Association")) {return new AssociationLine(start, end);};
		if(type.equals("Generalization")) {return new GeneralizationLine(start, end);};
		return null; 
	}
}
