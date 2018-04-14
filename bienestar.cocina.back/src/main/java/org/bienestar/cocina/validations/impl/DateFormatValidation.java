package org.bienestar.cocina.validations.impl;

import org.bienestar.cocina.exceptions.ValidacionException;
import org.bienestar.cocina.formats.DateFormat;
import org.bienestar.cocina.validations.Validator;

public class DateFormatValidation implements Validator {

	private DateFormat formato;

	public DateFormatValidation() {
		formato = new DateFormat();
	}

	public void execute(Object param) throws ValidacionException {
		String fecha = (String) param;
		if (!fecha.matches(formato.getFormato())) {
			throw new ValidacionException("Formato de fecha incorrecto");
		}
	}

}
