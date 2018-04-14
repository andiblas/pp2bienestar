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
		OneSeparatorSpecification spec = new OneSeparatorSpecification("/");
		assertTrue(spec.isSatisfiedBy("02/04"));
	}
	
	@Test
	public void oneSeparatorWrong() {
		OneSeparatorSpecification spec = new OneSeparatorSpecification("/");
		assertFalse(spec.isSatisfiedBy("02/04/2000"));
	}
}
