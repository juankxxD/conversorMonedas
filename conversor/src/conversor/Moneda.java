package conversor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

import org.json.JSONObject;

public class Moneda {

	private String nombre;
	private double cantidad;

	public Moneda(String nombre, double cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public void sacarDivisa(String moneda2) {
		try {
			Properties propiedades = new Properties();
			InputStream entrada = new FileInputStream("datos.properties");
			propiedades.load(entrada);
			System.out.println(propiedades.getProperty("API_KEY"));
			URL url = new URL("https://api.apilayer.com/fixer/convert?to=" + nombre + "&from=" + moneda2 + "&amount=1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("apikey", propiedades.getProperty("API_KEY"));
			conn.connect();
			int codeResponse = conn.getResponseCode();
			System.out.println(codeResponse);
			if (codeResponse != 200) {
				throw new RuntimeException("Ocurrio un error " + codeResponse);
			} else {
				System.out.println("Entre aqui");
				BufferedReader br = null;
				System.out.println(conn.getInputStream());
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String myJson = "";
				String currentValue = "";
				while ((currentValue = br.readLine()) != null) {
					System.out.println(currentValue);
					myJson += currentValue;
				}
				br.close();
				JSONObject obj = new JSONObject(myJson);
				Double response = obj.getJSONObject("info").getDouble("rate");

				System.out.println(response);

			}
			System.out.println(codeResponse);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
