package conversor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;

import org.json.JSONObject;

public class Moneda {

	private String nombre;
	private double cantidad;

	public Moneda(String nombre, double cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public double sacarDivisa(String moneda2) {
		double response = 0;
		try {
			Properties propiedades = new Properties();
			InputStream entrada = new FileInputStream("datos.properties");
			propiedades.load(entrada);
			URL url = new URL("https://api.apilayer.com/fixer/convert?to=" + moneda2 + "&from=" + nombre + "&amount=1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("apikey", propiedades.getProperty("API_KEY"));
			conn.connect();
			int codeResponse = conn.getResponseCode();
			if (codeResponse != 200) {
				throw new RuntimeException("Ocurrio un error " + codeResponse);
			} else {
				BufferedReader br = null;
				System.out.println(conn.getInputStream());
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String myJson = "";
				String currentValue = "";
				while ((currentValue = br.readLine()) != null) {
					myJson += currentValue;
				}
				br.close();
				JSONObject obj = new JSONObject(myJson);
				response = obj.getJSONObject("info").getDouble("rate");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}
	
	public double convert(double divisa) {
		return (cantidad * divisa);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

}
