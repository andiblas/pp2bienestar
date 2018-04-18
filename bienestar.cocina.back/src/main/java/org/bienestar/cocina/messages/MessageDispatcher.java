package org.bienestar.cocina.messages;

import org.bienestar.cocina.breaker.CircuitBreaker;
import org.bienestar.cocina.breaker.CircuitBreakerName;
import org.bienestar.cocina.breaker.CircuitBreakerRegistry;
import org.bienestar.cocina.breaker.Sender;
import org.bienestar.cocina.exceptions.SendingException;

public class MessageDispatcher {

	private String message;
	private CircuitBreaker cb;
	private Sender sender;

	public MessageDispatcher(String message, CircuitBreaker cb, Sender sender) {
		this.message = message;
		this.cb = cb;
		this.sender = sender;
	}

	public void dispatch() throws Exception {
		SendMessageCommand sendCommand = new SendMessageCommand(sender, message);
		cb.setCommand(sendCommand);
		cb.run();
	}

}
