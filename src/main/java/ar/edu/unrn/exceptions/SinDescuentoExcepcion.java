package ar.edu.unrn.exceptions;

public class SinDescuentoExcepcion extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String mensaje;

	public SinDescuentoExcepcion() {

	}

	public SinDescuentoExcepcion(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMessage() {
		return mensaje;
	}
}
