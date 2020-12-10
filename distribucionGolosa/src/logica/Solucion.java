package logica;

import java.util.ArrayList;

public class Solucion {
	private ArrayList<CentroDistribucion> centrosElegidos;
	
	public Solucion(ArrayList<CentroDistribucion> centrosElegidos) {
		this.centrosElegidos = centrosElegidos;
	}
	
	public Solucion() {
		this.centrosElegidos = new ArrayList<CentroDistribucion>();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CentroDistribucion> getCentrosElegidos() {
		return (ArrayList<CentroDistribucion>) centrosElegidos.clone();
	}
	
	public void aniadirElementos(CentroDistribucion elemento) {
		this.centrosElegidos.add(elemento);
	}
	
	public void quitarElementos(CentroDistribucion elemento) {
		this.getCentrosElegidos().remove(elemento);
	}
}
