package ar.edu.unrn.exceptions;

public class SaldoInsuficienteExcepcion extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String mensaje;

	public SaldoInsuficienteExcepcion() {

	}

	public SaldoInsuficienteExcepcion(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMessage() {
		return mensaje;
	}
}
