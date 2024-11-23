package View;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Controller.LineMode;
import Controller.SelectMode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LineButton extends JButton{
	private Color color = Color.pink;
	private boolean select = false;
	private static Canvas canvas;
	private String type = null;
	
	public LineButton(String icon_path, String type) {
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
				canvas.initBtn();
				((JButton)e.getSource()).setBackground(Color.BLACK);
				canvas.setMode(new LineMode());
				canvas.setCurrentObj(((LineButton)e.getSource()).getType());
				canvas.setListener();
			}
		});
	}
}
