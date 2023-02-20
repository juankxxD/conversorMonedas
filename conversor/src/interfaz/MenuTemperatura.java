package interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import conversor.ConversorMoneda;
import conversor.ConversorTemperatura;
import conversor.Moneda;
import conversor.Temperatura;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class MenuTemperatura extends JFrame {
	private String[] optionsTemperatura = { "Fahrenheit - F", "Celsius - C", "Kelvin - K"};
	private JPanel contentPane;
	private JTextField Valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuTemperatura frame = new MenuTemperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuTemperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Grados");
		lblNewLabel.setFont(new Font("Ebrima", Font.PLAIN, 12));
		lblNewLabel.setBounds(155, 49, 72, 20);
		contentPane.add(lblNewLabel);

		JComboBox Temperatura2 = new JComboBox();
		Temperatura2.setBounds(332, 70, 122, 22);
		contentPane.add(Temperatura2);
		Temperatura2.addItem("--");

		JComboBox Temperatura1 = new JComboBox();
		for (int i = 0; i < optionsTemperatura.length; i++) {
			Temperatura1.addItem(optionsTemperatura[i]);
			Temperatura2.addItem(optionsTemperatura[i]);
		}

		Temperatura1.setBounds(10, 70, 122, 22);
		contentPane.add(Temperatura1);

		Valor = new JTextField();
		Valor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') && (caracter != '.')) {
					e.consume(); // ignorar el evento de teclado
				}
			}
		});
		Valor.setBounds(142, 71, 86, 20);
		contentPane.add(Valor);
		Valor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("convertir a");
		lblNewLabel_1.setFont(new Font("Ebrima", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(245, 74, 66, 14);
		contentPane.add(lblNewLabel_1);

		JLabel TemperaturaRespuesta = new JLabel("");
		TemperaturaRespuesta.setBounds(126, 135, 270, 23);
		contentPane.add(TemperaturaRespuesta);

		JButton btnConvert = new JButton("Convertir");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Valor.getText().length() == 0) {
					TemperaturaRespuesta.setText("Debe colocar el valor a convertir");
					TemperaturaRespuesta.setForeground(Color.red);
				} else {
					try {
						String tipoTemperatura1 = Temperatura1.getSelectedItem().toString().split("-")[1].trim();
						String tipoTemperatura2 = Temperatura2.getSelectedItem().toString().split("-")[1].trim();
						Temperatura temperaturaDe = new Temperatura(tipoTemperatura1, Double.parseDouble(Valor.getText()));
						Temperatura temperaturaHasta = new Temperatura(tipoTemperatura2);
						ConversorTemperatura conversor = new ConversorTemperatura(temperaturaDe, temperaturaHasta);
						DecimalFormat formato2 = new DecimalFormat("#.##");
						TemperaturaRespuesta.setText("La equivalencia de " + tipoTemperatura1 +" a " + tipoTemperatura2 + " es: " +formato2.format(conversor.convert()));
						TemperaturaRespuesta.setForeground(Color.black);
					} catch (Exception ex) {
						TemperaturaRespuesta.setText("Ha ocurrido un error, contacte al desarrollador!!");
						TemperaturaRespuesta.setForeground(Color.red);
						ex.printStackTrace();
					}
				}

			}
		});
		btnConvert.setEnabled(false);
		btnConvert.setBounds(27, 135, 89, 23);
		contentPane.add(btnConvert);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("CONVERTIDOR DE MONEDAS");
		lblNewJgoodiesTitle.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 14));
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setBounds(0, 11, 520, 14);
		contentPane.add(lblNewJgoodiesTitle);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menuMain = new Menu();
				menuMain.setVisible(true);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Ebrima", Font.PLAIN, 12));
		btnVolver.setBounds(410, 135, 89, 23);
		contentPane.add(btnVolver);

		Temperatura2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Temperatura2.getSelectedItem() == "--") {
					btnConvert.setEnabled(false);
					TemperaturaRespuesta.setText("");
				} else if (Temperatura2.getSelectedItem() == Temperatura1.getSelectedItem()) {
					btnConvert.setEnabled(false);
					TemperaturaRespuesta.setText("Debe escoger tipos de Temperaturas diferentes");
					TemperaturaRespuesta.setForeground(Color.red);
				} else {
					TemperaturaRespuesta.setText("");
					btnConvert.setEnabled(true);
				}
			}
		});
	}
}
