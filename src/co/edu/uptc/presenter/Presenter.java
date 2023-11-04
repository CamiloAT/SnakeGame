package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.uptc.exceptions.NotValidException;
import co.edu.uptc.model.Historial;
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
	
	public Presenter(){
		configuration = new Configuration();
		principalFrame = new PrincipalFrame(this, this.history);
		informationDialog = new InformationDialog();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "Information": {
			this.informationDialog.setVisible(true);
			break;
		}
		case "History": {
			this.principalFrame.showHistoryPanel(this);
			break;
		}
		case "Return": {
			this.principalFrame.showMenuPanel();
			break;
		}
		case "Play": {
			this.tryPlay();
			break;
		}
		default:
			break;
		}
		
	}

	private void playMethod() throws NotValidException {
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
	
	private void tryPlay(){
		try {
			this.playMethod();
		} catch (NotValidException e) {
			errorDialog = new ErrorDialog(e.getMessage());
			errorDialog.setVisible(true);
		}
	}
	
	public static void main(String[] args){
		new Presenter();
	}
}
