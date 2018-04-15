package org.bienestar.cocina.messages;

import org.bienestar.cocina.breaker.CircuitBreaker;
import org.bienestar.cocina.breaker.CircuitBreakerName;
import org.bienestar.cocina.breaker.CircuitBreakerRegistry;
import org.bienestar.cocina.breaker.Sender;
import org.bienestar.cocina.exceptions.SendingException;

public class MessageDispatcher {

	private String message;

	public MessageDispatcher(String message) {
		this.message = message;
	}

	public void dispatch() throws Exception {
		CircuitBreakerRegistry registry = CircuitBreakerRegistry.getInstance();
		CircuitBreaker cb = registry.getCircuitBreaker(CircuitBreakerName.EJEMPLO.toString());
		SendMessageCommand sender = new SendMessageCommand(new Sender() {
			public void send(String message) throws SendingException {
			}
		}, message);
		cb.setCommand(sender);
		cb.run();
	}

}
