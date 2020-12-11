package logica;

import java.util.ArrayList;
import java.util.Arrays;

public class SolverExacto {
	private Instancia instancia;
	private Solucion actual;
	private Solucion mejor; 
	
	public SolverExacto(Instancia instancia) {
		this.instancia = instancia;
	}
	
	@SuppressWarnings("unchecked")
	public Solucion resolver() {
		this.actual = new Solucion();
		this.mejor = new Solucion();
		
//		generarSubconjuntos(0, (ArrayList<CentroDistribucion>) instancia.getCentros().clone());
		
		int depth = Algoritmos.factorial(this.instancia.getCentros().size());
		
		int[] length = new int[depth];
		int[] counters = new int[depth];
		
		Arrays.fill(counters,0);
		
		ArrayList<ArrayList<CentroDistribucion>> permutaciones = generatePerm(this.instancia.getCentros());
		
		System.out.println(permutaciones.size());
		
		for(ArrayList<CentroDistribucion> centros : permutaciones) {
			System.out.print("{");
			for(CentroDistribucion cd : centros) {
				System.out.print(cd.getNombre()+" ");
			}
			System.out.print("}\n");
		}
		
		return mejor;
	}
	
	public ArrayList<ArrayList<CentroDistribucion>> generatePerm(ArrayList<CentroDistribucion> original) {
	     if (original.isEmpty()) {
	    	 ArrayList<ArrayList<CentroDistribucion>> result = new ArrayList<ArrayList<CentroDistribucion>>(); 
	       result.add(new ArrayList<CentroDistribucion>()); 
	       return result; 
	     }
	     CentroDistribucion firstElement = original.remove(0);
	     ArrayList<ArrayList<CentroDistribucion>> returnValue = new ArrayList<>();
	     ArrayList<ArrayList<CentroDistribucion>> permutations = generatePerm(original);
	     for (ArrayList<CentroDistribucion> smallerPermutated : permutations) {
	       for (int index=0; index <= smallerPermutated.size(); index++) {
	    	   ArrayList<CentroDistribucion> temp = new ArrayList<>(smallerPermutated);
	         temp.add(index, firstElement);
	         returnValue.add(temp);
	       }
	     }
	     return returnValue;
	   }
    
    public void generarSubconjuntos(int index, ArrayList<CentroDistribucion> centros) {
    	if(index >= this.instancia.getCentros().size()) {
			// Caso base
			if(this.actual.getCentrosElegidos().size() == this.instancia.getK() && 
					Solucion.esMejorSolucion(this.actual, this.mejor, this.instancia)) {
				
				System.out.println(this.actual); // Genera una sola solucion
				this.mejor = Solucion.clonar(this.actual);
			}
		}
		else {
			// Caso recursivo
			actual.aniadirElementos(centros.get(index));
			generarSubconjuntos(index+1, centros);
			
			actual.quitarElementos(centros.get(index));
			generarSubconjuntos(index, centros);
		}
    }   
    
    public Solucion getSolucion() {
    	if(this.mejor.getCentrosElegidos().size() == 0) 
    		throw new RuntimeException("Ejecute el metodo resolver");
    	else
    		return this.mejor;
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
		CentroDistribucion centro3 = new CentroDistribucion(cd3, "Centro 3");
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
		
		Coordenada c7 = new Coordenada(-34.59633, -58.7745);
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
		SolverExacto solver = new SolverExacto(instancia);

		long inicio = System.currentTimeMillis();
			
		solver.resolver();
			
//		long fin = System.currentTimeMillis();
//		double tiempo = (fin - inicio) / 1000.0;
//			
//		System.out.println("n = " + 5 + ": " + tiempo + " seg.");
//		ArrayList<CentroDistribucion> centrosSolucion = solver.getSolucion().getCentrosElegidos();
//		
//		System.out.println("Los centros elegidos son");
//		for(CentroDistribucion cd : centrosSolucion)
//			System.out.println(cd.getNombre()+" con las coordenadas "+cd.getCoordenada());
	}
}