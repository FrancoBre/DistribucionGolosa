package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import logica.Algoritmos;
import logica.Coordenada;

public class HaversineTest {

	@Test
	public void distanciaEntreTest() {
		assertEquals(120.41, Algoritmos.calcularDistancia(ushuaia(), rioGrande()), 100);
	}

	public Coordenada ushuaia() {
		return new Coordenada(-54.807222, -68.304444);
	}
	
	public Coordenada rioGrande() {
		return new Coordenada(-53.783333, -67.7);
	}
}
