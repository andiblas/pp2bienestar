package org.bienestar.cocina.verifier;

import java.util.OptionalDouble;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.exceptions.ConsumptionOutOfRangeException;

public class ConsumptionVerifier {

	private ConsumptionRepository consumptionRepository;

	public ConsumptionVerifier(ConsumptionRepository consumptionRepository) {
		this.consumptionRepository = consumptionRepository;

	}

	public void RegisterConsumption(Consumption consumption, Integer commensal) throws ConsumptionOutOfRangeException {
		OptionalDouble average = consumptionRepository.getConsumptions().stream()
				.filter(x -> x.getIngredient() == consumption.getIngredient()).mapToDouble(x -> x.getQuantity())
				.average();
		if (average.isPresent()) {
			Double min, max;
			Double value = average.getAsDouble();
			Double tolerance = value * 0.20;
			min = value - tolerance;
			max = value + tolerance;
			Double unitConsumption = consumption.getQuantity() / commensal;
			if (unitConsumption < min || unitConsumption > max) {
				throw new ConsumptionOutOfRangeException();
			}
		}

		consumptionRepository.getConsumptions().add(consumption);
	}

}
