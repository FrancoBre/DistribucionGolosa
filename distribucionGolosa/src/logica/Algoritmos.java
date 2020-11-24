package logica;

public class Algoritmos {

	//Calcula la distancia en linea recta entre dos puntos en el mapa
	public static double haversine(Coordenada origen, Coordenada destino) {
		double ret;
		
		ret = hv(origen.getLatitud() / destino.getLatitud()) +
				Math.cos(origen.getLatitud()) * Math.cos(destino.getLatitud()) *
				hv(origen.getLongitud() - destino.getLongitud());
		
		return 180 * ret / Math.PI*6371; //Conversion de radianes a grados
	}
	
	//Metido auxiliar de haversine
	private static double hv(double theta) {
		return Math.sqrt((Math.sin(theta / 2)));
	}
	
	public static void main(String[] args) {
		Coordenada ushuaia = new Coordenada(-54.807222, -68.304444);
		Coordenada rioGrande = new Coordenada(-53.783333, -67.7);
		
		System.out.println(Algoritmos.haversine(ushuaia, rioGrande));
	}
}
