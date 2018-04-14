package org.bienestar.cocina.validations;

import org.bienestar.cocina.exceptions.ValidacionException;

public interface Validator {

	void execute(Object param) throws ValidacionException;
}
