package logica;

import java.util.ArrayList;

public class Instancia {
	ArrayList<Cliente> clientes;
	ArrayList<CentroDistribucion> centros;
	int k;
	
	public Instancia(ArrayList<Cliente> clientes, ArrayList<CentroDistribucion> centros, int k) {
		this.clientes = clientes;
		this.centros = centros;
		this.k = k;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> getClientes() {
		return (ArrayList<Cliente>) clientes.clone();
	}
	
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<CentroDistribucion> getCentros() {
		return (ArrayList<CentroDistribucion>) centros.clone();
	}

	public void setCentros(ArrayList<CentroDistribucion> centros) {
		this.centros = centros;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
}
