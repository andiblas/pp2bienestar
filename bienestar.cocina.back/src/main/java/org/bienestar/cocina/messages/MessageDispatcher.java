package org.bienestar.cocina.messages;

import org.bienestar.cocina.breaker.CircuitBreaker;
import org.bienestar.cocina.breaker.CircuitBreakerName;
import org.bienestar.cocina.breaker.CircuitBreakerRegistry;
import org.bienestar.cocina.breaker.EjemploSender;

public class MessageDispatcher {

	private String message;

	public MessageDispatcher(String message) {
		this.message = message;
	}

	public void dispatch() throws Exception {
		CircuitBreakerRegistry registry = CircuitBreakerRegistry.getInstance();
		CircuitBreaker cb = registry
				.getCircuitBreaker(CircuitBreakerName.EJEMPLO.toString());
		SendMessageCommand sender = new SendMessageCommand(new EjemploSender(),
				message);
		cb.setCommand(sender);
		cb.run();
	}

}
