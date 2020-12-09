package logica;

import java.util.ArrayList;

public class Algoritmos {

	// Calcula la distancia entre dos puntos en el mapa
	public static double calcularDistancia(Coordenada origen, Coordenada destino) {

			double r = 6371; // Radio de la tierra, en kilometros

			double lat1 = Math.toRadians(origen.getLatitud());		// La formula del
			double lon1 = Math.toRadians(origen.getLongitud());		// semiverseno
			double lat2 = Math.toRadians(destino.getLatitud());		// recibe radianes,
			double lon2 = Math.toRadians(destino.getLongitud());	// no grados

			double dLon = (lon2 - lon1); // Delta longitud
			double dLat = (lat2 - lat1); // y delta latitud

			double sinLat = Math.sin(dLat / 2);	// Seno de la latitud
			double sinLon = Math.sin(dLon / 2);	// y de la longitud

			double a = (sinLat * sinLat) + Math.cos(lat1)*Math.cos(lat2)*(sinLon*sinLon);
			double c = 2 * Math.asin (Math.min(1.0, Math.sqrt(a)));

			return r * c;
	}

	// Aniade la distancia promedio de todos los centros de distribucion de una instancia
	public static void valorarCentrosDistPromedio(Instancia instancia) {
		for(CentroDistribucion c : instancia.getCentros())
			valorarCentroDistPromedio(c, instancia.getClientes());
	}
	
	// Calcula que tan bueno es un centro segun su distancia promedio con los clientes
	private static void valorarCentroDistPromedio(CentroDistribucion centro, ArrayList<Cliente> clientes) {
		Digrafo grafo = new Digrafo();
		int distanciaPromedio = 0;
		
		for(Cliente cliente : clientes) {
			Arco arco = new Arco(cliente, centro);
			
			grafo.agregarArco(arco);
		}
		
		for(Arco arco : grafo.getArcos()) {
			distanciaPromedio += arco.getPeso();
		}
		
		centro.setDistanciaPromedio(distanciaPromedio);
	}

	// Dado un centro de distribución y una instancia, devuelve la cantidad de clientes a los que les
	// convendría que se abra ese centro de distribución
	public static int cantCentrosQueLesConviene(CentroDistribucion centro, Instancia instancia) {
		return 0;
	}
	
	public static Nodo centroMasCercano(Cliente cliente, Instancia instancia) {
		Digrafo grafo = new Digrafo();
		
		for(CentroDistribucion centro : instancia.getCentros()) {
			Arco arco = new Arco(centro, cliente);
			
			grafo.agregarArco(arco);
		}
		
		return grafo.arcoDeMenorPeso().getDestino();
	}
}

























