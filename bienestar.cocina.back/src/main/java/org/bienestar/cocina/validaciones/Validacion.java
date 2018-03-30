package org.bienestar.cocina.validaciones;

import org.bienestar.cocina.excepciones.ValidacionException;

public interface Validacion {

	void execute(Object param) throws ValidacionException;
}
