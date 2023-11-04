package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorDialog extends JDialog{
	
	private JLabel iconLabel;
	private JLabel messageLabel;
	private String message;
	private JPanel panel_1;
	
	public ErrorDialog(String message) {
		this.message=message;
		this.initComponents();
	}
	
	private void initComponents() {
		this.setResizable(false);
		setBounds(0, 0, 520, 150);
		getContentPane().setBackground(new Color(204, 247, 255));
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		
		iconLabel = new JLabel("");
		iconLabel.setBounds(20, 32, 50, 50);
		this.setImageLabel(iconLabel, "Images/Fail.png");
		getContentPane().add(iconLabel);
		
		messageLabel = new JLabel(this.message);
		messageLabel.setForeground(new Color(0, 66, 132));
		messageLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		messageLabel.setBounds(92, 40, 349, 35);
		getContentPane().add(messageLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(0, 103, 506, 10);
		getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 255));
		panel_1.setBounds(0, 0, 506, 10);
		getContentPane().add(panel_1);
}
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
}
