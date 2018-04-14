package org.bienestar.cocina.validations.impl;

import org.bienestar.cocina.validations.Validador;

public class ValidadorFecha extends Validador{

	public ValidadorFecha() {
		super();
		agregarValidacion(new ValidacionFormatoFecha());
		agregarValidacion(new ValidacionFechaFutura());
	}
}
