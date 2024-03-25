package ar.edu.unrn.accesos;

import java.time.LocalDate;
import java.time.LocalTime;

public interface CalculoPedidoDAO {
	void create(LocalDate fecha, LocalTime hora, double monto);

	void update(LocalDate fecha, LocalTime hora, double monto);

	void remove(int id);
}
