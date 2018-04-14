package org.bienestar.cocina.validaciones;

import org.bienestar.cocina.exceptions.ValidacionException;
import org.bienestar.cocina.validations.Validator;
import org.bienestar.cocina.validations.impl.FutureDateValidation;
import org.junit.Before;
import org.junit.Test;

public class ValidacionFechaFuturaTest {

	private Validator validacion;
	
	@Before
	public void setUp() throws Exception {
		validacion = new FutureDateValidation();
	}
	
	@Test(expected = ValidacionException.class)
	public void formatoIncorrecto() throws ValidacionException {
		String fecha = "";
		validacion.execute(fecha);
	}
	
	@Test(expected = ValidacionException.class)
	public void fechaFutura() throws ValidacionException{
		String fecha = "01/01/3000";
		validacion.execute(fecha);
	}
	
	@Test
	public void fechaCorrecta() throws ValidacionException{
		String fecha = "04/03/2018";
		validacion.execute(fecha);
	}
}
