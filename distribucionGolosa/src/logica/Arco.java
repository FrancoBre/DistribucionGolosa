package logica;

public class Arco {
	private Nodo origen;
	private Nodo destino;
	private double peso;
	
	public Arco(Cliente origen, CentroDistribucion destino, double peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = Algoritmos.haversine(origen.getCoordenada(), 
										 destino.getCoordenada());
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
