package org.bienestar.cocina.breaker;

import org.bienestar.cocina.excepciones.SendingException;

public class EjemploSender implements Sender{

	public void send(Message message) throws SendingException {
		throw new SendingException("errorSender");
	}

}
