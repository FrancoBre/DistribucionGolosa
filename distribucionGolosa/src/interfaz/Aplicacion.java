package interfaz;

import logica.ComparadorPorDistPromedio;
import logica.Instancia;
import logica.Solver;
import logica.Algoritmos;
import logica.ComparadorPorConveniencia;

public class Aplicacion {
	private Instancia instancia;

	public Aplicacion() {
		this.instancia = crearInstanciaConJSON();
	}

	private Instancia crearInstanciaConJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void realizarHeuristica1() {
		Solver solver = new Solver(this.instancia, new ComparadorPorDistPromedio());
		Algoritmos.valorarCentrosDistPromedio(instancia);
		solver.resolver();
	}
	
	public void realizarHeuristica2() {
		Solver solver = new Solver(this.instancia, new ComparadorPorConveniencia(this.instancia));
		solver.resolver();
	}
	
	public void realizarAlgoritmoExacto() {
		// TODO
	}
}
