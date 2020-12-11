package logica;

import java.util.ArrayList;

public class Instancia {
	private ArrayList<Cliente> clientes;
	private ArrayList<CentroDistribucion> centros;
	private int k;
	
	public Instancia(ArrayList<Cliente> clientes, ArrayList<CentroDistribucion> centros, int k) {
		this.clientes = clientes;
		this.centros = centros;
		this.k = k;
	}
	
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setCentros(ArrayList<CentroDistribucion> centros) {
		this.centros = centros;
	}

	public Instancia(ArrayList<Cliente> clientes, ArrayList<CentroDistribucion> centros) {
		this.clientes = clientes;
		this.centros = centros;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> getClientes() {
		return (ArrayList<Cliente>) clientes.clone();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<CentroDistribucion> getCentros() {
 		return (ArrayList<CentroDistribucion>) centros.clone();
	}
	
	public void setK(int k) {
		this.k = k;
	}

	public int getK() {
		return k;
	}

	public int getBeneficio() {
		int beneficio = 0;
		
		for (CentroDistribucion centro : this.centros) 
			beneficio += centro.getDistanciaPromedio();
		
		return beneficio;
	}
}
