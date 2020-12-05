package logica;

public class CentroDistribucion extends Nodo {
	private String nombre;
	int distanciaPromedio;
	
	public CentroDistribucion(Coordenada coor) {
		super(coor);
	}
	
	public CentroDistribucion(Coordenada coor, String nombre) {
		super(coor);
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDistanciaPromedio() {
		return distanciaPromedio;
	}

	public void setDistanciaPromedio(int distanciaPromedio) {
		this.distanciaPromedio = distanciaPromedio;
	}
}
