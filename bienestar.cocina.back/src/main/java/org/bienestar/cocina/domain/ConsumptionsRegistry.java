package org.bienestar.cocina.domain;

import java.time.LocalDate;

public class ConsumptionsRegistry {

	private LocalDate date;

	public ConsumptionsRegistry() {
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
