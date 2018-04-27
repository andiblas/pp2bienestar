package org.bienestar.cocina.consumptionsregistry;

import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.domain.ConsumptionsRegistry;

public class ConsumptionsRegistryRepository {
	private List<ConsumptionsRegistry> registers;

	public ConsumptionsRegistryRepository() {
		registers = new ArrayList<ConsumptionsRegistry>();
	}

	public List<ConsumptionsRegistry> getConsumptionsRegisters() {
		return registers;
	}
}
