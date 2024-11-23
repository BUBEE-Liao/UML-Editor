package View;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Controller.ObjectMode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObjButton extends JButton{
	private Color color = Color.pink;
	private boolean select = false;
	private static Canvas canvas;
	private String type = null;
	
	public ObjButton(String icon_path, String type) {
		this.canvas = Canvas.getInstance();
		super.setIcon(new ImageIcon(icon_path));
		super.setBackground(this.color);
		super.setOpaque(true);
		setActionPerformed();
		this.type = type;
	}
	
	public void setBackground(Color color) {
		super.setBackground(color);
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setActionPerformed() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.initBtn(); //initialize button color
				((JButton)e.getSource()).setBackground(Color.BLACK);
				canvas.setMode(new ObjectMode());//set mode to canvas
				canvas.setCurrentObj(((ObjButton)e.getSource()).getType());//set object type to canvas
				canvas.setListener(); //change mode
			}
		});
	}
}
