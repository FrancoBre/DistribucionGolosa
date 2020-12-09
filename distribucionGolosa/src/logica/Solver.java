package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solver {
	Instancia instancia;
	Comparator<CentroDistribucion> comparador;
	
	public Solver(Instancia instancia, Comparator<CentroDistribucion> comparador) {
		this.instancia = instancia;
		this.comparador = comparador;
	}
	
	public Solucion resolver() {
		Solucion ret = new Solucion();
		ArrayList<CentroDistribucion> centrosOrdenados = centrosOrdenados();
		
		for (int i = 0; i < this.instancia.getK(); i++) {
			ret.aniadirElementos(centrosOrdenados.get(i));
		}
		
		return ret;
	}

	public ArrayList<CentroDistribucion> centrosOrdenados() {
		ArrayList<CentroDistribucion> ret = this.instancia.getCentros();
		Collections.sort(ret, comparador);
		
		return ret;
	}
}
