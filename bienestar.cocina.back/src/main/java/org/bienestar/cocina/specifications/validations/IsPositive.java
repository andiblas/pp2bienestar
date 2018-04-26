package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsPositive extends AbstractSpecification<String>{

	@Override
	public boolean isSatisfiedBy(String t) {
		Integer numero = Integer.valueOf(t);
		return Integer.signum(numero) == 1;
	}

}
