package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class GreaterThan extends AbstractSpecification<Integer>{

	private Integer value;
	
	
	public GreaterThan(Integer value) {
		super();
		this.value = value;
	}


	@Override
	public boolean isSatisfiedBy(Integer t) {
		return t > value;
	}

}
