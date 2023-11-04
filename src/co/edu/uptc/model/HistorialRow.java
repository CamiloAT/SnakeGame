package co.edu.uptc.model;

public class HistorialRow {

	private String name;
	private String date;
	private String hour;
	private String score;
	private String level;
	
	public HistorialRow(String name, String date, String hour, String score, String level) {
		super();
		this.name = name;
		this.date = date;
		this.hour = hour;
		this.score = score;
		this.level=level;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getHour() {
		return hour;
	}

	public String getScore() {
		return score;
	}
	
	public String getLevel() {
		return level;
	}
}
