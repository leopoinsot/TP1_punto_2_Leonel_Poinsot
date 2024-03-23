package modelo;

import exceptions.SaldoInsuficienteExcepcion;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalTime;

public class TarjetaCredito {
	private int numeroTarjeta;
	private String dni;
	private double saldoActual;
	private String marca;
	private Descuento descuento;

	private RegistroCostoPedido registroCostoPedido;

	public TarjetaCredito(int numeroTarjeta, String dni,
						  double saldoActual, String marca, Descuento descuento,
						  RegistroCostoPedido registroCostoPedido) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.dni = dni;
		this.saldoActual = saldoActual;
		this.marca = marca;
		this.descuento = descuento;
		this.registroCostoPedido = registroCostoPedido;
	}

	public void pagar(double costoTotalBebidas, double costoTotalPlatos, double porcentajePropina) throws IOException {
		double montoDescuento = (aplicarDescuento(costoTotalBebidas, costoTotalPlatos) * (1 + porcentajePropina / 100));
		registroCostoPedido.registrar(FormatoFecha.aplicarFormatoEuropeo(LocalDate.now()), LocalTime.now().toString(), montoDescuento);
		saldoActual = saldoActual - montoDescuento;
	}

	private double aplicarDescuento(double costoTotalBebidas, double costoTotalPlatos) {
		return descuento.aplicarDescuento(costoTotalBebidas, costoTotalPlatos);
	}

	public boolean saldoEsIgualAUn(int monto) {
		int saldoTarjeta = (int) saldoActual;
		return saldoTarjeta == monto;
	}
}