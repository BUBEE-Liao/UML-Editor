package View;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;


public class MainFrame extends JFrame{
	
	private ToolBar toolBar;
	public Canvas canvas;
	private MenuBar menubar;
	
	private JLabel jlb;
	public int width;
	public int height;
	
	
	public MainFrame() throws IOException {
		super("UML Editor");
		
		toolBar = new ToolBar();
		canvas = Canvas.getInstance();
		menubar = new MenuBar();
		
		setSize(1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program shut down when click x bottom
		
		add(canvas, BorderLayout.CENTER);
		add(toolBar, BorderLayout.WEST);
		add(menubar, BorderLayout.NORTH);
		
		setVisible(true); // without this line, the frame won't be visible		
	}

	public static void main(String[] args) throws IOException {
		MainFrame mf = new MainFrame();
	}

}