package org.bienestar.cocina.preparation;

import static org.junit.Assert.*;

import org.bienestar.cocina.preparationType.PreparationTypeInput;
import org.bienestar.cocina.preparationType.PreparationTypeRepository;
import org.junit.Test;

public class PreparationTest {

	@Test
	public void preparationTest() {
		PreparationRepository preparationRepository = new PreparationRepository();
		PreparationInput preparationInput = new PreparationInput(preparationRepository);
		preparationInput.registerPreparation("Leche Chocolatada");
		
		assertTrue(preparationInput.getPreparations().contains("Leche Chocolatada"));
	}

}
