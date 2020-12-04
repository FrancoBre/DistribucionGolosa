package logica;

public class Algoritmos {

	//Calcula la distancia entre dos puntos en el mapa teniendo en cuenta la circunferencia de la tierra
	public static double calcularDistancia(Coordenada origen, Coordenada destino) {; 

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
	
	//Calcula la distancia en linea recta entre dos puntos en el mapa
	public static double calcularDistanciaEnLineaRecta(Coordenada origen, Coordenada destino) { 
		
		double r = 1; // Radio de la tierra, en kilometros

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
}
