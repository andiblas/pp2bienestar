package org.bienestar.cocina.back.messenger.breaker;

import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.exceptions.SendingException;

public interface Sender {

	void send(Message message) throws SendingException;
}
