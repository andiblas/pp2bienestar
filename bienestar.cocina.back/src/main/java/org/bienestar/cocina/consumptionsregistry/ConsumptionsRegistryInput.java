package org.bienestar.cocina.consumptionsregistry;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

import org.bienestar.cocina.domain.ConsumptionsRegistry;

public class ConsumptionsRegistryInput {
	private ConsumptionsRegistryRepository consumptionsRegistryRepository;

	public ConsumptionsRegistryInput(ConsumptionsRegistryRepository consumptionsRegistryRepository) {
		this.consumptionsRegistryRepository = consumptionsRegistryRepository;
	}

	public void registerConsumptionsRegistry(String date) {
		ConsumptionsRegistry registry = new ConsumptionsRegistry();
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM")
                .parseDefaulting(ChronoField.YEAR, Year.now().getValue())
                .toFormatter();
		registry.setDate(LocalDate.parse(date, formatter));
		consumptionsRegistryRepository.getConsumptionsRegisters().add(registry);
	}

	public List<ConsumptionsRegistry> getConsumptionsRegisters() {
		return consumptionsRegistryRepository.getConsumptionsRegisters();
	}
}
