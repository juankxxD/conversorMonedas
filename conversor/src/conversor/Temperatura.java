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

public class Temperatura {

	private String nombre;
	private double cantidad;

	public Temperatura(String nombre, double cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public Temperatura(String nombre) {
		this.nombre = nombre;
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
