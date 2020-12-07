package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
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
	public void valorarCentroTest() {
		ArrayList<CentroDistribucion> centros = new ArrayList<CentroDistribucion>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		Coordenada guitarra = new Coordenada(-33.867886, -63.987);
		Cliente cliente1 = new Cliente(guitarra, "Guitarra");
		clientes.add(cliente1);
		
		Coordenada corazon = new Coordenada(41.303921, -81.901693);
		CentroDistribucion centro1 = new CentroDistribucion(corazon, "Corazon");
		centros.add(centro1);
		
		Coordenada puntoDeMira = new Coordenada(-33.867886, -63.987);
		Cliente cliente2 = new Cliente(puntoDeMira, "Punto de Mira");
		clientes.add(cliente2);
		
		Coordenada piletaGigante = new Coordenada(-33.350534, -71.653268);
		Cliente cliente3 = new Cliente(piletaGigante, "Pileta Gigante");
		clientes.add(cliente3);
		
		Coordenada jesusTeAma = new Coordenada(43.645074, -115.993081);
		Cliente cliente4 = new Cliente(jesusTeAma, "Jesus Te Ama");
		clientes.add(cliente4);
		
		Coordenada elReyLeon = new Coordenada(51.848637, -0.55462);
		CentroDistribucion centro2 = new CentroDistribucion(elReyLeon, "El Rey Leon");
		centros.add(centro2);
		
		Coordenada illuminati = new Coordenada(37.629562, -116.849556);
		Cliente cliente5 = new Cliente(illuminati, "Illuminati");
		clientes.add(cliente5);
		
		Coordenada cocaCola = new Coordenada(-18.529211, -70.249941);
		CentroDistribucion centro3 = new CentroDistribucion(cocaCola, "Coca Cola");
		centros.add(centro3);

		/* ########################################################### */
				
		Instancia instancia = new Instancia(clientes, centros);
		Algoritmos.valorarCentros(instancia);
		
		assertEquals(31276, centro1.getDistanciaPromedio());
		assertEquals(50444, centro2.getDistanciaPromedio());
		assertEquals(21537, centro3.getDistanciaPromedio());
	}

	public Coordenada ushuaia() {
		return new Coordenada(-54.807222, -68.304444);
	}
	
	public Coordenada rioGrande() {
		return new Coordenada(-53.783333, -67.7);
	}
}
