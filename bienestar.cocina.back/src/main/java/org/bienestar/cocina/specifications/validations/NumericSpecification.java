package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class NumericSpecification extends AbstractSpecification<String>{

	public boolean isSatisfiedBy(String string) {
		return string.matches("[0-9]+");
	}

}
