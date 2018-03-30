package org.bienestar.cocina.validaciones.impl;

import org.bienestar.cocina.excepciones.ValidacionException;
import org.bienestar.cocina.validaciones.Validacion;
import org.bienestar.cocina.validaciones.Validador;

public class ValidadorFecha extends Validador{

	public ValidadorFecha() {
		super();
		agregarValidacion(new ValidacionFormatoFecha());
		agregarValidacion(new ValidacionFechaFutura());
	}
	
	@Override
	public void validar(Object param) throws ValidacionException {
		for(Validacion validacion : validaciones){
			validacion.execute(param);
		}
	}

}
