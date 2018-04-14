package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class HasOneSeparatorSpecification extends AbstractSpecification<String>{

	private String separator;
	
	public HasOneSeparatorSpecification(String separator) {
		this.separator = separator;
	}

	public boolean isSatisfiedBy(String string) {
		String[] split = string.split(separator);
		return split.length == 2;
	}

}
