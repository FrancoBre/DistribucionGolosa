package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logica.Algoritmos;
import logica.CentroDistribucion;
import logica.Cliente;
import logica.Coordenada;
import logica.Instancia;

public class AlgoritmosTest {

	@Test
	public void distanciaEntreTest() {
		assertEquals(120.41, Algoritmos.calcularDistancia(ushuaia(), rioGrande()), 100);
	}
	
	@Test
	public void valorarCentroDistPromedioTest() {
		Instancia instancia = new Instancia(clientesEjemplo(), centrosEjemplo());
		Algoritmos.valorarCentrosDistPromedio(instancia);
		
		assertEquals(28269, instancia.getCentros().get(0).getDistanciaPromedio());
		assertEquals(42135, instancia.getCentros().get(1).getDistanciaPromedio());
		assertEquals(13618, instancia.getCentros().get(2).getDistanciaPromedio());
	}
	
	@Test
	public void centroMasCercanoTest1() {
		Instancia instancia = new Instancia(clientesEjemplo(), centrosEjemplo());
		
		Coordenada coor1 = new Coordenada(43.645074, -115.993081);
		Cliente cliente = new Cliente(coor1);
		
		Coordenada coor2 = new Coordenada(41.303921, -81.901693);
		CentroDistribucion centro = new CentroDistribucion(coor2);
		
		assertEquals(centro, Algoritmos.centroMasCercano(cliente, instancia));
	}
	
	@Test
	public void centroMasCercanoTest2() {
		Instancia instancia = ejemplo(5);
		
		Coordenada coor1 = new Coordenada(-34.60707, -58.79473);
		Cliente cliente = new Cliente(coor1);
		
		Coordenada coor2 = new Coordenada(-34.60967, -58.78195);
		CentroDistribucion centro = new CentroDistribucion(coor2);
		
		assertEquals(centro, Algoritmos.centroMasCercano(cliente, instancia));
	}
	
	@Test
	public void cantCentrosQueLesConvieneTest1() {
		Instancia instancia = ejemplo(5);
		
		Coordenada coor2 = new Coordenada(-34.60967, -58.78195);
		CentroDistribucion centro2 = new CentroDistribucion(coor2, "Centro 2");
		
		assertEquals(3, Algoritmos.cantCentrosQueLesConviene(centro2, instancia));
	}
	
	@Test
	public void cantCentrosQueLesConvieneTest2() {
		Instancia instancia = ejemplo(5);
		
		Coordenada coor3 = new Coordenada(-34.63524, -58.7641);
		CentroDistribucion centro3 = new CentroDistribucion(coor3, "Centro 3");
		
		assertEquals(3, Algoritmos.cantCentrosQueLesConviene(centro3, instancia));
	}

	public Coordenada ushuaia() {
		return new Coordenada(-54.807222, -68.304444);
	}
	
	public Coordenada rioGrande() {
		return new Coordenada(-53.783333, -67.7);
	}
	
	public ArrayList<Cliente> clientesEjemplo() {
		ArrayList<Cliente> ret = new ArrayList<Cliente>();
		
		Coordenada guitarra = new Coordenada(-33.867886, -63.987);
		Cliente cliente1 = new Cliente(guitarra, "Guitarra");
		ret.add(cliente1);
		
		Coordenada puntoDeMira = new Coordenada(-33.867886, -63.987);
		Cliente cliente2 = new Cliente(puntoDeMira, "Punto de Mira");
		ret.add(cliente2);
		
		Coordenada piletaGigante = new Coordenada(-33.350534, -71.653268);
		Cliente cliente3 = new Cliente(piletaGigante, "Pileta Gigante");
		ret.add(cliente3);
		
		Coordenada jesusTeAma = new Coordenada(43.645074, -115.993081);
		Cliente cliente4 = new Cliente(jesusTeAma, "Jesus Te Ama");
		ret.add(cliente4);
		
		return ret;
	}
	
