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

public class ConversorMoneda {
	private Moneda from;
	private Moneda to;
	
	public ConversorMoneda(Moneda from, Moneda to) {
		super();
		this.from = from;
		this.to = to;
	}
	
	public double sacarDivisa() throws IOException {
		double response = 0;
			Properties propiedades = new Properties();
			InputStream entrada = new FileInputStream("datos.properties");
			propiedades.load(entrada);
			URL url = new URL("https://api.apilayer.com/fixer/convert?to=" + to.getNombre() + "&from=" + from.getNombre() + "&amount=1");
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
		return response;
	}
	
	public double convert(double divisa) {
		return (from.getCantidad() * divisa);
	}

	public Moneda getFrom() {
		return from;
	}

	public void setFrom(Moneda from) {
		this.from = from;
	}

	public Moneda getTo() {
		return to;
	}

	public void setTo(Moneda to) {
		this.to = to;
	}
	
	
	
}
