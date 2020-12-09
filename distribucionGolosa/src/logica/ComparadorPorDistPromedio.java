package logica;

import java.util.Comparator;

public class ComparadorPorDistPromedio implements Comparator<CentroDistribucion> {

	@Override
	public int compare(CentroDistribucion cd1, CentroDistribucion cd2) {
		if(cd1.getDistanciaPromedio() == -1 || cd2.getDistanciaPromedio() == -1) throw new RuntimeException("Deben valorarse los centros segun su distancia promedio");
		
		if(cd1.getDistanciaPromedio() < ((CentroDistribucion) cd2).getDistanciaPromedio()) 
			return -1;
		
		if(cd1.getDistanciaPromedio() == ((CentroDistribucion) cd2).getDistanciaPromedio()) 
			return 0;
		
		return 1;
	}
}
