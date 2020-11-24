package logica;

public class Arco {
	private Nodo origen;
	private Nodo destino;
	private double peso;
	
	public Arco(Cliente origen, CentroDistribucion destino, double peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = haversine(origen, destino);
	 }

	//Calcula la distancia en linea recta entre dos puntos en el mapa
	double haversine(Nodo origen, Nodo destino) {
		
		return 0;
	}
	 
	 
	public Nodo getOrigen() {
		return origen;
	}
	
	public Nodo getDestino() {
		return destino;
	}
	
	public double getPeso() {
		return peso;
	}
}
