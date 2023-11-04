package co.edu.uptc.model;

import co.edu.uptc.view.SnakePanel;

public class Food implements Runnable{

	private SnakePanel snakePanel;
	private String foodSpeed;
	private String speed;
	private boolean state;
	private int timer;
	
	public Food(SnakePanel snakePanel, String foodSpeed, String speed) {
		this.snakePanel=snakePanel;
		this.foodSpeed=foodSpeed;
		this.speed=speed;
		state=true;
		this.timer=(Integer.parseInt(this.foodSpeed)/Integer.parseInt(this.speed));
	}
	
	@Override
	public void run() {
		while (state) {
			try {
				Thread.sleep(Integer.parseInt(speed));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(timer<=0) {
				this.snakePanel.generateFood();
				this.snakePanel.repaint();
				timer=(Integer.parseInt(this.foodSpeed)/Integer.parseInt(this.speed));
			}
			timer--;
		}
		
		
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
