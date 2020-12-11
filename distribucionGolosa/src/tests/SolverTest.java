package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logica.Algoritmos;
import logica.CentroDistribucion;
import logica.Cliente;
import logica.ComparadorPorConveniencia;
import logica.ComparadorPorDistPromedio;
import logica.Coordenada;
import logica.Instancia;
import logica.SolverGoloso;
import logica.SolverExacto;

public class SolverTest {

	@Test(expected = RuntimeException.class)
	public void centrosNoValoradosTest() {
		Instancia instancia = ejemplo(5);
		SolverGoloso solver = new SolverGoloso(instancia, new ComparadorPorDistPromedio());
		solver.resolver();
	}
	
	@Test
	public void centrosOrdenadosDistPromedioTest() {	
		Instancia instancia = ejemplo(5);
		SolverGoloso solver = new SolverGoloso(instancia, new ComparadorPorDistPromedio());
		
		Algoritmos.valorarCentrosDistPromedio(instancia);	// Esto debe hacerse en la clase aplicacion
		
		assertEquals(new Coordenada(-34.63524, -58.7641), solver.centrosOrdenados().get(0).getCoordenada());
		assertEquals(new Coordenada(-34.60967, -58.78195), solver.centrosOrdenados().get(1).getCoordenada());
		assertEquals(new Coordenada(-34.65119, -58.78985), solver.centrosOrdenados().get(2).getCoordenada());
		assertEquals(new Coordenada(-34.58664, -58.76084), solver.centrosOrdenados().get(3).getCoordenada());
		assertEquals(new Coordenada(-34.62606, -58.70745), solver.centrosOrdenados().get(4).getCoordenada());
	}
	
	@Test
	public void centrosOrdenadosPorConvenienciaTest() {
		Instancia instancia = ejemplo(5);
		SolverGoloso solver = new SolverGoloso(instancia, new ComparadorPorConveniencia(instancia));
		
		assertEquals(new Coordenada(-34.63524, -58.7641), solver.centrosOrdenados().get(0).getCoordenada());
		assertEquals(new Coordenada(-34.60967, -58.78195), solver.centrosOrdenados().get(1).getCoordenada());
		assertEquals(new Coordenada(-34.65119, -58.78985), solver.centrosOrdenados().get(2).getCoordenada());
		assertEquals(new Coordenada(-34.58664, -58.76084), solver.centrosOrdenados().get(3).getCoordenada());
		assertEquals(new Coordenada(-34.62606, -58.70745), solver.centrosOrdenados().get(4).getCoordenada());
	}
	
	@Test(expected = RuntimeException.class)
	public void solucionVaciaTest() {
		Instancia instancia = ejemplo(5);
		SolverExacto solver = new SolverExacto(instancia);
		
		solver.getSolucion();
	}
	
	@Test
	public void centrosOrdenadosExactoTest() {
		Instancia instancia = ejemplo(5);
		SolverExacto solver = new SolverExacto(instancia);
		
		solver.resolver();
		ArrayList<CentroDistribucion> centrosOrdenados = solver.getSolucion().getCentrosElegidos();
		
		assertEquals(new Coordenada(-34.63524, -58.7641), centrosOrdenados.get(0).getCoordenada());
		assertEquals(new Coordenada(-34.60967, -58.78195), centrosOrdenados.get(1).getCoordenada());
		assertEquals(new Coordenada(-34.65119, -58.78985), centrosOrdenados.get(2).getCoordenada());
		assertEquals(new Coordenada(-34.58664, -58.76084), centrosOrdenados.get(3).getCoordenada());
		assertEquals(new Coordenada(-34.62606, -58.70745), centrosOrdenados.get(4).getCoordenada());
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
