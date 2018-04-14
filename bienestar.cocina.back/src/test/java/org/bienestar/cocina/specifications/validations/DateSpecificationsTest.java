package org.bienestar.cocina.specifications.validations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DateSpecificationsTest {

	@Test
	public void separatorCharRight() {
		CharSeparatorSpecification spec = new CharSeparatorSpecification("/");
		assertTrue(spec.isSatisfiedBy("02/04"));
	}
	
	@Test
	public void separatorCharWrong() {
		CharSeparatorSpecification spec = new CharSeparatorSpecification(")");
		assertFalse(spec.isSatisfiedBy("02/04"));
	}
	
	@Test
	public void oneSeparatorRight() {
		HasOneSeparatorSpecification spec = new HasOneSeparatorSpecification("/");
		assertTrue(spec.isSatisfiedBy("02/04"));
	}
	
	@Test
	public void oneSeparatorWrong() {
		HasOneSeparatorSpecification spec = new HasOneSeparatorSpecification("/");
		assertFalse(spec.isSatisfiedBy("02/04/2000"));
	}
	
	@Test
	public void validMonth() {
		IsMonthSpecification spec = new IsMonthSpecification("/");
		assertTrue(spec.isSatisfiedBy("02/04"));
	}
	
	@Test
	public void invalidMonth() {
		IsMonthSpecification spec = new IsMonthSpecification("/");
		assertFalse(spec.isSatisfiedBy("02/13"));
	}
}
