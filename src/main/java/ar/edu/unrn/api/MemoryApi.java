package ar.edu.unrn.api;

import ar.edu.unrn.modelo.FormatoFecha;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;

public class MemoryApi implements IApi {

	@Override
	public void registrar(LocalDate fecha, LocalTime hora, double monto) throws IOException {
		String cadena = FormatoFecha.aplicarFormatoEuropeo(fecha) + "||" + hora.toString() + "||" + monto;
		Files.write(Paths.get("C:\\Users\\leonr\\OneDrive\\Escritorio\\calculoMonto.txt"), cadena.getBytes(), StandardOpenOption.APPEND);
	}
}
