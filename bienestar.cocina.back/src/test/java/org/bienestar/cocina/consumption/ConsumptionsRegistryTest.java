package org.bienestar.cocina.consumption;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.bienestar.cocina.consumptionsregistry.ConsumptionsRegistryInput;
import org.bienestar.cocina.consumptionsregistry.ConsumptionsRegistryRepository;
import org.bienestar.cocina.domain.ConsumptionsRegistry;
import org.junit.Test;

public class ConsumptionsRegistryTest {

	@Test
	public void consumptionRegistryInputTest() {
		ConsumptionsRegistryRepository repository = new ConsumptionsRegistryRepository();
		ConsumptionsRegistryInput input = new ConsumptionsRegistryInput(repository);
		input.registerConsumptionsRegistry("01/01");
		List<ConsumptionsRegistry> savedConsumptionsRegisters = input.getConsumptionsRegisters();
		LocalDate expected = LocalDate.of(LocalDate.now().getYear(), 1, 1);
		assertEquals(expected, savedConsumptionsRegisters.get(savedConsumptionsRegisters.size() - 1).getDate());
	}

}
