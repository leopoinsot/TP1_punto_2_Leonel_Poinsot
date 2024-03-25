package ar.edu.unrn.modelo;

import java.util.Objects;

public class Descuento {
	protected double porcentajeDescuento;

	public Descuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public double aplicarDescuento(double costoTotalBebidas, double costoTotalPlatos) {
		return costoTotalBebidas + costoTotalPlatos;
	}
}