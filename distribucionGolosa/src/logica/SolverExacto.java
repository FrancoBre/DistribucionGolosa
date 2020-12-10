package logica;

import java.util.ArrayList;

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
		
		generarSubconjuntos(0, (ArrayList<CentroDistribucion>) instancia.getCentros().clone());
		
		return mejor;
	}
	
	/*
	// Print all subsets of given set[] 
    public void printSubsets() 
    { 
    	ArrayList<CentroDistribucion> centros = this.instancia.getCentros();
        int n = centros.size(); 
  
        // Run a loop for printing all 2^n 
        // subsets one by one 
        for (int i = 0; i < (1<<n); i++) 
        { 
            System.out.print("{ "); 
            
            // Print current subset 
            for (int j = 0; j < n; j++) 
  
                // (1<<j) is a number with jth bit 1 
                // so when we 'and' them with the 
                // subset number we get which numbers 
                // are present in the subset and which 
                // are not 
                if ((i & (1 << j)) > 0)
                	
                    System.out.print(centros.get(j) + " "); 
  
            System.out.println("}"); 
        } 
    } */
    
    public void generarSubconjuntos(int index, ArrayList<CentroDistribucion> centros) {
    	if(index >= this.instancia.getCentros().size()) {
			// Caso base
			if(this.actual.getCentrosElegidos().size() == this.instancia.getK() && 
					Solucion.esMejorSolucion(this.actual, this.mejor, this.instancia))
				
				this.mejor = Solucion.clonar(this.actual);
		}
		else {
			// Caso recursivo
			actual.aniadirElementos(centros.get(index));
			generarSubconjuntos(index+1, centros);
			
			actual.quitarElementos(centros.get(index));
			generarSubconjuntos(index+1, centros);
		}
    }   
    
    public Solucion getSolucion() {
    	if(this.mejor.getCentrosElegidos().size() == 0) 
    		throw new RuntimeException("Ejecute el metodo resolver");
    	else
    		return this.mejor;
    }

    /*
	private void generarSubconjuntos(ArrayList<CentroDistribucion> centros, int n, int indexActual, int index, int k) {
		if(index > n) return;	// Caso base
		
		if(k == 0) {
			System.out.println("\n\n"+"Iteracion "+cont);
			for(int i = 0; i < indexActual; i++) {
				System.out.print(centros.get(i).getNombre()+" ");
				this.actual.aniadirElementos(centros.get(i));
			}
			cont++;
			return;
		}
		
//		this.actual.aniadirElementos(centros.get(indexActual));
		if(esMejor(this.actual, this.mejor)) this.mejor = this.actual;
		
		generarSubconjuntos(centros, n, indexActual+1, index+1, k-1);
		generarSubconjuntos(centros, n, indexActual, index+1, k-1);
	} */

	
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
			
		long fin = System.currentTimeMillis();
		double tiempo = (fin - inicio) / 1000.0;
			
		System.out.println("n = " + 5 + ": " + tiempo + " seg.");
		ArrayList<CentroDistribucion> centrosSolucion = solver.getSolucion().getCentrosElegidos();
		
		System.out.println("Los centros elegidos son");
		for(CentroDistribucion cd : centrosSolucion)
			System.out.println(cd.getNombre()+" con las coordenadas "+cd.getCoordenada());
	}
}
