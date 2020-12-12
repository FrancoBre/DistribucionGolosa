package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import logica.Cliente;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;


public class Interfaz {

	private JFrame frame;
	private JPanel map; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 619, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Leer clientes");
		//Action leer Clientes
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(10, 58, 175, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Leer posibles distribuidoras");
		//Action leer Distribuidoras
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(10, 92, 175, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Solución 1");
		//Action Solución 1
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(10, 126, 175, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Distribuci\u00F3n Golosa");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblNewLabel.setToolTipText("Distribuci\u00F3n Golosa");
		lblNewLabel.setBounds(10, 11, 182, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2_1 = new JButton("Soluci\u00F3n 2");
		//Action Solución 2
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2_1.setBounds(10, 159, 175, 29);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Soluci\u00F3n 3");
		//Action Solución 2
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2_1_1.setBounds(10, 194, 175, 29);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		JPanel Map = new JPanel();
		Map.setBounds(205, 11, 305, 214);
		frame.getContentPane().add(Map);
		
		map = new JMapViewer();
		((JMapViewer) map).setZoomContolsVisible(true);
		Coordinate coordinate = new Coordinate(-34.521, -58.7008);
		((JMapViewer) map).setDisplayPosition(coordinate, 15);
		
		Map.add(map);

	}
}
