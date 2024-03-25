package ar.edu.unrn.modelo;

import ar.edu.unrn.api.IApi;
import ar.edu.unrn.api.PersistenceApi;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TarjetaCreditoTest {

	@Test
	public void pagarConTarjetaVisaTest() throws IOException {
		var bebidaSpeed = new Bebida(1000, "Speed");
		var platoEmpanadas = new Plato("Empanadas", 8000);

		var pedido = new Pedido(LocalDate.now(), LocalTime.now());
		pedido.agregarPlato(platoEmpanadas, 1);
		pedido.agregarBebida(bebidaSpeed, 2);
		pedido.confirmarPedido();
		var registroCostoPedido = new PersistenceApi() {
			private boolean seLlamo = false;

			public void registrar(String fecha, String hora, double monto) throws IOException {
				seLlamo = true;
			}

			public boolean seLlamo() {
				return this.seLlamo;
			}
		};
		var tarjetaCredito = new TarjetaCredito(23453423, "45260989", 11000, "Visa", new DescuentoVisa(3), registroCostoPedido);
		tarjetaCredito.pagar(pedido.calcularCostoTotalBebidas(), pedido.calcularCostoTotalPlatos(), 2);

		assertTrue(tarjetaCredito.saldoEsIgualAUn(861));
		assertTrue(registroCostoPedido.seLlamo());
	}

	@Test
	public void pagarConTarjetaMastercardTest() throws IOException {
		var bebidaSpeed = new Bebida(1000, "Speed");
		var platoEmpanadas = new Plato("Empanadas", 8000);

		var pedido = new Pedido(LocalDate.now(), LocalTime.now());
		pedido.agregarPlato(platoEmpanadas, 1);
		pedido.agregarBebida(bebidaSpeed, 2);
		pedido.confirmarPedido();
		var registroCostoPedido = new PersistenceApi() {
			private boolean seLlamo = false;

			public void registrar(String fecha, String hora, double monto) throws IOException {
				seLlamo = true;
			}

			public boolean seLlamo() {
				return this.seLlamo;
			}
		};

		var tarjetaCredito = new TarjetaCredito(23453423, "45260989", 11000, "Mastercard", new DescuentoMastercard(2), registroCostoPedido);
		tarjetaCredito.pagar(pedido.calcularCostoTotalBebidas(), pedido.calcularCostoTotalPlatos(), 2);

		assertTrue(tarjetaCredito.saldoEsIgualAUn(963));
		assertTrue(registroCostoPedido.seLlamo());
	}

	@Test
	public void pagarConTarjetaComarcaPlus() throws IOException {
		var bebidaSpeed = new Bebida(1000, "Speed");
		var platoEmpanadas = new Plato("Empanadas", 8000);

		var pedido = new Pedido(LocalDate.now(), LocalTime.now());
		pedido.agregarPlato(platoEmpanadas, 1);
		pedido.agregarBebida(bebidaSpeed, 2);
		pedido.confirmarPedido();
		var registroCostoPedido = new PersistenceApi() {
			private boolean seLlamo = false;

			public void registrar(String fecha, String hora, double monto) throws IOException {
				seLlamo = true;
			}

			public boolean seLlamo() {
				return this.seLlamo;
			}
		};

		var tarjetaCredito = new TarjetaCredito(23453423, "45260989", 11000, "Comarca Plus", new DescuentoComarcaPlus(2), registroCostoPedido);
		tarjetaCredito.pagar(pedido.calcularCostoTotalBebidas(), pedido.calcularCostoTotalPlatos(), 2);

		assertTrue(tarjetaCredito.saldoEsIgualAUn(1004));
		assertTrue(registroCostoPedido.seLlamo());
	}

	@Test
	public void pagarConTarjetaViedma() throws IOException {
		var bebidaSpeed = new Bebida(1000, "Speed");
		var platoEmpanadas = new Plato("Empanadas", 8000);

		var pedido = new Pedido(LocalDate.now(), LocalTime.now());
		pedido.agregarPlato(platoEmpanadas, 1);
		pedido.agregarBebida(bebidaSpeed, 2);
		pedido.confirmarPedido();
		var registroCostoPedido = new PersistenceApi() {
			private boolean seLlamo = false;

			public void registrar(String fecha, String hora, double monto) throws IOException {
				seLlamo = true;
			}

			public boolean seLlamo() {
				return this.seLlamo;
			}
		};

		var tarjetaCredito = new TarjetaCredito(23453423, "45260989", 11000, "Viedma", new Descuento(0), registroCostoPedido);
		tarjetaCredito.pagar(pedido.calcularCostoTotalBebidas(), pedido.calcularCostoTotalPlatos(), 2);
		assertTrue(tarjetaCredito.saldoEsIgualAUn(800));
		assertTrue(registroCostoPedido.seLlamo());
	}
}