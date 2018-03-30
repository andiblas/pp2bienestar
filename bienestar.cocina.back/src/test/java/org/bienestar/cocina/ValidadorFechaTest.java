package org.bienestar.cocina;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bienestar.cocina.excepciones.ValidacionException;
import org.bienestar.cocina.validaciones.Validador;
import org.bienestar.cocina.validaciones.impl.ValidadorFecha;
import org.junit.Before;
import org.junit.Test;

public class ValidadorFechaTest {

	private Validador validadorFecha;
	
	@Before
	public void setUp() throws Exception {
		validadorFecha = new ValidadorFecha();
	}
	
	@Test(expected = ValidacionException.class)
	public void mesIncorrecto() throws ValidacionException{
		String fecha = "12/14/1990";
		validadorFecha.validar(fecha);
	}
	
	@Test(expected = ValidacionException.class)
	public void formatoAnioIncorrecto() throws ValidacionException{
		String fecha = "12/01/90";
		validadorFecha.validar(fecha);
	}
	
	@Test(expected = ValidacionException.class)
	public void formatoDiaMesIncorrecto() throws ValidacionException{
		String fecha = "1/1/1990";
		validadorFecha.validar(fecha);
	}
	
	@Test(expected = ValidacionException.class)
	public void diaIncorrecto() throws ValidacionException{
		String fecha = "32/01/1990";
		validadorFecha.validar(fecha);
	}
	
	@Test(expected = ValidacionException.class)
	public void formatoGuiones() throws ValidacionException{
		String fecha = "03-Mar-2018";
		validadorFecha.validar(fecha);
	}
	
	@Test(expected = ValidacionException.class)
	public void fechaFuturo() throws ValidacionException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		String fecha = sdf.format(calendar.getTime());
		validadorFecha.validar(fecha);
	}
}
