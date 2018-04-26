package org.bienestar.cocina.specifications.validations;

import org.bienestar.cocina.specifications.generic.AbstractSpecification;

public class IsValidLength extends AbstractSpecification<String>{

	private Integer length;
	
	public IsValidLength(Integer length) {
		this.length = length;
	}
	
	@Override
	public boolean isSatisfiedBy(String t) {
		return t != null ? t.length() == length : false;
	}

}
