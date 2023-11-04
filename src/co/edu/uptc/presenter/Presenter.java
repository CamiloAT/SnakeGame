package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.uptc.view.PrincipalFrame;

public class Presenter implements ActionListener{

	private PrincipalFrame principalFrame;
	
	public Presenter() {
		principalFrame = new PrincipalFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "": {
			
			break;
		}
		default:
			break;
		}
		
	}

	public static void main(String[] args) {
		new Presenter();
	}
}
