package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logica.CentroDistribucion;
import logica.Cliente;
import logica.Coordenada;
import logica.Instancia;
import logica.Solucion;

public class SolucionTest {

	@Test
	public void agregarElementosTest() {
		Solucion solucion = solucion();
		
		Coordenada cd1 = new Coordenada(-34.58664, -58.76084);
		CentroDistribucion centro1 = new CentroDistribucion(cd1, "Centro 1");
		
		assertTrue(solucion.getCentrosElegidos().contains(centro1));
	}
	
	@Test
	public void quitarElementosTest() {
		Solucion solucion = solucion();
		
		Coordenada cd1 = new Coordenada(-34.58664, -58.76084);
		CentroDistribucion centro1 = new CentroDistribucion(cd1, "Centro 1");
		
		solucion.quitarElementos(centro1);
		assertFalse(solucion.getCentrosElegidos().contains(centro1));
	}
	
	@Test
	public void mejorSolucionVaciaTest() {
		Solucion solucion1 = solucion();
		Solucion solucion2 = new Solucion();
		
		assertTrue(Solucion.esMejorSolucion(solucion1, solucion2, instancia(5)));
	}
	
	@Test
	public void costoSolucionTest1() {
		ArrayList<CentroDistribucion> centros = new ArrayList<CentroDistribucion>();
			
		Coordenada cd5 = new Coordenada(-34.62606, -58.70745);
		CentroDistribucion centro5 = new CentroDistribucion(cd5, "Centro 5");
			
		Coordenada cd1 = new Coordenada(-34.58664, -58.76084);
		CentroDistribucion centro1 = new CentroDistribucion(cd1, "Centro 1");
			
		centros.add(centro5);
		centros.add(centro1);
		Solucion solucion = new Solucion(centros);
			
		Instancia instancia = instancia(1);
			
		assertEquals(101, Solucion.costoSolucion(solucion, instancia), 10e-3);
	}
	
	@Test
	public void costoSolucionTest2() {
		ArrayList<CentroDistribucion> centros1 = new ArrayList<CentroDistribucion>();
		
		Coordenada cd2 = new Coordenada(-34.60967, -58.78195);
		CentroDistribucion centro2 = new CentroDistribucion(cd2, "Centro 2");
		
		Coordenada cd3 = new Coordenada(-34.63524, -58.7641);
		CentroDistribucion centro3 = new CentroDistribucion(cd3, "Centro 2");
		
		centros1.add(centro2);
		centros1.add(centro3);
		Solucion solucion1 = new Solucion(centros1);
		
		Instancia instancia = instancia(1);
		
		assertEquals(58, Solucion.costoSolucion(solucion1, instancia), 10e-3);
	}
	
	@Test
	public void mejorSolucionTest() {
		ArrayList<CentroDistribucion> centros1 = new ArrayList<CentroDistribucion>();
		ArrayList<CentroDistribucion> centros2 = new ArrayList<CentroDistribucion>();
		
		Coordenada cd1 = new Coordenada(-34.58664, -58.76084);
		CentroDistribucion centro1 = new CentroDistribucion(cd1, "Centro 1");

		Coordenada cd2 = new Coordenada(-34.60967, -58.78195);
		CentroDistribucion centro2 = new CentroDistribucion(cd2, "Centro 2");
		
		Coordenada cd3 = new Coordenada(-34.63524, -58.7641);
		CentroDistribucion centro3 = new CentroDistribucion(cd3, "Centro 2");
		
		Coordenada cd5 = new Coordenada(-34.62606, -58.70745);
		CentroDistribucion centro5 = new CentroDistribucion(cd5, "Centro 5");

		centros1.add(centro2);
		centros1.add(centro3);
		Solucion solucion1 = new Solucion(centros1);
		
		centros2.add(centro5);
		centros2.add(centro1);
		Solucion solucion2 = new Solucion(centros2);
		
		Instancia instancia = instancia(2);
		
		assertTrue(Solucion.esMejorSolucion(solucion1, solucion2, instancia));
		
	}

	public Solucion solucion() {
		Solucion ret = new Solucion();
		
		Coordenada cd1 = new Coordenada(-34.58664, -58.76084);
		CentroDistribucion centro1 = new CentroDistribucion(cd1, "Centro 1");
		ret.aniadirElementos(centro1);
		
		return ret;
	}
	
	public Instancia instancia(int k) {
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
		
		Coordenada c7 = new Coordenada(-34.59633, -58.7745);
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
