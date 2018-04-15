package org.bienestar.cocina.specifications.validations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.bienestar.cocina.specifications.generic.NotSpecification;
import org.bienestar.cocina.specifications.generic.Specification;
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
		HasOneSeparator spec = new HasOneSeparator("/");
		assertTrue(spec.isSatisfiedBy("02/04"));
	}

	@Test
	public void oneSeparatorWrong() {
		HasOneSeparator spec = new HasOneSeparator("/");
		assertFalse(spec.isSatisfiedBy("02/04/2000"));
	}

	@Test
	public void validMonth() {
		IsMonth spec = new IsMonth("/");
		assertTrue(spec.isSatisfiedBy("02/04"));
	}

	@Test
	public void invalidMonth() {
		IsMonth spec = new IsMonth("/");
		assertFalse(spec.isSatisfiedBy("02/13"));
	}

	@Test
	public void isFebruary() {
		IsFebruary spec = new IsFebruary("/");
		assertTrue(spec.isSatisfiedBy("03/02"));
	}

	@Test
	public void is31DaysMonth() {
		Is31DaysMonth spec = new Is31DaysMonth("/");
		assertTrue(spec.isSatisfiedBy("03/03"));
	}

	@Test
	public void is30DaysMonth() {
		Is30DaysMonth spec = new Is30DaysMonth("/");
		assertTrue(spec.isSatisfiedBy("03/04"));
	}

	@Test
	public void lastFebruaryDay() {
		Specification<String> spec = new IsFebruary("/").and(new IsValidDay("/", 29));
		assertTrue(spec.isSatisfiedBy("29/02"));
	}

	@Test
	public void lastMarchDay() {
		Specification<String> spec = new Is31DaysMonth("/").and(new IsValidDay("/", 31));
		assertTrue(spec.isSatisfiedBy("31/03"));
	}

	@Test
	public void lastAprilDay() {
		Specification<String> spec = new Is30DaysMonth("/").and(new IsValidDay("/", 30));
		assertTrue(spec.isSatisfiedBy("30/04"));
	}

	@Test
	public void isNot30DaysMonth() {
		Specification<String> spec = new Is30DaysMonth("/").and(new IsValidDay("/", 30));
		assertFalse(spec.isSatisfiedBy("30/05"));
	}
	
	@Test
	public void invalidDays() {
		Specification<String> spec = new Is30DaysMonth("/").and(new IsValidDay("/", 30));
		assertFalse(spec.isSatisfiedBy("31/04"));
	}
	
	@Test
	public void isValidDay() {
		Specification<String> is31daysMonthSpecification = new Is31DaysMonth("/").and(new IsValidDay("/", 31));
		Specification<String> is30daysMonthSpecification = new Is30DaysMonth("/").and(new IsValidDay("/", 30));
		Specification<String> notLeapYear = new NotSpecification<String>(new IsLeapYear());
		Specification<String> isFebruarySpecification = new IsFebruary("/").and(notLeapYear).and(new IsValidDay("/", 28));
		Specification<String> isFebruaryLeapYearSpecification = new IsFebruary("/").and(new IsLeapYear()).and(new IsValidDay("/", 29));
		Specification<String> isValidDaySpecification = is31daysMonthSpecification.or(is30daysMonthSpecification)
				.or(isFebruarySpecification).or(isFebruaryLeapYearSpecification);
		assertTrue(isValidDaySpecification.isSatisfiedBy("28/02"));
	}
	
	@Test
	public void isNotLeapYear() {
		Specification<String> leapYear = new IsLeapYear();
		assertTrue(leapYear.not(leapYear).isSatisfiedBy("30/04"));
	}
	
	@Test
	public void is31daysMonth() {
		Specification<String> is31DaysMonth = new Is31DaysMonth("/");
		assertFalse(is31DaysMonth.not(is31DaysMonth).isSatisfiedBy("30/05"));
	}
}
