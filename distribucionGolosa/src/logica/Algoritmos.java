package logica;

import java.util.ArrayList;

public class Algoritmos {

	// Calcula la distancia entre dos puntos en el mapa
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

	// Añade la distancia promedio de todos los centros de distribucion de una instancia
	public static void valorarCentros(Instancia instancia) {
		for(CentroDistribucion c : instancia.getCentros())
			valorarCentro(c, instancia.getClientes());
	}
	
	// Calcula "qué tan bueno es un centro de distribucion" para los clientes
	static void valorarCentro(CentroDistribucion centro, ArrayList<Cliente> clientes) {
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
	
	public static void main(String args[]) {
		
		ArrayList<CentroDistribucion> centros = new ArrayList<CentroDistribucion>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		Coordenada guitarra = new Coordenada(-33.867886, -63.987);
		Cliente cliente1 = new Cliente(guitarra, "Guitarra");
		clientes.add(cliente1);
		
		Coordenada corazon = new Coordenada(41.303921, -81.901693);
		CentroDistribucion centro1 = new CentroDistribucion(corazon, "Corazon");
		centros.add(centro1);
		
		Coordenada puntoDeMira = new Coordenada(-33.867886, -63.987);
		Cliente cliente2 = new Cliente(puntoDeMira, "Punto de Mira");
		clientes.add(cliente2);
		
		Coordenada piletaGigante = new Coordenada(-33.350534, -71.653268);
		Cliente cliente3 = new Cliente(piletaGigante, "Pileta Gigante");
		clientes.add(cliente3);
		
		Coordenada jesusTeAma = new Coordenada(43.645074, -115.993081);
		Cliente cliente4 = new Cliente(jesusTeAma, "Jesus Te Ama");
		clientes.add(cliente4);
		
		Coordenada elReyLeon = new Coordenada(51.848637, -0.55462);
		CentroDistribucion centro2 = new CentroDistribucion(elReyLeon, "El Rey Leon");
		centros.add(centro2);
		
		Coordenada illuminati = new Coordenada(37.629562, -116.849556);
		Cliente cliente5 = new Cliente(illuminati, "Illuminati");
		clientes.add(cliente5);
		
		Coordenada cocaCola = new Coordenada(-18.529211, -70.249941);
		CentroDistribucion centro3 = new CentroDistribucion(cocaCola, "Coca Cola");
		centros.add(centro3);
		
		for (CentroDistribucion centro : centros) {
			System.out.println("\n");
			for (Cliente cliente : clientes) {
				System.out.println("Distancia entre cliente "+cliente.getNombre()+" y centro "
						+ centro.getNombre()+" = "+ Algoritmos.calcularDistancia(cliente.getCoordenada(), centro.getCoordenada()));
			}
		}
		
		System.out.println();
		
		for (CentroDistribucion centro : centros) {
			Algoritmos.valorarCentro(centro, clientes);
			System.out.println("Valoración para el centro" + centro.getNombre() + " = " + centro.getDistanciaPromedio());
		}
		
	}
}
