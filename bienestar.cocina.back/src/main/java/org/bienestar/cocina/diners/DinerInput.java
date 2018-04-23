package org.bienestar.cocina.diners;

import org.bienestar.cocina.domain.Diner;

public class DinerInput {
	private DinersRepository dinersRepository;

	public DinerInput(DinersRepository dinersRepository) {
		this.dinersRepository = dinersRepository;

	}

	public void regiterQuantity(Integer quantity) {
		Diner diner = new Diner();
		diner.setQuantity(quantity);
		dinersRepository.getDiners().add(diner);
	}

	public Integer getDinersQuantity() {
		return dinersRepository.getDiners().stream()
				.mapToInt(x -> x.getQuantity()).sum();

	}
}
