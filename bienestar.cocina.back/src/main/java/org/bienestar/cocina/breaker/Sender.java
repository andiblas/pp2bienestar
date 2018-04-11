package org.bienestar.cocina.breaker;

import org.bienestar.cocina.excepciones.SendingException;

public interface Sender {

	void send(Message message) throws SendingException;
}
