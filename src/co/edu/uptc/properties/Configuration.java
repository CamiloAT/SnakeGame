package co.edu.uptc.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private Properties properties;
	private String easyTime;
	private String easyFood;
	private String easyObstacule;
	private String easyIncrease;
	private String easySize;
	private String mediumTime;
	private String mediumFood;
	private String mediumObstacule;
	private String mediumIncrease;
	private String mediumSize;
	private String difficultTime;
	private String difficultFood;
	private String difficultObstacule;
	private String difficultIncrease;
	private String difficultSize;

	public Configuration() {
		properties = new Properties();
		this.readFile();
	}

	private void readFile() {
		try {
			FileInputStream archivoDePropiedades = new FileInputStream("Files/Config.txt");
			properties.load(archivoDePropiedades);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		easyTime=properties.getProperty("easy.time");
		easyFood=properties.getProperty("easy.food");
		easyObstacule=properties.getProperty("easy.obstacule");
		easyIncrease=properties.getProperty("easy.increase");
		easySize=properties.getProperty("easy.size");
		
		mediumTime=properties.getProperty("medium.time");
		mediumFood=properties.getProperty("medium.food");
		mediumObstacule=properties.getProperty("medium.obstacule");
		mediumIncrease=properties.getProperty("medium.increase");
		mediumSize=properties.getProperty("medium.size");
		
		difficultTime=properties.getProperty("difficult.time");
		difficultFood=properties.getProperty("difficult.food");
		difficultObstacule=properties.getProperty("difficult.obstacule");
		difficultIncrease=properties.getProperty("difficult.increase");
		difficultSize=properties.getProperty("difficult.size");
	}

	public String getEasyTime() {
		return easyTime;
	}

	public String getEasyFood() {
		return easyFood;
	}

	public String getEasyObstacule() {
		return easyObstacule;
	}

	public String getEasyIncrease() {
		return easyIncrease;
	}

	public String getEasySize() {
		return easySize;
	}

	public String getMediumTime() {
		return mediumTime;
	}

	public String getMediumFood() {
		return mediumFood;
	}

	public String getMediumObstacule() {
		return mediumObstacule;
	}

	public String getMediumIncrease() {
		return mediumIncrease;
	}

	public String getMediumSize() {
		return mediumSize;
	}

	public String getDifficultTime() {
		return difficultTime;
	}

	public String getDifficultFood() {
		return difficultFood;
	}
	public String getDifficultObstacule() {
		return difficultObstacule;
	}

	public String getDifficultIncrease() {
		return difficultIncrease;
	}

	public String getDifficultSize() {
		return difficultSize;
	}
}
