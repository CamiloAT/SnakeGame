package co.edu.uptc.persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import co.edu.uptc.model.Historial;

public class JsonPersistence {

	private Historial historial;
	
	public JsonPersistence() throws JsonParseException, IOException {
		historial = new Historial();
		this.readJson();;
	}
	
	public void readJson() throws JsonParseException, IOException {
		JsonReader reader = new Gson().newJsonReader(new FileReader("Files/Data.JSON"));
		this.historial = new Gson().fromJson(reader, Historial.class);
	}

	public void writeJson(Historial historial) throws FileNotFoundException {
			Gson prettyGson= new GsonBuilder().setPrettyPrinting().create();
			String json = prettyGson.toJson(this.historial);
			PrintWriter print = new PrintWriter("Files/Data.JSON");
			print.write(json);
			print.close();
	}

	public Historial getHistorial() {
		return historial;
	}
}
