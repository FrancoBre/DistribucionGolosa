package logica;

import java.util.ArrayList;

public class Nodo {
	private ArrayList<Nodo> vecinos;
	private Coordenada coordenada; 

	public Nodo(Coordenada coordenada) {
		this.vecinos = new ArrayList<Nodo>();
		this.coordenada = coordenada;
	}
	
	public void insertarVecino(Nodo Nodo) {
		if(!this.vecinos.contains(Nodo) && 
				!Nodo.getCoordenada().equals(this.getCoordenada()))
			this.vecinos.add(Nodo);
	}
	
	public boolean contiene(Nodo Nodo) {
		return this.vecinos.contains(Nodo);
	}
	
	public void eliminarVecino(Arco Arco) {
		Arco.getOrigen().vecinos.remove(Arco.getOrigen());
		Arco.getDestino().vecinos.remove(Arco.getDestino());
	}
	
	public void eliminarVecino(Nodo Nodo) {
		this.vecinos.remove(Nodo);
	}
	
	public boolean tieneVecino(Nodo Nodo) {
		return Nodo.vecinos.isEmpty();
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Nodo> getVecinos() {
		return (ArrayList<Nodo>) vecinos.clone();
	}

	@Override
	public boolean equals(Object o) {
		Nodo Nodo = (Nodo) o;
		
		return this.coordenada.equals(Nodo.getCoordenada());
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(coordenada.toString()+"\nCon los vecinos: {");
		
		for(Nodo v : vecinos) 
			string.append(v.getCoordenada().toString()+"}\n");
			
		return string.toString();
		
	}	
}
