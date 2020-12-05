package logica;

public class Cliente extends Nodo {
	String nombre;
	Coordenada coor;
	
	public Cliente(Coordenada coor) {
		super(coor);
	}
	
	public Cliente(Coordenada coor, String nombre) {
		super(coor);
		this.nombre = nombre;
	}
}
