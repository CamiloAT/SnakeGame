package co.edu.uptc.model;

import java.util.ArrayList;

public class Historial {

	private ArrayList<HistorialRow> historials;

	public Historial() {
		historials=new ArrayList<HistorialRow>();
	}
	
	public void addHistorialRow(HistorialRow historialRow) {
		this.historials.add(historialRow);
	}
	
	public ArrayList<HistorialRow> getHistorials() {
		return historials;
	}
}
