package org.bienestar.cocina.validaciones.impl;

import org.bienestar.cocina.excepciones.ValidacionException;
import org.bienestar.cocina.formatos.FormatoFecha;
import org.bienestar.cocina.validaciones.Validacion;

public class ValidacionFormatoFecha implements Validacion {

	private FormatoFecha formato;

	public ValidacionFormatoFecha() {
		formato = new FormatoFecha();
	}

	public void execute(Object param) throws ValidacionException {
		String fecha = (String) param;
		if (!fecha.matches(formato.getFormato())) {
			throw new ValidacionException();
		}
	}

}
