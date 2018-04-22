package org.bienestar.cocina.verifier;

import java.util.Map.Entry;
import java.util.OptionalDouble;

import org.bienestar.cocina.domain.Consumption;

public class ConsumptionVerifier {

	private ConsumptionRepository consumptionRepository;

	public ConsumptionVerifier(ConsumptionRepository consumptionRepository) {
		this.consumptionRepository = consumptionRepository;

	}

	public void RegisterConsumption(Consumption consumption, Integer commensal) throws Exception {
		OptionalDouble average = consumptionRepository.getConsumptions().stream().filter(x -> x.getKey() == consumption)
				.mapToInt(x -> x.getValue()).average();
		if (average.isPresent()) {
			Double min, max;
			Double value = average.getAsDouble();
			Double tolerance = value * 0.20;
			min = value - tolerance;
			max = value + tolerance;
			if (commensal < min || commensal > max) {
				throw new Exception("prueba");
			}
		}
		
		consumptionRepository.getConsumptions().add(new Entry<Consumption, Integer>() {

			public Integer setValue(Integer value) {
				return null;
			}

			public Integer getValue() {
				return commensal;
			}

			public Consumption getKey() {
				return consumption;
			}
		});
	}

}
