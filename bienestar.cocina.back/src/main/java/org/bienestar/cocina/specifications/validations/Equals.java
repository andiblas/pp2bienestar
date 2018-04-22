package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class Equals extends AbstractSpecification<Integer> {

	private Integer value;
	
	public Equals(Integer value) {
		super();
		this.value = value;
	}

	public boolean isSatisfiedBy(Integer t) {
		// TODO Auto-generated method stub
		return value == t;
	}

}
