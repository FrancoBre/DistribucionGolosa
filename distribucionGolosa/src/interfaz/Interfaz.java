package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import logica.CentroDistribucion;
import logica.Cliente;
import logica.Solucion;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;


public class Interfaz {

	private JFrame frame;
	private JButton btnLeerClientes;
	private JButton btnLeerPosiblesDistribuidoras;
	private JButton btnsol1; 
	private JButton btnsol2; 
	private JButton btnsol3;
	private JMapViewer mapa;

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
		frame.setBounds(100, 100, 619, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		leerClientes();
		leerPosiblesDistribuidoras();
		mostrarSolucion1();
		mostrarSolucion2();	
		mostrarSolucion3();
	
		//Creacion de panel para mapa 
		JPanel Map = new JPanel();	
		Map.setBounds(195, 11, 315, 338);
		frame.getContentPane().add(Map);
		
		mapa = new JMapViewer();
		((JMapViewer) mapa).setZoomContolsVisible(true);
		Coordinate coordinate = new Coordinate(-34.62125, -58.77766);
		((JMapViewer) mapa).setDisplayPosition(coordinate, 12);
		Map.add(mapa);
		
	}

	
	private void leerClientes() {
		btnLeerClientes = new JButton("Leer clientes");
		//Action leer Clientes
		btnLeerClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Cliente> cliente= new ArrayList<Cliente>(); 
				cliente=Aplicacion.leerClientes(); 
				agregarMarcadoresClientes(cliente, Color.RED);
			}
		});
		btnLeerClientes.setBounds(10, 80, 175, 29);
		frame.getContentPane().add(btnLeerClientes);
		
		
	}
	
	private void leerPosiblesDistribuidoras() {
		btnLeerPosiblesDistribuidoras = new JButton("Leer posibles distribuidoras");
		//Action leer Distribuidoras
		btnLeerPosiblesDistribuidoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<CentroDistribucion> centros= new ArrayList<CentroDistribucion>(); 
				centros=Aplicacion.leerCentros(); 
				agregarMarcadoresCentros(centros, Color.BLUE);
			}
		});
		btnLeerPosiblesDistribuidoras.setBounds(10, 125, 175, 29);
		frame.getContentPane().add(btnLeerPosiblesDistribuidoras);
	}
	
	private void mostrarSolucion3() {
		btnsol3 = new JButton("Solución 3");
		btnsol3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Solucion solucion= new Solucion(); 
				Aplicacion ap = new Aplicacion(); 
				solucion= ap.realizarAlgoritmoExacto();
				ArrayList<CentroDistribucion> centrosElegidos= new ArrayList<CentroDistribucion>(); 
				centrosElegidos = solucion.getCentrosElegidos(); 
				System.out.println(centrosElegidos.size());
				marcarCentrosElegidos(centrosElegidos,Color.ORANGE);
			}		
		});
		btnsol3.setBounds(10, 260, 175, 29);
		frame.getContentPane().add(btnsol3);
	}

	private void mostrarSolucion1() {
		btnsol1 = new JButton("Solución 1");
		//Action Solución 1
		btnsol1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Solucion solucion= new Solucion(); 
				Aplicacion ap = new Aplicacion(); 
				solucion= ap.realizarHeuristica1();
				ArrayList<CentroDistribucion> centrosElegidos= new ArrayList<CentroDistribucion>(); 
				centrosElegidos = solucion.getCentrosElegidos(); 
				marcarCentrosElegidos(centrosElegidos,Color.MAGENTA);
			}
		});
		btnsol1.setBounds(10, 170, 175, 29);
		frame.getContentPane().add(btnsol1);
	}
	private void mostrarSolucion2() {
		btnsol2 = new JButton("Soluci\u00F3n 2");
		//Action Solución 2
		btnsol2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Solucion solucion= new Solucion(); 
				Aplicacion ap = new Aplicacion(); 
				solucion = ap.realizarHeuristica2(); 
				ArrayList<CentroDistribucion> centrosElegidos= new ArrayList<CentroDistribucion>(); 
				centrosElegidos = solucion.getCentrosElegidos(); 
				marcarCentrosElegidos(centrosElegidos,Color.GREEN);	
			}
		});
		btnsol2.setBounds(10, 215, 175, 29);
		frame.getContentPane().add(btnsol2);
	}

	private void agregarMarcadoresCentros(ArrayList<CentroDistribucion> centros, Color color) {
		for (CentroDistribucion c: centros) {
			Coordinate coordenada= new Coordinate(c.getCoordenada().getLatitud(),c.getCoordenada().getLongitud()); 
			MapMarker marcador = new MapMarkerDot(c.getNombre(), coordenada);
			marcador.getStyle().setBackColor(color); 
			marcador.getStyle().setColor(color);
			mapa.addMapMarker(marcador);
		}
	}
	
	private void marcarCentrosElegidos(ArrayList<CentroDistribucion> centrosElegidos, Color color) {
		for (CentroDistribucion c: centrosElegidos) {
			System.out.println("el index es"+ centrosElegidos.size());
			Coordinate coordenada= new Coordinate(c.getCoordenada().getLatitud(),c.getCoordenada().getLongitud()); 
			MapMarker marcador = new MapMarkerDot(c.getNombre(), coordenada);
			marcador.getStyle().setBackColor(color); 
			marcador.getStyle().setColor(color);
			mapa.addMapMarker(marcador);
		}
	}
	
	private void agregarMarcadoresClientes(ArrayList<Cliente> cliente, Color color) {
		for (Cliente c: cliente) {
			Coordinate coordenada= new Coordinate(c.getCoordenada().getLatitud(),c.getCoordenada().getLongitud()); 
			MapMarker marcador = new MapMarkerDot(c.getNombre(), coordenada);
			marcador.getStyle().setBackColor(color); 
			marcador.getStyle().setColor(color);
			mapa.addMapMarker(marcador);
		}
	}
}