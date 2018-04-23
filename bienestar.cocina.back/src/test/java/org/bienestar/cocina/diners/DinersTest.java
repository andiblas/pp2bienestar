package org.bienestar.cocina.diners;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DinersTest {

	@Test
	public void dinersQuantity() {
		DinersRepository dinerRepository = new DinersRepository();
		DinerInput dinersInput = new DinerInput(dinerRepository);
		dinersInput.regiterQuantity(10);
		assertEquals(new Integer(10), dinersInput.getDinersQuantity());
	}

	// Si se ingresa la letra ‘A’ o ‘a’ como cantidad de comensales, el sistema
	// arrojará una excepción de cantidad de comensales inválidos

	// En el caso de ingresar un número negativo, deberá dar error. Por ejemplo,
	// si se ingresa ‘-5’ como cantidad de comensales, el sistema deberá dar
	// error.

	// Si se ingresa 10,5 como cantidad de comensales, el sistema arrojará una
	// excepción de cantidad de comensales inválidos.

}