	public ArrayList<CentroDistribucion> centrosEjemplo() {
		ArrayList<CentroDistribucion> ret = new ArrayList<CentroDistribucion>();
		
		Coordenada corazon = new Coordenada(41.303921, -81.901693);
		CentroDistribucion centro1 = new CentroDistribucion(corazon, "Corazon");
		ret.add(centro1);
		
		Coordenada elReyLeon = new Coordenada(51.848637, -0.55462);
		CentroDistribucion centro2 = new CentroDistribucion(elReyLeon, "El Rey Leon");
		ret.add(centro2);
		
		Coordenada cocaCola = new Coordenada(-18.529211, -70.249941);
		CentroDistribucion centro3 = new CentroDistribucion(cocaCola, "Coca Cola");
		ret.add(centro3);

		return ret;
	}
	
	public Instancia ejemplo(int k) {
		ArrayList<CentroDistribucion> centros = new ArrayList<CentroDistribucion>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		Coordenada cd1 = new Coordenada(-34.58664, -58.76084);
		CentroDistribucion centro1 = new CentroDistribucion(cd1, "Centro 1");
		centros.add(centro1);

		Coordenada cd2 = new Coordenada(-34.60967, -58.78195);
		CentroDistribucion centro2 = new CentroDistribucion(cd2, "Centro 2");
		centros.add(centro2);
		
		Coordenada cd3 = new Coordenada(-34.63524, -58.7641);
		CentroDistribucion centro3 = new CentroDistribucion(cd3, "Centro 2");
		centros.add(centro3);
		
		Coordenada cd4 = new Coordenada(-34.65119, -58.78985);
		CentroDistribucion centro4 = new CentroDistribucion(cd4, "Centro 4");
		centros.add(centro4);
		
		Coordenada cd5 = new Coordenada(-34.62606, -58.70745);
		CentroDistribucion centro5 = new CentroDistribucion(cd5, "Centro 5");
		centros.add(centro5);
		
		Coordenada c1 = new Coordenada(-34.6003, -58.75266);
		Cliente cliente1 = new Cliente(c1, "Cliente 1");
		clientes.add(cliente1);		
	
		Coordenada c2 = new Coordenada(-34.6583, -58.78491);
		Cliente cliente2 = new Cliente(c2, "Cliente 2");
		clientes.add(cliente2);
		
		Coordenada c3 = new Coordenada(-34.63947, -58.77529);
		Cliente cliente3 = new Cliente(c3, "Cliente 3");
		clientes.add(cliente3);
		
		Coordenada c4 = new Coordenada(-34.64022, -58.80558);
		Cliente cliente4 = new Cliente(c4, "Cliente 4");
		clientes.add(cliente4);
		
		Coordenada c5 = new Coordenada(-34.65492, -58.76152);
		Cliente cliente5 = new Cliente(c5, "Cliente 5");
		clientes.add(cliente5);
		
		Coordenada c6 = new Coordenada(-34.60334, -58.73787);
		Cliente cliente6 = new Cliente(c6, "Cliente 6");
		clientes.add(cliente6);
		
		Coordenada c7 = new Coordenada(-34.59961, -58.77621);
		Cliente cliente7 = new Cliente(c7, "Cliente 7");
		clientes.add(cliente7);
		
		Coordenada c8 = new Coordenada(-34.60707, -58.79473);
		Cliente cliente8 = new Cliente(c8, "Cliente 8");
		clientes.add(cliente8);
		
		Coordenada c9 = new Coordenada(-34.62402, -58.74066);
		Cliente cliente9 = new Cliente(c9, "Cliente 9");
		clientes.add(cliente9);
		
		Coordenada c10 = new Coordenada(-34.62125, -58.77766);
		Cliente cliente10 = new Cliente(c10, "Cliente 10");
		clientes.add(cliente10);
		
		return new Instancia(clientes, centros, k);
	}
}
