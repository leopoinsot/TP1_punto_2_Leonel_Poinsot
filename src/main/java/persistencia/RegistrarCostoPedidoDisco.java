package persistencia;

import modelo.RegistroCostoPedido;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RegistrarCostoPedidoDisco implements RegistroCostoPedido {

	@Override
	public void registrar(String fecha, String hora, double monto) throws IOException {
		String cadena = fecha + "||" + hora + "||" + monto;
		Files.write(Paths.get("C:\\Users\\leonr\\OneDrive\\Escritorio\\calculoMonto.txt"), cadena.getBytes(), StandardOpenOption.APPEND);
	}
}
