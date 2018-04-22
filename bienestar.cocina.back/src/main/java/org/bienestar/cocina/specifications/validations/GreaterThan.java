package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class GreaterThan extends AbstractSpecification<Integer>{

	private Integer value;
	
	public GreaterThan(Integer value) {
		super();
		this.value = value;
	}

<<<<<<< HEAD

=======
>>>>>>> 21d37ca3bc4e31a1459fdd72f4b7e5b98a1c4fd3
	public boolean isSatisfiedBy(Integer t) {
		return t > value;
	}

}
