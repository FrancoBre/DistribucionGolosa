package logica;

import java.util.ArrayList;

public class Grafo {
	
	private ArrayList<Arco> arcos;
    private ArrayList<Nodo> nodos;

    public Grafo() {
    	this.nodos = new ArrayList<Nodo>();
    	this.arcos = new ArrayList<Arco>();
    }
    
    
//    public void agregarArco(Arco Arco) {
//    	if((!this.getArcos().contains(Arco) && 
//    			!Arco.getNodo1().equals(Arco.getNodo2())) {	
//	    		
//    		this.getArcos().add(Arco);
//	    	 
//    		if(!this.getnodos().contains(Arco.getNodo1())) {
//    			this.getnodos().add(Arco.getNodo1());
//    		}
//    		
//    		if(!this.getnodos().contains(Arco.getNodo2())) {
//    			this.getnodos().add(Arco.getNodo2());
//    		}
//    	}
//	}
//
//	public void eliminarArco(Arco Arco) {
//    	getArcos().remove(Arco);
//    	Arco.getNodo1().eliminarVecino(Arco.getNodo2());
//    	Arco.getNodo2().eliminarVecino(Arco.getNodo1());
//    }
//	
//	public void eliminarNodo(Nodo Nodo) {
//		getnodos().remove(Nodo);
//	}
//    
//    public boolean existeArco(Arco Arco) {
//    	return this.getArcos().contains(Arco);
//    }
//
//	public ArrayList<Nodo> getnodos() {
//		return nodos;
//	}
//
//	public void setnodos(ArrayList<Nodo> nodos) {
//		this.nodos = nodos;
//	}
//
//	public ArrayList<Arco> getArcos() {
//		return Arcos;
//	}
//
//	public void setArcos(ArrayList<Arco> Arcos) {
//		this.Arcos = Arcos;
//	}
}
