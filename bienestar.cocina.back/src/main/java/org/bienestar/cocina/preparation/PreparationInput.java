package org.bienestar.cocina.preparation;

import org.bienestar.cocina.domain.Preparation;

public class PreparationInput {

	private PreparationRepository preparationRepository;

	public PreparationInput(PreparationRepository preparationRepository) {
		this.preparationRepository = preparationRepository;

	}

	public void registerPreparation(String preparationInput) {
		Preparation preparation = new Preparation();
		preparation.setPreparation(preparationInput);
		preparationRepository.getPreparations().add(preparation);
	}

	public String getPreparationInput() {
		return preparationRepository.getPreparations().toString();

	}

}
