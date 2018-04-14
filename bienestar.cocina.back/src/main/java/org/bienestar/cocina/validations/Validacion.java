package org.bienestar.cocina.validations;

import org.bienestar.cocina.exceptions.ValidacionException;

public interface Validacion {

	void execute(Object param) throws ValidacionException;
}
