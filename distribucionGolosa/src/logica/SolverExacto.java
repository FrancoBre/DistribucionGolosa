package logica;

import java.util.ArrayList;

public class SolverExacto {
	private Instancia instancia;
	private Solucion actual;
	private Solucion mejor; 
	
	public SolverExacto(Instancia instancia) {
		this.instancia = instancia;
	}

	@SuppressWarnings("unchecked")
	public Solucion resolver() {
		this.actual = new Solucion();
		this.mejor = new Solucion();
			
		generarSubconjuntos(0, (ArrayList<CentroDistribucion>) instancia.getCentros().clone());
			
		return mejor;
	}
	    
	public void generarSubconjuntos(int index, ArrayList<CentroDistribucion> centros) {
		if(index >= this.instancia.getCentros().size()) {

			if(this.actual.getCentrosElegidos().size() == this.instancia.getK() && 
					Solucion.esMejorSolucion(this.actual, this.mejor, this.instancia)) 

				this.mejor = Solucion.clonar(this.actual);
				
		} else {
			// Caso recursivo
			actual.aniadirElementos(centros.get(index));
			generarSubconjuntos(index+1, centros);
				
			actual.quitarElementos(centros.get(index));
			generarSubconjuntos(index+1, centros);
		}
	}
}
