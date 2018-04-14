package org.bienestar.cocina.validations.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bienestar.cocina.exceptions.ValidacionException;
import org.bienestar.cocina.validations.Validacion;

public class ValidacionFechaFutura implements Validacion{

	public void execute(Object param) throws ValidacionException {
		Date hoy = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if(hoy.before(sdf.parse((String) param))){
				throw new ValidacionException("Fecha superior a la fecha de hoy");
			}
		} catch (ParseException e) {
			throw new ValidacionException("Error en parseo de fecha");
		}
	}

}
