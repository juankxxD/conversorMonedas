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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton MenuMoneda = new JButton("Moneda");
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
		MenuTemperatura.setBounds(238, 134, 110, 23);
		contentPane.add(MenuTemperatura);
		
		JLabel lblNewLabel = new JLabel("Escoge que deseas convertir");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(92, 84, 256, 23);
		contentPane.add(lblNewLabel);
	}
}
