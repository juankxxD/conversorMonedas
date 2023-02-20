package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton MenuMoneda = new JButton("Moneda");
		MenuMoneda.setBorderPainted(false);
		MenuMoneda.setForeground(Color.WHITE);
		MenuMoneda.setBackground(Color.BLACK);
		MenuMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuMoneda moneda = new MenuMoneda();
				moneda.setVisible(true);
				dispose();
			}
		});
		MenuMoneda.setBounds(92, 134, 96, 23);
		contentPane.add(MenuMoneda);
		
		JButton MenuTemperatura = new JButton("Temperatura");
		MenuTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuTemperatura temperatura = new MenuTemperatura();
				temperatura.setVisible(true);
				dispose();
			}
		});
		MenuTemperatura.setForeground(Color.WHITE);
		MenuTemperatura.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		MenuTemperatura.setBackground(Color.BLACK);
		MenuTemperatura.setBorderPainted(false);
		MenuTemperatura.setBounds(238, 134, 110, 23);
		contentPane.add(MenuTemperatura);
		
		JLabel lblNewLabel = new JLabel("Escoge que deseas convertir");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(92, 84, 256, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CONVERTIDOR JP");
		lblNewLabel_1.setBackground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Leelawadee UI", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 49, 414, 29);
		contentPane.add(lblNewLabel_1);
	}
}
