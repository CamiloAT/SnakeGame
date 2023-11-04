package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	private FieldPanel fieldPanel;
	private SnakePanel snakePanel;
	private String speed;
	private String food;
	private String obstacule;
	private String increase;
	private String size;
	
	public GamePanel(ActionListener actionListener, String speed, String food, String obstacule, String increase, String size) {
		this.speed = speed;
		this.food = food;
		this.obstacule = obstacule;
		this.increase = increase;
		this.size = size;
		this.initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.setLayout(null);
		
		snakePanel = new SnakePanel(this.speed, this.food, this.obstacule, this.increase, this.size);
		add(snakePanel, BorderLayout.CENTER);
		snakePanel.setBounds(0, 60, 893, 556);
		snakePanel.setOpaque(false);
		snakePanel.setLayout(null);
		
		fieldPanel = new FieldPanel();
		add(fieldPanel);
		fieldPanel.setBounds(0, 60, 893, 556);
	}
}
