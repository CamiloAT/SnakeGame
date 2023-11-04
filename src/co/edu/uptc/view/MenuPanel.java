package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class MenuPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanel edgePanel1;
	private JPanel edgePanel2;
	private JLabel snakeIcon;
	private JLabel tittleLabel;
	private JLabel nameLabel;
	private JLabel difficultLabel;
	private JComboBox<String> levelComboBox;
	private JTextField nameTextField;
	private JButton playButton;
	private JButton historyButton;
	private JButton informationButton;
	
	public MenuPanel(ActionListener actionListener) {
		this.initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		setBackground(new Color(204, 247, 255));
		setLayout(null);
		
		edgePanel1 = new JPanel();
		edgePanel1.setBackground(new Color(0, 128, 255));
		edgePanel1.setBounds(0, 0, 893, 60);
		add(edgePanel1);
		
		edgePanel2 = new JPanel();
		edgePanel2.setBackground(new Color(0, 128, 255));
		edgePanel2.setBounds(0, 519, 893, 60);
		add(edgePanel2);

		snakeIcon = new JLabel("");
		snakeIcon.setBounds(509, 215, 278, 233);
		this.setImageLabel(snakeIcon, "Images/Snake.png");
		add(snakeIcon);
		
		tittleLabel = new JLabel("Snake Game");
		tittleLabel.setForeground(new Color(4, 117, 166));
		tittleLabel.setFont(new Font("Monospaced", Font.BOLD, 60));
		tittleLabel.setBounds(250, 71, 395, 67);
		add(tittleLabel);
		
		nameTextField = new JTextField();
		nameTextField.setForeground(new Color(3, 88, 124));
		nameTextField.setFont(new Font("Monospaced", Font.PLAIN, 25));
		nameTextField.setBorder(new MatteBorder(3, 3, 3, 3, new Color(4, 117, 166)));
		nameTextField.setBackground(new Color(204, 247, 255));
		nameTextField.setBounds(83, 229, 292, 46);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		playButton = new JButton("Jugar");
		playButton.setForeground(new Color(204, 247, 255));
		playButton.setBorder(new MatteBorder(3, 3, 3, 3, new Color(4, 117, 166)));
		playButton.setBackground(new Color(0, 128, 255));
		playButton.setFont(new Font("Monospaced", Font.PLAIN, 30));
		playButton.setActionCommand("Play");
		playButton.addActionListener(actionListener);
		playButton.setBounds(83, 429, 218, 50);
		add(playButton);
		
		nameLabel = new JLabel("Ingrese su nombre:");
		nameLabel.setForeground(new Color(4, 117, 166));
		nameLabel.setFont(new Font("Monospaced", Font.PLAIN, 25));
		nameLabel.setBounds(83, 185, 346, 34);
		add(nameLabel);
		
		levelComboBox = new JComboBox<String>();
		levelComboBox.setFont(new Font("Monospaced", Font.PLAIN, 30));
		levelComboBox.setBorder(new MatteBorder(3, 3, 3, 3, new Color(4, 117, 166)));
		levelComboBox.setBackground(new Color(204, 247, 255));
		levelComboBox.setBounds(83, 345, 292, 50);
		add(levelComboBox);
		this.fillComboBox();
		
		difficultLabel = new JLabel("Ingrese la dificultad:");
		difficultLabel.setForeground(new Color(4, 117, 166));
		difficultLabel.setFont(new Font("Monospaced", Font.PLAIN, 25));
		difficultLabel.setBounds(83, 285, 346, 60);
		add(difficultLabel);
		
		historyButton = new JButton("");
		historyButton.setBackground(new Color(204, 247, 255));
		historyButton.setIcon(new ImageIcon("Images/History.png"));
		historyButton.setBorder(null);
		historyButton.setBounds(802, 70, 24, 24);
		historyButton.setActionCommand("History");
		historyButton.addActionListener(actionListener);
		add(historyButton);
		
		informationButton = new JButton("");
		informationButton.setBorder(null);
		informationButton.setIcon(new ImageIcon("Images/Information.png"));
		informationButton.setBackground(new Color(204, 247, 255));
		informationButton.setBounds(840, 70, 24, 24);
		informationButton.setActionCommand("Information");
		informationButton.addActionListener(actionListener);
		add(informationButton);
	
	}
	
	private void fillComboBox() {
		levelComboBox.addItem("Ingrese la dificultad");
		levelComboBox.addItem("Facil");
		levelComboBox.addItem("Media");
		levelComboBox.addItem("Dificil");
	}
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
	
	public String getWorldCombo() {
		String word = (String) levelComboBox.getSelectedItem();
		return word;
	}
	
	public boolean isNameEmpty() {
		boolean flag=false;
		if(nameTextField.getText().length()==0) {
			flag=true;
		}
		return flag;
	}
}
