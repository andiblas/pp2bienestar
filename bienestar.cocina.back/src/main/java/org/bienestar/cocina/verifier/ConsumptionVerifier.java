package org.bienestar.cocina.verifier;

import java.util.OptionalDouble;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.exceptions.ConsumptionOutOfRangeException;
import org.bienestar.cocina.specifications.validations.GreaterThanDouble;
import org.bienestar.cocina.specifications.validations.LesserThanDouble;

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
			Double value = average.getAsDouble();
			Double tolerance = value * 0.20;
			Double min = value - tolerance;
			Double max = value + tolerance;
			Double unitConsumption = consumption.getQuantity() / commensal;
			if (new GreaterThanDouble(max).or(new LesserThanDouble(min)).isSatisfiedBy(unitConsumption)) {
				throw new ConsumptionOutOfRangeException();
			}
		}

		consumptionRepository.getConsumptions().add(consumption);
	}

}
