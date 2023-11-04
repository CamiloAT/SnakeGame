package co.edu.uptc.view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.model.Historial;
import co.edu.uptc.model.HistorialRow;

public class PrincipalFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel;
	private MenuPanel menuPanel;
	private HistoryPanel historyPanel;
	private JPanel cardLayout;
	private CardLayout card;

	public PrincipalFrame(ActionListener actionListener, Historial historial) {
		super("Snake Game");
		this.setIconImage(new ImageIcon("Images/Snake.png").getImage());
		this.setSize(893,616);
		this.initComponents(actionListener);
		this.setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		this.setLayout(null);
		this.setResizable(false);

		card = new CardLayout();
		cardLayout = new JPanel(card);
		cardLayout.setBounds(0, 0, this.getWidth(), this.getHeight());

		menuPanel = new MenuPanel(actionListener);
		menuPanel.setBounds(0, 0, 893, 556);
		cardLayout.add(menuPanel, "Menu");
		card.show(cardLayout, "Menu");
		add(cardLayout);
	}

	public void showMenuPanel() {
		card.show(cardLayout, "Menu");
		cardLayout.revalidate();
		cardLayout.repaint();
	}

	public String getWorldCombo() {
		return menuPanel.getWorldCombo();
	}

	public boolean isNameEmpty() {
		return this.menuPanel.isNameEmpty();
	}

	public void showHistoryPanel(ActionListener actionListener) {
		historyPanel = new HistoryPanel(actionListener);
		cardLayout.add(historyPanel, "History");
		card.show(cardLayout, "History");
		cardLayout.revalidate();
		cardLayout.repaint();
	}

	public void showGamePanel(ActionListener actionListener, String speed, String food, String obstacule, String increase, String size) {
		gamePanel = new GamePanel(actionListener, speed, food, obstacule, increase, size);
		cardLayout.add(gamePanel, "Game");
		card.show(cardLayout, "Game");
		cardLayout.revalidate();
		cardLayout.repaint();
	}

	public void fillTable(ArrayList<HistorialRow> historials){
		this.historyPanel.fillTable(historials);
	}

	public void addRow(HistorialRow historial) {
		this.historyPanel.addRow(historial);	
	}	
}
