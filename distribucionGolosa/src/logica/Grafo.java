package logica;

import java.util.ArrayList;

public class Grafo {
	
	private ArrayList<Arco> arcos;
    private ArrayList<Nodo> nodos;

    public Grafo() {
    	this.nodos = new ArrayList<Nodo>();
    	this.arcos = new ArrayList<Arco>();
    }
    
    
    public void agregarArco(Arco Arco) {
    	if((!this.getArcos().contains(Arco) && 
    			!Arco.getOrigen().equals(Arco.getDestino()))) {	
	    		
    		this.getArcos().add(Arco);
	    	
    		if(!this.getNodos().contains(Arco.getOrigen())) 
    			this.getNodos().add(Arco.getOrigen());
    		
    		if(!this.getNodos().contains(Arco.getDestino())) 
    			this.getNodos().add(Arco.getDestino());
    			
    	}
	}
    
    public void eliminarArco(Arco Arco) {
    	getArcos().remove(Arco);
    	Arco.getOrigen().eliminarVecino(Arco.getDestino());
    	Arco.getDestino().eliminarVecino(Arco.getOrigen());
    }
	
	public void eliminarNodo(Nodo Nodo) {
		getNodos().remove(Nodo);
	}
    
    public boolean existeArco(Arco Arco) {
    	return this.getArcos().contains(Arco);
    }


	public ArrayList<Arco> getArcos() {
		return arcos;
	}


	public void setArcos(ArrayList<Arco> arcos) {
		this.arcos = arcos;
	}


	public ArrayList<Nodo> getNodos() {
		return nodos;
	}


	public void setNodos(ArrayList<Nodo> nodos) {
		this.nodos = nodos;
	}

	


}
