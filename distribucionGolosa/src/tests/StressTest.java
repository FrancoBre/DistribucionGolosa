package tests;

import java.util.ArrayList;

import logica.CentroDistribucion;
import logica.Cliente;
import logica.Coordenada;
import logica.Instancia;
import logica.SolverExacto;

public class StressTest {
	
	public static void main(String args[]) {
		for(int n=2; n<50; ++n)
		{
			long inicio = System.currentTimeMillis();
			
			SolverExacto solver = new SolverExacto(aleatorio(n));
			solver.resolver();
			
			long fin = System.currentTimeMillis();
			double tiempo = (fin - inicio) / 1000.0;
			
			System.out.println("n = " + n + ": " + tiempo + " seg.");
		}

	}
	
	// Genera una instancia con n centros de distribucion elegidos
	private static Instancia aleatorio(int n) {
		ArrayList<CentroDistribucion> centros = new ArrayList<CentroDistribucion>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		for(int i=0; i<n ; i++) {
			Coordenada coordenada = new Coordenada(Math.random(), Math.random());
			CentroDistribucion cd = new CentroDistribucion(coordenada, "Centro "+n);
			
			centros.add(cd);
		}
		
		for(int i=0; i<n+Math.random() ; i++) {
			Coordenada coordenada = new Coordenada(Math.random(), Math.random());
			Cliente c = new Cliente(coordenada, "Cliente "+n);
			
			clientes.add(c);
		}
		
		return new Instancia(clientes, centros);
	}
}
