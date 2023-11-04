package co.edu.uptc.model;

import co.edu.uptc.view.SnakePanel;

public class Obstacule implements Runnable{

	private SnakePanel snakePanel;
	private boolean state;
	private int timer;
	private String obstaculeSpeed;
	private String speed;
	
	public Obstacule(SnakePanel snakePanel, String obstaculeSpeed, String speed) {
		this.snakePanel=snakePanel;
		this.obstaculeSpeed=obstaculeSpeed;
		this.speed=speed;
		state=true;
		this.timer=(Integer.parseInt(this.obstaculeSpeed)/Integer.parseInt(this.speed));
	}
	
	@Override
	public void run() {
		while (state) {
			try {
				Thread.sleep(Integer.parseInt(this.speed));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(timer<=0) {
				this.snakePanel.generateObstacule();
				this.snakePanel.repaint();
				timer=(Integer.parseInt(this.obstaculeSpeed)/Integer.parseInt(this.speed));
			}
			timer--;
		}
	}

	public int getTimer() {
		return timer;
	}
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
