package org.bienestar.cocina.exceptions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExceptionsTest {

	@Test
	public void invalidSeparator() {
		Exception ex = new InvalidSeparatorException();
		assertEquals("Separador inv\u00e1lido", ex.getMessage());
	}
	
	@Test
	public void incorrectDayOfMonth() {
		Exception ex = new IncorrectDayOfMonthException();
		assertEquals("Dia inv\u00e1lido para el mes", ex.getMessage());
	}
	
	@Test
	public void invalidMonth() {
		Exception ex = new InvalidMonthException();
		assertEquals("Mes inv\u00e1lido", ex.getMessage());
	}
	
	@Test
	public void tooManySeparator() {
		Exception ex = new TooManySeparatorException();
		assertEquals("S\u00f3lo se admite un separador", ex.getMessage());
	}
}
