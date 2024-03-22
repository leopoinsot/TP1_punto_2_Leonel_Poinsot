package modelo;

public class DescuentoComarcaPlus extends Descuento {
	public DescuentoComarcaPlus(double descuento) {
		super(descuento);
	}

	public double aplicarDescuento(double costoTotalBebidas, double costoTotalPlatos) {
		return (costoTotalBebidas + costoTotalPlatos) * (1 - porcentajeDescuento / 100);
	}
}
