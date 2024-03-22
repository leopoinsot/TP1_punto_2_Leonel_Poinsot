package modelo;

import exceptions.SaldoInsuficienteExcepcion;

public class TarjetaCredito {
	private int numeroTarjeta;
	private String dni;
	private double saldoActual;
	private String marca;
	private Descuento descuento;

	public TarjetaCredito(int numeroTarjeta, String dni,
						  double saldoActual, String marca, Descuento descuento) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.dni = dni;
		this.saldoActual = saldoActual;
		this.marca = marca;
		this.descuento = descuento;
	}

	public void pagar(double costoTotalBebidas, double costoTotalPlatos, double porcentajePropina) {
		saldoActual = saldoActual - (aplicarDescuento(costoTotalBebidas, costoTotalPlatos) * (1 + porcentajePropina / 100));
	}

	private double aplicarDescuento(double costoTotalBebidas, double costoTotalPlatos) {
		return descuento.aplicarDescuento(costoTotalBebidas, costoTotalPlatos);
	}

	public int obtenerSaldo() {
		return (int) saldoActual;
	}
}