package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

import javax.swing.JPanel;

import co.edu.uptc.model.Coordinates;
import co.edu.uptc.model.Food;
import co.edu.uptc.model.Snake;

public class SnakePanel extends JPanel{

	private int squareSize;
	private Vector<Coordinates> snake;
	private Coordinates lastPosition;
	private Coordinates food;
	private Coordinates obstacule;
	private Snake snakeThread;
	private Food foodThread;
	private Thread threadOne;
	private Thread threadTwo;
	private String speed;
	private String foodSpeed;
	private String obstaculeSpeed;
	private String increase;
	private String size;

	public SnakePanel(String speed, String foodSpeed, String obstaculeSpeed, String increase, String size) {
		this.speed = speed;
		this.foodSpeed = foodSpeed;
		this.obstaculeSpeed = obstaculeSpeed;
		this.increase = increase;
		this.size = size;
		squareSize = 40;
		this.startSnake();
	}

	private void startSnake() {
		this.paintSnake(this.size);

		this.generateFood();
		
		snakeThread = new Snake(this, this.speed, this.increase);
		foodThread = new Food(this, this.foodSpeed, this.speed);

		this.addKeyListener(snakeThread);
		this.requestFocus();

		threadOne = new Thread(snakeThread);
		threadOne.start();
		threadTwo= new Thread(foodThread);
		threadTwo.start();
	}
	
	public synchronized void generateFood() {
		Coordinates foodCoordinates = new Coordinates(0, 0);
		boolean alreadyUsed = true;
		while (alreadyUsed) {
			foodCoordinates = new Coordinates((int)(Math.random()*22), (int)(Math.random()*13));
			alreadyUsed=false;
//			if(obstacule!=null&&foodCoordinates.getX()==obstacule.getX()&&foodCoordinates.getY()==obstacule.getY()) {
//				alreadyUsed=true;
//			}
			for (Coordinates coordinates : snake) {
				if (coordinates.getX()==foodCoordinates.getX()&&coordinates.getY()==foodCoordinates.getY()) {
					alreadyUsed=true;
					break;
				}
			}
		}
		food = foodCoordinates;
	}
	
	public synchronized boolean eatFood(int direction) {
		boolean flag = false;
		if (this.lastPosition.getX()==this.food.getX()&&this.lastPosition.getY()==this.food.getY()) {
			this.moveSnake(direction);
			this.snake.add(lastPosition);
			this.foodThread.setTimer(0);
			flag=true;
		}
		return flag;
	}

	private void paintSnake(String size) {
		snake = new Vector<Coordinates>();
		if (Integer.parseInt(size)==3) {

			snake.add(new Coordinates(0, 5));
			snake.add(new Coordinates(1, 5));
			snake.add(new Coordinates(2, 5));
		}else if(Integer.parseInt(size)==4) {
			snake.add(new Coordinates(0, 5));
			snake.add(new Coordinates(1, 5));
			snake.add(new Coordinates(2, 5));
			snake.add(new Coordinates(3, 5));
		}else {
			snake.add(new Coordinates(0, 5));
			snake.add(new Coordinates(1, 5));
			snake.add(new Coordinates(2, 5));
			snake.add(new Coordinates(3, 5));
			snake.add(new Coordinates(4, 5));
		}
		lastPosition=snake.get(snake.size()-1);
	}

	public synchronized  void moveSnake(int direction) {
		switch (direction) {
		case 39:
			Coordinates newPosition = ((lastPosition.getX()+1)>21)?new Coordinates(0, lastPosition.getY()):new Coordinates(lastPosition.getX()+1, lastPosition.getY());
			this.lastPosition = newPosition;
			snake.add(newPosition);
			break;
		case 37:
			Coordinates newPosition1 = ((lastPosition.getX()-1)<0)?new Coordinates(21, lastPosition.getY()):new Coordinates(lastPosition.getX()-1, lastPosition.getY());
			this.lastPosition = newPosition1;
			snake.add(newPosition1);
			break;
		case 38:
			Coordinates newPosition2 = ((lastPosition.getY()-1)<0)?new Coordinates(lastPosition.getX(), 12):new Coordinates(lastPosition.getX(), lastPosition.getY()-1);
			this.lastPosition = newPosition2;
			snake.add(newPosition2);
			break;
		case 40:
			Coordinates newPosition3 = ((lastPosition.getY()+1)>12)?new Coordinates(lastPosition.getX(), 0):new Coordinates(lastPosition.getX(), lastPosition.getY()+1);
			this.lastPosition = newPosition3;
			snake.add(newPosition3);
			break;
		default:
			break;	
		}
		snake.remove(0);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(new Color(252, 140, 3));
		g2d.fillRect(squareSize*food.getX(), squareSize*food.getY(), 40, 40);

		g2d.setColor(new Color(3, 78, 252));
		for (Coordinates cords : snake) {
			g2d.fillRect(squareSize*cords.getX(), squareSize*cords.getY(), 40, 40);
		}
	}
}
