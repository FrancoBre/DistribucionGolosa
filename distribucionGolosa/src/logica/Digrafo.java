package logica;

import java.util.ArrayList;

public class Digrafo {
	
	private ArrayList<Arco> arcos;
    private ArrayList<Nodo> nodos;

    public Digrafo() {
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

	public Arco arcoDeMenorPeso() {
		Arco min = this.getArcos().get(0);
		
		for(Arco a : this.getArcos()) 
			if(a.getPeso() < min.getPeso()) min = a;
				
		return min;
	}
}







