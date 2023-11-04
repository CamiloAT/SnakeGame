package co.edu.uptc.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PrincipalFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public PrincipalFrame() {
		super("Snake Game");
		this.setSize(893,556);
		this.initComponents();
		this.setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.setLayout(null);

	}

}
