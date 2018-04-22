package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class GreaterThanDouble extends AbstractSpecification<Double> {

	private Double value;

	public GreaterThanDouble(Double value) {
		super();
		this.value = value;
	}

	public boolean isSatisfiedBy(Double t) {
		return value < t;
	}
}
