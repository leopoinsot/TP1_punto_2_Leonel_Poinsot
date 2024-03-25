package ar.edu.unrn.exceptions;

public class PedidoConfirmadoExcepcion extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String mensaje;

	public PedidoConfirmadoExcepcion() {

	}

	public PedidoConfirmadoExcepcion(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMessage() {
		return mensaje;
	}
}
