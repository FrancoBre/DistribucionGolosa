package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solver {
	Instancia instancia;
	/*
	public Solver(Instancia instancia, Comparator<CentroDistribucion> comparador) {
		this.instancia = instancia;
	}*/
	
	public Solver(Instancia instancia) {
		this.instancia = instancia;
	}
	
	public Solucion resolver() {
		Solucion ret = new Solucion();
		ArrayList<CentroDistribucion> centrosOrdenados = centrosOrdenados();
		
		for (int i = 0; i < this.instancia.getK(); i++) {
			ret.añadirElementos(centrosOrdenados.get(i));
		}
		
		return ret;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CentroDistribucion> centrosOrdenados() {
		ArrayList<CentroDistribucion> ret = this.instancia.getCentros();
		Collections.sort(ret);
		
		return ret;
	}
	
}
