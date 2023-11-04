package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel{

	private JLabel scoreLabel;
	private JLabel pointsLabel;
	private JButton returnButton;
	
	public ScorePanel(ActionListener actionListener) {
		this.initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		setBackground(new Color(0, 128, 255));
		setLayout(null);
		
		scoreLabel = new JLabel("Score:");
		scoreLabel.setForeground(new Color(0, 66, 132));
		scoreLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
		scoreLabel.setBounds(24, 10, 117, 40);
		add(scoreLabel);
		
		pointsLabel = new JLabel("0");
		pointsLabel.setForeground(new Color(0, 66, 132));
		pointsLabel.setFont(new Font("Monospaced", Font.PLAIN, 30));
		pointsLabel.setBounds(151, 10, 117, 40);
		add(pointsLabel);
		
		returnButton = new JButton("");
		returnButton.setBounds(820, 19, 24, 24);
		returnButton.setBackground(new Color(0, 128, 255));
		returnButton.setIcon(new ImageIcon("Images/Come_Back.png"));
		returnButton.setBorder(null);
		returnButton.setActionCommand("Return");
		returnButton.addActionListener(actionListener);
		add(returnButton);
	}
	
	public void setPointsNumber(String ponits) {
		pointsLabel.setText(ponits);
	}
}
