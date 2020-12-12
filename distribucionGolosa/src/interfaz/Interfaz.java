package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Button;

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
	private JButton btnLeerClientes;
	private JButton btnLeerPosiblesDistribuidoras;
	private JButton btnsol1; 
	private JButton btnsol2; 
	private JButton btnsol3; 
	
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
		
		leerClientes();
		leerPosiblesDistribuidoras();
		mostrarSolucion1();
		mostrarSolucion2();	
		
		JLabel lblNewLabel = new JLabel("Distribuci\u00F3n Golosa");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblNewLabel.setToolTipText("Distribuci\u00F3n Golosa");
		lblNewLabel.setBounds(10, 11, 182, 36);
		frame.getContentPane().add(lblNewLabel);
		
		//Creacion de panel para mapa 
		JPanel Map = new JPanel();
		Map.setBounds(205, 11, 305, 214);
		frame.getContentPane().add(Map);
		
		map = new JMapViewer();
		((JMapViewer) map).setZoomContolsVisible(true);
		Coordinate coordinate = new Coordinate(-34.521, -58.7008);
		((JMapViewer) map).setDisplayPosition(coordinate, 13);
		
		Map.add(map);

	}
	
	private void leerClientes() {
		btnLeerClientes = new JButton("Leer clientes");
		//Action leer Clientes
		btnLeerClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnLeerClientes.setBounds(10, 58, 175, 29);
		frame.getContentPane().add(btnLeerClientes);
	}
	
	private void leerPosiblesDistribuidoras() {
		btnLeerPosiblesDistribuidoras = new JButton("Leer posibles distribuidoras");
		//Action leer Distribuidoras
		btnLeerPosiblesDistribuidoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLeerPosiblesDistribuidoras.setBounds(10, 92, 175, 29);
		frame.getContentPane().add(btnLeerPosiblesDistribuidoras);
	}

	private void mostrarSolucion1() {
		btnsol1 = new JButton("Solución 1");
		//Action Solución 1
		btnsol1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnsol1.setBounds(10, 126, 175, 29);
		frame.getContentPane().add(btnsol1);
	}
	private void mostrarSolucion2() {
		btnsol2 = new JButton("Soluci\u00F3n 2");
		//Action Solución 2
		btnsol2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnsol2.setBounds(10, 159, 175, 29);
		frame.getContentPane().add(btnsol2);
	}
}