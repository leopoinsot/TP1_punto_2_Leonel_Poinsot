package modelo;

import java.io.IOException;

public interface RegistroCostoPedido {
	public void registrar(String fecha, String hora, double monto) throws IOException;

}
