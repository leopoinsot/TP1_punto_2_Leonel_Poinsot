package ar.edu.unrn.modelo;

public class DescuentoMastercard extends Descuento {

	public DescuentoMastercard(double descuento) {
		super(descuento);
	}

	public double aplicarDescuento(double costoTotalBebidas, double costoTotalPlatos) {
		return costoTotalPlatos * (1 - porcentajeDescuento / 100) + costoTotalBebidas;
	}

}
