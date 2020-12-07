package logica;

import java.util.Comparator;

public class ComparadorPorDistPromedio implements Comparator<CentroDistribucion> {

	@Override
	public int compare(CentroDistribucion arg0, CentroDistribucion arg1) {
		if(arg0.getDistanciaPromedio() == -1 || arg1.getDistanciaPromedio() == -1) throw new RuntimeException("Deben valorarse los centros segun su distancia promedio");
		
		if(arg0.getDistanciaPromedio() < ((CentroDistribucion) arg1).getDistanciaPromedio()) 
			return -1;
		
		if(arg0.getDistanciaPromedio() == ((CentroDistribucion) arg1).getDistanciaPromedio()) 
			return 0;
		
		return 1;
	}
}
