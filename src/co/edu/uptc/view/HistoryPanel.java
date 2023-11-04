package co.edu.uptc.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import co.edu.uptc.model.HistorialRow;
import co.edu.uptc.myComponents.MyScroll;
import co.edu.uptc.myComponents.MyTable;

public class HistoryPanel extends JPanel{
	
	private JPanel edgePanel1;
	private JButton returnButton;
	private JTable historyTable;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	
	public HistoryPanel(ActionListener actionListener) {
		this.initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		setBackground(new Color(204, 247, 255));
		setLayout(null);
		
		edgePanel1 = new JPanel();
		edgePanel1.setBackground(new Color(0, 128, 255));
		edgePanel1.setBounds(0, 0, 893, 60);
		add(edgePanel1);
		edgePanel1.setLayout(null);
		
		returnButton = new JButton("");
		returnButton.setBounds(10, 19, 24, 24);
		returnButton.setBackground(new Color(0, 128, 255));
		returnButton.setIcon(new ImageIcon("Images/Come_Back.png"));
		returnButton.setBorder(null);
		returnButton.setActionCommand("Return");
		returnButton.addActionListener(actionListener);
		edgePanel1.add(returnButton);
		
		String[] tittles = {"Nombre", "Score", "Fecha", "Hora", "Nivel"};
		historyTable = new MyTable(null, tittles, 5);
		scrollPane = new JScrollPane(historyTable);
		scrollPane.getVerticalScrollBar().setUI(new MyScroll());
		scrollPane.setBounds(23, 70, 838, 467);
		add(scrollPane);
	}
	
	public void fillTable(ArrayList<HistorialRow> historials){
		tableModel = (DefaultTableModel) historyTable.getModel();
		tableModel.setRowCount(0);
		historyTable.repaint();
		for (int i = 0; i < historials.size(); i++) {
			HistorialRow historial = historials.get(i);
			this.addRow(historial);
		}
	}
	
	public void addRow(HistorialRow historial) {
		tableModel.addRow(new Object[] {historial.getName(), historial.getScore(), historial.getDate(), historial.getHour(), historial.getLevel()});
	}	
}
