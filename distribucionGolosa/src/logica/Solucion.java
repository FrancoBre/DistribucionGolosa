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
		if(!this.getCentrosElegidos().contains(elemento)) this.centrosElegidos.add(elemento);
	}
	
	public void quitarElementos(CentroDistribucion elemento) {
		this.centrosElegidos.remove(elemento);
	}
	
	// Una solucion es mejor que otra si la suma de todas las distancias de sus clientes a los centros elegidos es menor
	// a la suma de todas las distancias de los clientes a los centros de la otra solucion 
	public static boolean esMejorSolucion(Solucion solucion1, Solucion solucion2, Instancia instancia) {
		return valorSolucion(solucion1, instancia) < valorSolucion(solucion2, instancia) && 
				valorSolucion(solucion1, instancia) == 0 || valorSolucion(solucion2, instancia) == 0;
	}

	private static int valorSolucion(Solucion solucion, Instancia instancia) {
		int ret = 0;
		
		for(CentroDistribucion cd : solucion.getCentrosElegidos()) 
			Algoritmos.valorarCentroDistPromedio(cd, instancia.getClientes());
		
		for(CentroDistribucion cd : solucion.getCentrosElegidos()) 
			ret += cd.getDistanciaPromedio();
		
		return ret;
	}
	
	public static Solucion clonar(Solucion solucion) {
		return new Solucion(solucion.getCentrosElegidos());
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Los centros de esta solución son:\n");
		
		for(CentroDistribucion cd : this.centrosElegidos)
			str.append(cd.getNombre()+" con las coordenadas "+cd.getCoordenada()+"\n");
		
		return str.toString();
	}
}
