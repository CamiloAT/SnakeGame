package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import com.google.gson.JsonParseException;
import co.edu.uptc.exceptions.NotValidException;
import co.edu.uptc.model.Historial;
import co.edu.uptc.model.HistorialRow;
import co.edu.uptc.persistence.JsonPersistence;
import co.edu.uptc.properties.Configuration;
import co.edu.uptc.view.ErrorDialog;
import co.edu.uptc.view.InformationDialog;
import co.edu.uptc.view.PrincipalFrame;

public class Presenter implements ActionListener{

	private Configuration configuration;
	private PrincipalFrame principalFrame;
	private InformationDialog informationDialog;
	private ErrorDialog errorDialog;
	private Historial history;
	private JsonPersistence json;
	
	public Presenter() throws JsonParseException, IOException{
		json = new JsonPersistence();
		history = json.getHistorial();
		configuration = new Configuration();
		principalFrame = new PrincipalFrame(this);
		informationDialog = new InformationDialog();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "Information": {
			this.informationMethod();
			break;
		}
		case "History": {
			this.historyMethod();
			break;
		}
		case "Return": {
			this.returnMethod();
			break;
		}
		case "Lose": {
			this.loseMethod();
			break;
		}
		case "Play": {
			this.playMethod();
			break;
		}
		default:
			break;
		}
	}

	private void informationMethod() {
		this.informationDialog.setVisible(true);
	}
	
	private void historyMethod() {
		this.principalFrame.showHistoryPanel(this);
		this.principalFrame.fillTable(this.history.getHistorials());
	}
	
	private void returnMethod() {
		this.principalFrame.showMenuPanel();
	}
	
	private void loseMethod() {
		this.principalFrame.showMenuPanel();
		if (!this.principalFrame.getStateThread()) {
			String localTime = ""+LocalTime.now();
			String localHour = "";
			for (int i = 0; i < 8; i++) {
				localHour+=localTime.charAt(i);
			}
			HistorialRow historialRow = new HistorialRow(principalFrame.getNamePlayer(), ""+LocalDate.now(), localHour, principalFrame.getScore(), principalFrame.getWorldCombo());
			this.history.addHistorialRow(historialRow);
			try {
				json.writeJson(this.history);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private void playMethodError() throws NotValidException {
		if (this.principalFrame.isNameEmpty()) {
			throw new NotValidException("Upss, ingrese su nombre");
		}else if (this.principalFrame.getWorldCombo().equals("Ingrese la dificultad")) {
			throw new NotValidException("Upss, ingrese la dificultad");
		}else {
			if (this.principalFrame.getWorldCombo().equals("Facil")) {
				this.principalFrame.showGamePanel(this, configuration.getEasyTime(), configuration.getEasyFood(), configuration.getEasyObstacule(), configuration.getEasyIncrease(), configuration.getEasySize());
			}else if(this.principalFrame.getWorldCombo().equals("Media")) {
				this.principalFrame.showGamePanel(this, configuration.getMediumTime(), configuration.getMediumFood(), configuration.getMediumObstacule(), configuration.getMediumIncrease(), configuration.getMediumSize());
			}else {
				this.principalFrame.showGamePanel(this, configuration.getDifficultTime(), configuration.getDifficultFood(), configuration.getDifficultObstacule(), configuration.getDifficultIncrease(), configuration.getDifficultSize());
			}
		}
	}
	
	private void playMethod(){
		try {
			this.playMethodError();
		} catch (NotValidException e) {
			errorDialog = new ErrorDialog(e.getMessage());
			errorDialog.setVisible(true);
		}
	}
	
	public static void main(String[] args) throws JsonParseException, IOException{
		new Presenter();
	}
}
