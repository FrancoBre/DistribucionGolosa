package logica;

public class CentroDistribucion extends Nodo implements Comparable {
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

	@Override
	public int compareTo(Object that) {
		if(this.getDistanciaPromedio() < ((CentroDistribucion) that).getDistanciaPromedio()) 
			return -1;
		
		if(this.getDistanciaPromedio() == ((CentroDistribucion) that).getDistanciaPromedio()) 
			return 0;
		
		return 1;
	}
}
