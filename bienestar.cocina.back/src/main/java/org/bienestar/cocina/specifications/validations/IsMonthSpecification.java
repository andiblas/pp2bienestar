package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsMonthSpecification extends AbstractSpecification<String> {

	private String separator;

	public IsMonthSpecification(String separator) {
		this.separator = separator;
	}

	public boolean isSatisfiedBy(String string) {
		String[] split = string.split(separator);
		return split[1].matches("^([1-9]|0[1-9]|1[0-2])$");
	}

}
