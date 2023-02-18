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
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuMoneda extends JFrame {
	private String[] optionsMoneda  = {"Peso Colombiano", "Dolar", "Euros", "Libras Esterlinas", "Yen Japonés", "Won sul-coreano"};
	private JPanel contentPane;
	private JTextField Valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMoneda frame = new MenuMoneda();
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
	public MenuMoneda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cuantos");
		lblNewLabel.setFont(new Font("Ebrima", Font.PLAIN, 12));
		lblNewLabel.setBounds(155, 49, 72, 20);
		contentPane.add(lblNewLabel);
		
		JComboBox Moneda2 = new JComboBox();
		Moneda2.setBounds(332, 70, 122, 22);
		contentPane.add(Moneda2);
		Moneda2.addItem("--");
		
		
		
		JComboBox Moneda1 = new JComboBox();
		for (int i = 0; i<optionsMoneda.length; i++) {
			Moneda1.addItem(optionsMoneda[i]);
			Moneda2.addItem(optionsMoneda[i]);
		}
		
		
		Moneda1.setBounds(10, 70, 122, 22);
		contentPane.add(Moneda1);
		
		Valor = new JTextField();
		Valor.setBounds(142, 71, 86, 20);
		contentPane.add(Valor);
		Valor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("convertir a");
		lblNewLabel_1.setFont(new Font("Ebrima", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(245, 74, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel MonedaRespuesta = new JLabel("");
		MonedaRespuesta.setBounds(142, 135, 250, 14);
		contentPane.add(MonedaRespuesta);
		
		JButton btnConvert = new JButton("Convertir");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Valor.getText().length() == 0) {
					MonedaRespuesta.setText("Debe colocar el valor a convertir");
					MonedaRespuesta.setForeground(Color.red);
				} else {
					MonedaRespuesta.setText(Valor.getText());
					MonedaRespuesta.setForeground(Color.black);
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
		
		Moneda2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Moneda2.getSelectedItem() == "--") {
					btnConvert.setEnabled(false);
				} else if(Moneda2.getSelectedItem() == Moneda1.getSelectedItem() ) {
					btnConvert.setEnabled(false);
					MonedaRespuesta.setText("Debe escoger tipos de monedas diferentes");
					MonedaRespuesta.setForeground(Color.red);
				} else {
					btnConvert.setEnabled(true);
				}
			}
		});
	}
}
