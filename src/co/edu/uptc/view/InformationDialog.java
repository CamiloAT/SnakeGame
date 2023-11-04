package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InformationDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel logoLabel;
	private JLabel developedTittleLabel;
	private JLabel footerLabel;
	private JLabel nameLabel;
	private JLabel codeLabel;
	private JLabel facultyLabel;
	private JLabel schoolLabel;
	private JLabel classLabel;
	private JLabel yearLabel;

	public InformationDialog() {
		this.initComponents();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		this.setResizable(false);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(227, 204, 0));
		g.drawLine(25, 200, 595, 200);
		g.drawLine(25, 246, 595, 246);
		g.drawLine(25, 292, 595, 292);
		g.drawLine(355, 155, 355, 190);
		g.drawLine(355, 210, 355, 238);
	}
	
	private void initComponents() {
		setBounds(100, 100, 620, 443);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		logoLabel = new JLabel("");
		logoLabel.setBounds(-10, 0, 596, 65);
		this.setImageLabel(logoLabel, "Images/Logo.png");
		contentPanel.add(logoLabel);
		
		developedTittleLabel = new JLabel("Desarrollado por:");
		developedTittleLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		developedTittleLabel.setBounds(23, 86, 241, 27);
		contentPanel.add(developedTittleLabel);
		
		nameLabel = new JLabel("Camilo Andres Arias Tenjo");
		nameLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		nameLabel.setBounds(23, 123, 317, 37);
		contentPanel.add(nameLabel);
		
		codeLabel = new JLabel("202210549");
		codeLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		codeLabel.setBounds(365, 123, 108, 37);
		contentPanel.add(codeLabel);
		
		footerLabel = new JLabel("");
		footerLabel.setBounds(-10, 313, 596, 93);
		this.setImageLabel(footerLabel, "Images/Footer.png");
		contentPanel.add(footerLabel);
		
		facultyLabel = new JLabel("Facultad de Ingenieria");
		facultyLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		facultyLabel.setBounds(23, 170, 317, 37);
		contentPanel.add(facultyLabel);
		
		schoolLabel = new JLabel("Escuela de Ingenieria de Sistemas y Computacion");
		schoolLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		schoolLabel.setBounds(23, 217, 596, 37);
		contentPanel.add(schoolLabel);
		
		classLabel = new JLabel("Programacion III");
		classLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		classLabel.setBounds(365, 170, 206, 37);
		contentPanel.add(classLabel);
		
		yearLabel = new JLabel("2023");
		yearLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		yearLabel.setBounds(23, 264, 317, 37);
		contentPanel.add(yearLabel);
	}
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
}
