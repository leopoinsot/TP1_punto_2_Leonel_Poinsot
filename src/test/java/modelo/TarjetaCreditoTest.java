package modelo;

import exceptions.PedidoConfirmadoExcepcion;
import exceptions.SaldoInsuficienteExcepcion;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TarjetaCreditoTest {

	@Test
	public void pagarConTarjetaVisaTest() {
		var bebidaSpeed = new Bebida(1000, "Speed");
		var platoEmpanadas = new Plato("Empanadas", 8000);

		var pedido = new Pedido(LocalDate.now(), LocalTime.now());
		pedido.agregarPlato(platoEmpanadas, 1);
		pedido.agregarBebida(bebidaSpeed, 2);
		pedido.confirmarPedido();

		var tarjetaCredito = new TarjetaCredito(23453423, "45260989", 11000, "Visa", new DescuentoVisa(3));
		tarjetaCredito.pagar(pedido.calcularCostoTotalBebidas(), pedido.calcularCostoTotalPlatos(), 2);

		assertEquals(861, tarjetaCredito.obtenerSaldo());
	}

	@Test
	public void pagarConTarjetaMastercardTest() {
		var bebidaSpeed = new Bebida(1000, "Speed");
		var platoEmpanadas = new Plato("Empanadas", 8000);

		var pedido = new Pedido(LocalDate.now(), LocalTime.now());
		pedido.agregarPlato(platoEmpanadas, 1);
		pedido.agregarBebida(bebidaSpeed, 2);
		pedido.confirmarPedido();

		var tarjetaCredito = new TarjetaCredito(23453423, "45260989", 11000, "Mastercard", new DescuentoMastercard(2));
		tarjetaCredito.pagar(pedido.calcularCostoTotalBebidas(), pedido.calcularCostoTotalPlatos(), 2);

		assertEquals(963, tarjetaCredito.obtenerSaldo());
	}

	@Test
	public void pagarConTarjetaComarcaPlus() {
		var bebidaSpeed = new Bebida(1000, "Speed");
		var platoEmpanadas = new Plato("Empanadas", 8000);

		var pedido = new Pedido(LocalDate.now(), LocalTime.now());
		pedido.agregarPlato(platoEmpanadas, 1);
		pedido.agregarBebida(bebidaSpeed, 2);
		pedido.confirmarPedido();

		var tarjetaCredito = new TarjetaCredito(23453423, "45260989", 11000, "Comarca Plus", new DescuentoComarcaPlus(2));
		tarjetaCredito.pagar(pedido.calcularCostoTotalBebidas(), pedido.calcularCostoTotalPlatos(), 2);

		assertEquals(1004, tarjetaCredito.obtenerSaldo());
	}

	@Test
	public void pagarConTarjetaViedma() {
		var bebidaSpeed = new Bebida(1000, "Speed");
		var platoEmpanadas = new Plato("Empanadas", 8000);

		var pedido = new Pedido(LocalDate.now(), LocalTime.now());
		pedido.agregarPlato(platoEmpanadas, 1);
		pedido.agregarBebida(bebidaSpeed, 2);
		pedido.confirmarPedido();

		var tarjetaCredito = new TarjetaCredito(23453423, "45260989", 11000, "Viedma", new Descuento(0));
		tarjetaCredito.pagar(pedido.calcularCostoTotalBebidas(), pedido.calcularCostoTotalPlatos(), 2);

		assertEquals(800, tarjetaCredito.obtenerSaldo());
	}
}