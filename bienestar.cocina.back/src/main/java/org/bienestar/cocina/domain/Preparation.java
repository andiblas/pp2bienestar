package org.bienestar.cocina.domain;

import java.util.ArrayList;
import java.util.List;

public class Preparation {

	private String name;
	private List<Consumption> consumptions;
	private PreparationType type; 

	public Preparation() {
		consumptions = new ArrayList<>();
	}
	
	public String getPreparation() {
		return name;
	}

	public void setPreparation(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Consumption> getConsumptions() {
		return consumptions;
	}

	public void setConsumptions(List<Consumption> consumptions) {
		this.consumptions = consumptions;
	}

	public PreparationType getType() {
		return type;
	}

	public void setType(PreparationType type) {
		this.type = type;
	}
	
	public void addConsumption(Consumption consumption){
		this.consumptions.add(consumption);
	}
	
}
