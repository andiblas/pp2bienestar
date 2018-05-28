package org.bienestar.cocina.back.messenger.messages;

import org.bienestar.cocina.back.messenger.breaker.CircuitBreaker;
import org.bienestar.cocina.back.messenger.breaker.Sender;

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