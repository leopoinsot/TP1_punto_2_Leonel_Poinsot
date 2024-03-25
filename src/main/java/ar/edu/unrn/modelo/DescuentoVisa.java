package ar.edu.unrn.modelo;

public class DescuentoVisa extends Descuento {
	public DescuentoVisa(double descuento) {
		super(descuento);
	}

	public double aplicarDescuento(double costoTotalBebidas, double costoTotalPlatos) {
		return costoTotalBebidas * (1 - porcentajeDescuento / 100) + costoTotalPlatos;

	}

}
