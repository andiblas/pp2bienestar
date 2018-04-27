package org.bienestar.cocina.breaker;

import static org.junit.Assert.assertEquals;

import org.bienestar.cocina.exceptions.SendingException;
import org.bienestar.cocina.messages.SendMessageCommand;
import org.junit.Test;

public class CircuitBreakerTest {

	@Test(expected = SendingException.class)
	public void breakerOpen() throws Exception {
		CircuitBreaker breaker = new CircuitBreaker(new SendMessageCommand(new Sender() {
			public void send(String message) throws SendingException {
				throw new SendingException("errorSender");
			}
		}, "mensaje"), 1, 5000);
		breaker.run();
	}

	@Test(expected = SendingException.class)
	public void breakerHalf() throws Exception {
		CircuitBreaker breaker = new CircuitBreaker(new SendMessageCommand(new Sender() {
			public void send(String message) throws SendingException {
				throw new SendingException("errorSender");
			}
		}, "mensaje"), 1, 1);
		breaker.run();
		Thread.sleep(2);
		breaker.run();
	}
	
	@Test
	public void registerBreaker() {
		CircuitBreaker cb = new CircuitBreaker(1, 1);
		CircuitBreakerRegistry.getInstance().register(CircuitBreakerName.TEST_BREAKER.getNombre(), cb);
		CircuitBreaker cbRegistred = CircuitBreakerRegistry.getInstance().getCircuitBreaker(CircuitBreakerName.TEST_BREAKER.getNombre());
		assertEquals(cb, cbRegistred);
	}
	
}
