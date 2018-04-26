package org.bienestar.cocina.config;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.bienestar.cocina.configuration.Configuration;
import org.bienestar.cocina.exceptions.InvalidPropertieValue;
import org.bienestar.cocina.specifications.validations.IsPositive;
import org.bienestar.cocina.specifications.validations.IsValidInteger;
import org.bienestar.cocina.specifications.validations.IsValidLength;
import org.junit.Before;
import org.junit.Test;

public class ConfigurationTest {

	private String porcentajeTolerancia;
	
	@Before
	public void init() {
		porcentajeTolerancia = "porcentajeTolerancia";
	}
	
	@Test(expected = FileNotFoundException.class)
	public void notFoundConfig1() throws IOException {
		new Configuration("config/config1.properties");
	}
	
	@Test(expected = InvalidPropertieValue.class)
	public void invalidValue101() throws IOException,InvalidPropertieValue {
		Configuration config = new Configuration("config/config101.properties");
		config.getProperty(porcentajeTolerancia,new IsValidLength(2));
	}
	
	@Test(expected = InvalidPropertieValue.class)
	public void noKey() throws IOException,InvalidPropertieValue {
		Configuration config = new Configuration("config/config_nokey.properties");
		config.getProperty(porcentajeTolerancia, new IsValidLength(2));
	}
	
	@Test(expected = InvalidPropertieValue.class)
	public void invalidNegative1() throws IOException,InvalidPropertieValue {
		Configuration config = new Configuration("config/config-1.properties");
		config.getProperty(porcentajeTolerancia,new IsPositive());
	}
	
	@Test(expected = InvalidPropertieValue.class)
	public void invalidEmpty() throws IOException,InvalidPropertieValue {
		Configuration config = new Configuration("config/config_empty.properties");
		config.getProperty(porcentajeTolerancia,new IsValidInteger());
	}
	
	@Test(expected = InvalidPropertieValue.class)
	public void invalidStringValue() throws IOException,InvalidPropertieValue {
		Configuration config = new Configuration("config/config_a.properties");
		config.getProperty(porcentajeTolerancia,new IsValidInteger());
	}
	
	@Test
	public void validValue20() throws IOException {
		Configuration config = new Configuration("config/config.properties");
		String prop = config.getProperty(porcentajeTolerancia);
		assertEquals("20", prop);
	}
	
}
