package co.edu.uptc.model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import co.edu.uptc.view.SnakePanel;

public class Snake implements Runnable, KeyListener{

	private SnakePanel snakePanel;
	private int direction;
	private int previusDirection;
	private boolean state;
	private String speed;
	private String increase;
	
	public Snake(SnakePanel snakePanel, String speed, String increase) {
		this.snakePanel=snakePanel;
		this.speed=speed;
		this.increase=increase;
		direction = 39;
		previusDirection=direction;
		state=true;
	}
	
	@Override
	public void run() {
		while (state) {
			this.snakePanel.requestFocusInWindow();
			this.snakePanel.moveSnake(direction);
			this.snakePanel.eatFood(direction);
			this.snakePanel.repaint();
			try {
				Thread.sleep(Integer.parseInt(speed));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar()=='D'||e.getKeyChar()=='d') {
			if (previusDirection!=37&&previusDirection!=39) {
				direction=39;
			}
		}else if(e.getKeyChar()=='A'||e.getKeyChar()=='a') {
			if (previusDirection!=37&&previusDirection!=39) {
				direction=37;
			}
		}else if(e.getKeyChar()=='W'||e.getKeyChar()=='w') {
			if (previusDirection!=40&&previusDirection!=38) {
				direction=38;
			}
		}else if(e.getKeyChar()=='S'||e.getKeyChar()=='s') {
			if (previusDirection!=40&&previusDirection!=38) {
				direction=40;
			}
		}
		previusDirection=direction;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if (previusDirection!=37&&previusDirection!=39) {
				direction=39;
			}
			break;
		case KeyEvent.VK_LEFT:
			if (previusDirection!=37&&previusDirection!=39) {
				direction=37;
			}
			break;
		case KeyEvent.VK_UP:
			if (previusDirection!=40&&previusDirection!=38) {
				direction=38;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (previusDirection!=40&&previusDirection!=38) {
				direction=40;
			}
			break;
		default:
			break;
		}
		previusDirection=direction;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
}
