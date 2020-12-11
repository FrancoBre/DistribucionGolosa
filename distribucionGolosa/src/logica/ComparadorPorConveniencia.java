package logica;

import java.util.Comparator;

public class ComparadorPorConveniencia implements Comparator<CentroDistribucion>{
	private Instancia instancia;
	
	public ComparadorPorConveniencia(Instancia instancia) {
		this.instancia = instancia;
	}
	
	@Override
	public int compare(CentroDistribucion cd1, CentroDistribucion cd2) {
		if(Algoritmos.cantCentrosQueLesConviene(cd1, instancia) > 
			Algoritmos.cantCentrosQueLesConviene(cd2, instancia)) return 1;
		
		if(Algoritmos.cantCentrosQueLesConviene(cd1, instancia) < 
		Algoritmos.cantCentrosQueLesConviene(cd2, instancia)) return -1;
		
		return 0;
	}
}
