package ar.edu.unrn.accesos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class CalculoPedidoDAOJDBC implements CalculoPedidoDAO {
	@Override
	public void create(LocalDate fecha, LocalTime hora, double monto) {
		// Proporciona los detalles de conexión a la base de datos
		String url = "jdbc:mysql://localhost:3306/sistema_de_restaurante";
		String username = "LeonelAriel";
		String password = "villa2015";

		try {
			// Establece la conexión a la base de datos
			Connection conn = DriverManager.getConnection(url, username, password);

			// Prepara la sentencia SQL para la inserción
			PreparedStatement statement = conn.prepareStatement("INSERT INTO calculos_pedidos(fecha, hora, monto) VALUES (?, ?, ?)");

			// Establece los valores de los parámetros en la sentencia SQL
			statement.setDate(1, java.sql.Date.valueOf(fecha));
			statement.setTime(2, java.sql.Time.valueOf(hora));
			statement.setDouble(3, monto);
			// Ejecuta la inserción
			statement.executeUpdate();

			// Cierra la conexión y la declaración
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Error al conectar con la base de datos", e);
		}
	}

	@Override
	public void update(LocalDate fecha, LocalTime hora, double monto) {

	}

	@Override
	public void remove(int id) {

	}
}
