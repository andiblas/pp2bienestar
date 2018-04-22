package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class LesserThanDouble extends AbstractSpecification<Double> {

	private Double value;
	
	public LesserThanDouble(Double value) {
		super();
		this.value = value;
	}

	public boolean isSatisfiedBy(Double t) {
		return value > t;
	}

}
