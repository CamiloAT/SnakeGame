package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class FieldPanel extends JPanel{

	private int counter;

	public FieldPanel() {
		counter = 0;
	}

	private void paintField(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 13; j++) {
				if (counter%2==0) {
					g2d.setColor(new Color(2, 209, 64));
				}else {
					g2d.setColor(new Color(2, 179, 55));
				}
				g2d.fillRect(40*i, 40*j, 40, 40);
				counter++;
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.paintField(g);
	}
}
