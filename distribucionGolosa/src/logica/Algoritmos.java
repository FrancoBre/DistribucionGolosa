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
	public static void valorarCentroDistPromedio(CentroDistribucion centro, ArrayList<Cliente> clientes) {
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
		int ret = 0;
		
		for(Cliente c : instancia.getClientes())
			if(centroMasCercano(c, instancia).equals(centro)) ret++;
		
		return ret;
	}
	
	public static ArrayList<Cliente> cantCentrosQueLesConviene2(CentroDistribucion centro, Instancia instancia) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		for(Cliente c : instancia.getClientes())
			if(centroMasCercano(c, instancia).equals(centro)) clientes.add(c);
		
		return clientes;
	}
	
	public static Nodo centroMasCercano(Cliente cliente, Instancia instancia) {
		Digrafo grafo = new Digrafo();
		
		for(CentroDistribucion centro : instancia.getCentros()) {
			Arco arco = new Arco(centro, cliente);
			
			grafo.agregarArco(arco);
		}
		
		return grafo.arcoDeMenorPeso().getDestino();
	}
	
	public static void main(String args[]) {
		ArrayList<CentroDistribucion> centros = new ArrayList<CentroDistribucion>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		Coordenada cd1 = new Coordenada(-34.58664, -58.76084);
		CentroDistribucion centro1 = new CentroDistribucion(cd1, "Centro 1");
		centros.add(centro1);

		Coordenada cd2 = new Coordenada(-34.60967, -58.78195);
		CentroDistribucion centro2 = new CentroDistribucion(cd2, "Centro 2");
		centros.add(centro2);
		
		Coordenada cd3 = new Coordenada(-34.63524, -58.7641);
		CentroDistribucion centro3 = new CentroDistribucion(cd3, "Centro 2");
		centros.add(centro3);
		
		Coordenada cd4 = new Coordenada(-34.65119, -58.78985);
		CentroDistribucion centro4 = new CentroDistribucion(cd4, "Centro 4");
		centros.add(centro4);
		
		Coordenada cd5 = new Coordenada(-34.62606, -58.70745);
		CentroDistribucion centro5 = new CentroDistribucion(cd5, "Centro 5");
		centros.add(centro5);
		
		Coordenada c1 = new Coordenada(-34.6003, -58.75266);
		Cliente cliente1 = new Cliente(c1, "Cliente 1");
		clientes.add(cliente1);		
	
		Coordenada c2 = new Coordenada(-34.6583, -58.78491);
		Cliente cliente2 = new Cliente(c2, "Cliente 2");
		clientes.add(cliente2);
		
		Coordenada c3 = new Coordenada(-34.63947, -58.77529);
		Cliente cliente3 = new Cliente(c3, "Cliente 3");
		clientes.add(cliente3);
		
		Coordenada c4 = new Coordenada(-34.64022, -58.80558);
		Cliente cliente4 = new Cliente(c4, "Cliente 4");
		clientes.add(cliente4);
		
		Coordenada c5 = new Coordenada(-34.65492, -58.76152);
		Cliente cliente5 = new Cliente(c5, "Cliente 5");
		clientes.add(cliente5);
		
		Coordenada c6 = new Coordenada(-34.60334, -58.73787);
		Cliente cliente6 = new Cliente(c6, "Cliente 6");
		clientes.add(cliente6);
		
		Coordenada c7 = new Coordenada(-34.59961, -58.77621);
		Cliente cliente7 = new Cliente(c7, "Cliente 7");
		clientes.add(cliente7);
		
		Coordenada c8 = new Coordenada(-34.60707, -58.79473);
		Cliente cliente8 = new Cliente(c8, "Cliente 8");
		clientes.add(cliente8);
		
		Coordenada c9 = new Coordenada(-34.62402, -58.74066);
		Cliente cliente9 = new Cliente(c9, "Cliente 9");
		clientes.add(cliente9);
		
		Coordenada c10 = new Coordenada(-34.62125, -58.77766);
		Cliente cliente10 = new Cliente(c10, "Cliente 10");
		clientes.add(cliente10);
		
		Instancia instancia = new Instancia(clientes, centros, 5);
		
		ArrayList<Cliente> clientesALosQueLesConvieneC2 = cantCentrosQueLesConviene2(centro2, instancia);
		
		ArrayList<Cliente> clientesALosQueLesConvieneC1 = cantCentrosQueLesConviene2(centro1, instancia);
		
		System.out.println("Cantidad de clientes a los que les conviene que se abra"
				+ " el centro 2");
		for(Cliente c : clientesALosQueLesConvieneC2)
			System.out.println(c.getNombre());
		
		System.out.println("Cantidad de clientes a los que les conviene que se abra"
				+ " el centro 1");
		for(Cliente c : clientesALosQueLesConvieneC1)
			System.out.println(c.getNombre());
	}
}














