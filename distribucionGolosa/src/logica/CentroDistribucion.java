package logica;

public class CentroDistribucion extends Nodo {
	String nombre;
	Coordenada coor;
	
	public CentroDistribucion(Coordenada coor) {
		super(coor);
	}
	
	public CentroDistribucion(Coordenada coor, String nombre) {
		super(coor);
		this.nombre = nombre;
	}
}
