package ar.edu.unrn.modelo;

import ar.edu.unrn.exceptions.PedidoConfirmadoExcepcion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	LocalDate fecha;
	LocalTime hora;
	private List<Plato> listadoPlatos;
	private List<Bebida> listadoBebidas;
	private boolean confirmado;

	public Pedido(LocalDate fecha, LocalTime hora) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.listadoPlatos = new ArrayList<>();
		this.listadoBebidas = new ArrayList<>();
		this.confirmado = false;
	}

	public void agregarPlato(Plato plato, int cantidad) throws PedidoConfirmadoExcepcion {
		if (confirmado == true) {
			throw new PedidoConfirmadoExcepcion("El pedido ya esta confirmado: No se puede cambiar");
		} else {
			while (cantidad > 0) {
				listadoPlatos.add(plato);
				cantidad = cantidad - 1;
			}
		}
	}

	public void agregarBebida(Bebida bebida, int cantidad) throws PedidoConfirmadoExcepcion {
		if (confirmado == true)
			throw new PedidoConfirmadoExcepcion("El pedido ya esta confirmado: No se puede cambiar");
		else {
			while (cantidad > 0) {
				listadoBebidas.add(bebida);
				cantidad = cantidad - 1;
			}
		}
	}

	public double calcularCostoTotalBebidas() {
		double montoTotal = 0;
		for (Bebida bebida : listadoBebidas) {
			montoTotal = montoTotal + bebida.obtenerPrecio();
		}
		return montoTotal;
	}

	public double calcularCostoTotalPlatos() {
		double montoTotal = 0;
		for (Plato plato : listadoPlatos) {
			montoTotal = montoTotal + plato.obtenerPrecio();
		}
		return montoTotal;
	}

	public void confirmarPedido() {
		confirmado = true;
	}
}
