package co.edu.uptc.myComponents;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{

	private String[] tittles;
	private Object[][] data;

	public MyTableModel(Object[][] data, String[] tittles) {
		this.tittles=tittles;
		this.data=data;
		setDataVector(this.data, this.tittles);
	}

	public boolean isCellEditable (int row, int column){
		return false;
	}

}
