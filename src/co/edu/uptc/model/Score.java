package co.edu.uptc.model;

import co.edu.uptc.view.SnakePanel;

public class Score implements Runnable{

	private SnakePanel snakePanel;
	private boolean state;
	private String speed;
	
	public Score(SnakePanel snakePanel, String speed) {
		this.snakePanel=snakePanel;
		this.speed=speed;
		state=true;
	}
	
	@Override
	public void run() {
		while (state) {
			this.snakePanel.uploadScore();
			try {
				Thread.sleep(Integer.parseInt(this.speed));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
