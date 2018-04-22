package org.bienestar.cocina.verifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.bienestar.cocina.domain.Consumption;

public class ConsumptionRepository {

	private List<Entry<Consumption, Integer>> consumptions;

	public ConsumptionRepository() {
		consumptions = new ArrayList<Entry<Consumption,Integer>>();
	}

	public List<Entry<Consumption, Integer>> getConsumptions() {
		return consumptions;
	}
}
