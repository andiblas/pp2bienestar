package org.bienestar.cocina.validations.impl;

import org.bienestar.cocina.exceptions.ValidacionException;
import org.bienestar.cocina.formats.FormatoFecha;
import org.bienestar.cocina.validations.Validacion;

public class ValidacionFormatoFecha implements Validacion {

	private FormatoFecha formato;

	public ValidacionFormatoFecha() {
		formato = new FormatoFecha();
	}

	public void execute(Object param) throws ValidacionException {
		String fecha = (String) param;
		if (!fecha.matches(formato.getFormato())) {
			throw new ValidacionException("Formato de fecha incorrecto");
		}
	}

}