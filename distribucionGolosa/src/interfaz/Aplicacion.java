package interfaz;

import logica.ComparadorPorDistPromedio;
import logica.Coordenada;
import logica.Instancia;
import logica.SolverGoloso;
import logica.SolverExacto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import logica.Algoritmos;
import logica.CentroDistribucion;
import logica.Cliente;
import logica.ComparadorPorConveniencia;

public class Aplicacion {
	private Instancia instancia;

	public Aplicacion() {
		this.instancia = crearInstanciaConJSON();
	}

	private Instancia crearInstanciaConJSON() {
		Instancia instancia= new Instancia(leerClientes(), leerCentros(),1);
		
		return instancia;
	}
	
	private ArrayList<CentroDistribucion> leerCentros() {
		String json= "";
		Gson gson = new Gson(); 
		try {
			BufferedReader bc = new BufferedReader(new FileReader("../DistribucionGolosa/distribucionGolosa/src/logica/centros.json"));
			String linea= ""; 
			while((linea = bc.readLine()) != null)
			{
				json += linea; 
			}
			bc.close();
					
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		Type collectionType = new TypeToken<Collection<Coordenada>>(){}.getType();
		Collection<Coordenada> c = gson.fromJson(json, collectionType);
		ArrayList<Coordenada> newList = new ArrayList<>(c);
		ArrayList<CentroDistribucion> centros = new ArrayList<>();
		
		for(Coordenada coordenada : newList) {
			CentroDistribucion centro = new CentroDistribucion(coordenada);
			centros.add(centro);
		}
		
		return centros;
	}

	public void realizarHeuristica1() {
		SolverGoloso solver = new SolverGoloso(this.instancia, new ComparadorPorDistPromedio());
		Algoritmos.valorarCentrosDistPromedio(instancia);
		solver.resolver();
	}
	
	public void realizarHeuristica2() {
		SolverGoloso solver = new SolverGoloso(this.instancia, new ComparadorPorConveniencia(this.instancia));
		solver.resolver();
	}
	
	public void realizarAlgoritmoExacto() {
		// TODO
	}
	
	static ArrayList<Cliente> leerClientes() {
		String json= "";
		Gson gson = new Gson(); 
		try {
			BufferedReader bc = new BufferedReader(new FileReader("../DistribucionGolosa/distribucionGolosa/src/logica/cliente.json"));
			String linea= ""; 
			while((linea = bc.readLine()) != null)
			{
				json += linea; 
			}
			bc.close();
					
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		Type collectionType = new TypeToken<Collection<Coordenada>>(){}.getType();
		Collection<Coordenada> c = gson.fromJson(json, collectionType);
		ArrayList<Coordenada> newList = new ArrayList<>(c);
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		for(Coordenada coordenada : newList) {
			Cliente cliente = new Cliente(coordenada);
			clientes.add(cliente);
		}
		
		for (Cliente cli: clientes) {
			System.out.println(cli.getNombre());
			System.out.println(cli.getCoordenada());
		}
		
		return clientes;
	}
	public static void main(String[] args) {
		leerClientes(); 
		
	}
	
	
}
