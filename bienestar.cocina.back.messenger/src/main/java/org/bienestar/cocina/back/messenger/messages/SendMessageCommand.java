package org.bienestar.cocina.back.messenger.messages;

import org.bienestar.cocina.back.messenger.breaker.CircuitBreakerCommand;
import org.bienestar.cocina.back.messenger.breaker.Sender;

public class SendMessageCommand implements CircuitBreakerCommand {

	private String message;
	private Sender sender;

	public SendMessageCommand(Sender sender, String message) {
		this.message = message;
		this.sender = sender;
	}

	public void execute() throws Exception {
		sender.send(this.message);
	}

}
