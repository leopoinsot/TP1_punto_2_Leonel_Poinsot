package ar.edu.unrn.api;

import ar.edu.unrn.accesos.CalculoPedidoDAO;
import ar.edu.unrn.accesos.CalculoPedidoDAOJDBC;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class PersistenceApi implements IApi {
	CalculoPedidoDAO calculoPedidoDAO = new CalculoPedidoDAOJDBC();

	@Override
	public void registrar(LocalDate fecha, LocalTime hora, double monto) throws IOException {
		calculoPedidoDAO.create(fecha, hora, monto);
	}
}
