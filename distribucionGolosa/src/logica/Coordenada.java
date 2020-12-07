package logica;

public class Coordenada {
	private double latitud; 
	private double longitud; 
	
	public Coordenada (double latitud, double longitud) {
		this.latitud= latitud; 
		this.longitud= longitud; 
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}
	
	@Override
	public boolean equals(Object o) {
		Coordenada that = (Coordenada) o;
		
		return this.latitud == that.getLatitud() && 
				this.longitud == that.getLongitud();
	}
	
	@Override
	public String toString() {
		return "Latitud= "+latitud + ", longitud= "+longitud;
	}
}
