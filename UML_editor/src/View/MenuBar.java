package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Shape.GroupObj;
import Shape.LineObj;
import Shape.RectObject;
import Shape.Shape;


public class MenuBar extends JMenuBar{

	private Canvas canvas = Canvas.getInstance();
	public MenuBar() throws IOException {
		
		JMenu File = new JMenu("File");
		JMenu Edit = new JMenu("Edit");
		
		this.add(File);
		this.add(Edit);
		
		JMenuItem ChangeName = new JMenuItem("Change Name");
		ChangeName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String new_name = JOptionPane.showInputDialog(canvas, "Enter New Name plz");
				canvas.setNewName(new_name);
			}
			
		});
		Edit.add(ChangeName);
		
		JMenuItem Group = new JMenuItem("Group");
		Group.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.Group();
			}
		});
		Edit.add(Group);
		
		JMenuItem UnGroup = new JMenuItem("Ungroup");
		UnGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.Ungroup();
			}
		});
		Edit.add(UnGroup);
	}
	
}
