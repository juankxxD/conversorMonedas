package conversor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.json.JSONObject;

public class ConversorTemperatura {
	private Temperatura from;
	private Temperatura to;
	
	public ConversorTemperatura(Temperatura from, Temperatura to) {
		super();
		this.from = from;
		this.to = to;
	}
	
	public double convert() {
		double temperaturaConvert = 0.0;
		switch (from.getNombre()) {
		case "C":
			if (to.getNombre().equals("F")) {
				temperaturaConvert = (1.8 * from.getCantidad()) + 32;
			} else temperaturaConvert = from.getCantidad() + 273;
			break;
		case "F":
			if (to.getNombre().equals("C")) {
				temperaturaConvert = (from.getCantidad() - 32) / 1.8;
			} else temperaturaConvert = (5/9 * (from.getCantidad() - 32)) + 273.15;
			break;
		case "K":
			if (to.getNombre().equals("C")) {
				temperaturaConvert = from.getCantidad() - 273;
			} else temperaturaConvert = (1.8 * (from.getCantidad() - 273.15)) + 32;
			break;
		default:
			break;
		}
		return temperaturaConvert;
	}

	public Temperatura getFrom() {
		return from;
	}

	public void setFrom(Temperatura from) {
		this.from = from;
	}

	public Temperatura getTo() {
		return to;
	}

	public void setTo(Temperatura to) {
		this.to = to;
	}
	
	
	
}
