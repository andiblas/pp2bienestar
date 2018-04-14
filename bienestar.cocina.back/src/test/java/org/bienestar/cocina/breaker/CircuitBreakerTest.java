package org.bienestar.cocina.breaker;

import org.bienestar.cocina.exceptions.OpenCircuitException;
import org.bienestar.cocina.messages.SendMessageCommand;
import org.junit.Before;
import org.junit.Test;

public class CircuitBreakerTest {

	private CircuitBreaker breaker;
	
	@Before
	public void setUp() {
	}
	
	@Test(expected = OpenCircuitException.class)
	public void breakerOpen() throws Exception {
		breaker = new CircuitBreaker(new SendMessageCommand(new EjemploSender(),"mensaje"), 1, 5000);
		try {
			breaker.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		breaker.run();
	}
	
	@Test(expected = Exception.class)
	public void breakerHalf() throws Exception {
		breaker = new CircuitBreaker(new SendMessageCommand(new EjemploSender(),"mensaje"), 1, 1);
		breaker.run();
		Thread.sleep(2);
		breaker.run();
	}
}
