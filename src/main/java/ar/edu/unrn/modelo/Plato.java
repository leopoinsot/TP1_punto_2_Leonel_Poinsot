package ar.edu.unrn.modelo;

public class Plato {
	private String nombre;
	private float precio;

	public Plato(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public float obtenerPrecio() {
		return precio;
	}
}