package org.bienestar.cocina.verifier;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.domain.Preparation;
import org.bienestar.cocina.domain.PreparationRegistry;
import org.bienestar.cocina.exceptions.ConsumptionOutOfRangeException;
import org.bienestar.cocina.preparationRegistry.PreparationRegistryRepository;

public class ConsumptionVerifierStandardDev {

	private PreparationRegistryRepository preparationRegistryRepository;

	public ConsumptionVerifierStandardDev(PreparationRegistryRepository preparationRegistryRepository) {
		this.preparationRegistryRepository = preparationRegistryRepository;
	}

	public void registerConsumption(Consumption consumption, Preparation preparation, Integer diners)
			throws ConsumptionOutOfRangeException {
		List<PreparationRegistry> filteredPreps = preparationRegistryRepository.getPreparationRegistries().stream()
				.filter(prepReg -> prepReg.getPreparation().equals(preparation)
						&& prepReg.getPreparation().getConsumptions().stream()
								.anyMatch(cons -> cons.getIngredient().equals(consumption.getIngredient())))
				.collect(Collectors.toList());

		Double[] quantitiesList = filteredPreps.stream()
				.map(prep -> prep.getPreparation().getConsumptions().stream().mapToDouble(cons -> {
					if (cons.getIngredient().equals(consumption.getIngredient()))
						return cons.getQuantity();
					else
						return 0;
				}).sum()).toArray(Double[]::new);

		StandardDeviation sd = new StandardDeviation(false);
		double stdDev = sd.evaluate(Stream.of(quantitiesList).mapToDouble(Double::doubleValue).toArray());
		
		//usar stdDev para el calculo de rangos.
		
	}

}
