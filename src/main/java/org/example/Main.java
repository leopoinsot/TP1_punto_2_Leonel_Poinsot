package org.example;

import exceptions.PedidoConfirmadoExcepcion;
import exceptions.SaldoInsuficienteExcepcion;
import modelo.*;
import persistencia.RegistrarCostoPedidoDisco;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
	public static void main(String[] args) throws IOException {
		var bebidaSpeed = new Bebida(1000, "Speed");
		var platoEmpanadas = new Plato("Empanadas", 8000);

		var pedido = new Pedido(LocalDate.now(), LocalTime.now());
		pedido.agregarPlato(platoEmpanadas, 1);
		pedido.agregarBebida(bebidaSpeed, 2);
		pedido.confirmarPedido();

		var registroCostoPedido = new RegistrarCostoPedidoDisco();
		var TarjetaCredito = new TarjetaCredito(23453423, "45260989", 11000, "Visa", new DescuentoVisa(3), registroCostoPedido);
		TarjetaCredito.pagar(pedido.calcularCostoTotalBebidas(), pedido.calcularCostoTotalPlatos(), 3);
	}
}