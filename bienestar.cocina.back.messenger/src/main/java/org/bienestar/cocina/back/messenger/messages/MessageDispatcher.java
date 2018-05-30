package org.bienestar.cocina.back.messenger.messages;

import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.back.messenger.breaker.CircuitBreaker;
import org.bienestar.cocina.back.senders.Sender;

public class MessageDispatcher {

	private Message<?> message;
	private CircuitBreaker cb;
	private Sender<Message<?>> sender;

	public MessageDispatcher(Message<?> message, CircuitBreaker cb, Sender<Message<?>> sender) {
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
