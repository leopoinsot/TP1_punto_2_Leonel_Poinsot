package ar.edu.unrn.modelo;

import java.util.Objects;

public class Bebida {
	private double precio;
	private String marca;

	public Bebida(double precio, String marca) {
		this.precio = precio;
		this.marca = marca;
	}

	public double obtenerPrecio() {
		return precio;
	}

}