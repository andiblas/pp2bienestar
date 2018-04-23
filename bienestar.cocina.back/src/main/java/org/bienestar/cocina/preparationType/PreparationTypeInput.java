package org.bienestar.cocina.preparationType;

import org.bienestar.cocina.domain.PreparationType;

public class PreparationTypeInput {

	private PreparationTypeRepository preparationTypeRepository;

	public PreparationTypeInput(
			PreparationTypeRepository preparationTypeRepository) {
		this.preparationTypeRepository = preparationTypeRepository;
	}

	public void registerType(String type) {
		PreparationType preparationType = new PreparationType();
		preparationType.setType(type);
		preparationTypeRepository.getPreparationTypes().add(preparationType);
	}

	public String getPreparationType() {
		return preparationTypeRepository.getPreparationTypes().toString();
	}

}
