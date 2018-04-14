package org.bienestar.cocina.validations.impl;

import org.bienestar.cocina.validations.Validador;

public class DateValidator extends Validador{

	public DateValidator() {
		super();
		agregarValidacion(new DateFormatValidation());
		agregarValidacion(new FutureDateValidation());
	}
}
