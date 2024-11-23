package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ToolBar extends JPanel{
	
	private List<JButton> buttons = null;
	private Canvas canvas;
	
	
	
	public ToolBar() throws IOException {
		
		canvas = Canvas.getInstance();
		
		buttons = new ArrayList<JButton>();
		buttons.add(new SelectButton("src/img/icon1.png", "Select"));
		buttons.add(new LineButton("src/img/icon2.png", "Association"));
		buttons.add(new LineButton("src/img/icon3.png", "Generalization"));
		buttons.add(new LineButton("src/img/icon4.png", "Composition"));
		buttons.add(new ObjButton("src/img/icon5.png", "Class"));
		buttons.add(new ObjButton("src/img/icon6.png", "UseCase"));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel buttonCenter = new JPanel(new GridBagLayout());
	    buttonCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
	    JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 5, 5));

	    for (int i=0; i<buttons.size(); i++) {
	    	buttonPanel.add(buttons.get(i));
	    }

	    buttonCenter.add(buttonPanel);
	    add(buttonCenter);
	    canvas.buttons = buttons; 
	}
}
