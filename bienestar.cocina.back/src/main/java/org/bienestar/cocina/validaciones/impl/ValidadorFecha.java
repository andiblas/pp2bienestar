package org.bienestar.cocina.validaciones.impl;

import org.bienestar.cocina.validaciones.Validador;

public class ValidadorFecha extends Validador{

	public ValidadorFecha() {
		super();
		agregarValidacion(new ValidacionFormatoFecha());
		agregarValidacion(new ValidacionFechaFutura());
	}
}
