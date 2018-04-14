package org.bienestar.cocina.breaker;

import org.bienestar.cocina.exceptions.SendingException;

public interface Sender {

	void send(String message) throws SendingException;
}
