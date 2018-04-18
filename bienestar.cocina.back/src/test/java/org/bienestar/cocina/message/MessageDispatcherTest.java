package org.bienestar.cocina.message;

import org.bienestar.cocina.breaker.CircuitBreaker;
import org.bienestar.cocina.breaker.Sender;
import org.bienestar.cocina.exceptions.SendingException;
import org.bienestar.cocina.messages.MessageDispatcher;
import org.junit.Test;

public class MessageDispatcherTest {

	@Test()
	public void messageDispatchTest() throws Exception {
		CircuitBreaker cb = new CircuitBreaker(null, 2, 1000);
		Sender sender = new Sender() {
			public void send(String message) throws SendingException {
			}
		};
		MessageDispatcher dispatcher = new MessageDispatcher("message", cb, sender);
		dispatcher.dispatch();
	}
	
}
