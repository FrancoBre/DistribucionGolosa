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
	public void centroMasCercanoTest() {
		Instancia instancia = new Instancia(clientesEjemplo(), centrosEjemplo());
		
		Coordenada coor1 = new Coordenada(43.645074, -115.993081);
		Cliente cliente = new Cliente(coor1);
		
		Coordenada coor2 = new Coordenada(41.303921, -81.901693);
		CentroDistribucion centro = new CentroDistribucion(coor2);
		
		assertEquals(centro, Algoritmos.centroMasCercano(cliente, instancia));
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
}
