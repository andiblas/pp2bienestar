package org.bienestar.cocina.exceptions;

import org.bienestar.cocina.internationalization.MessageResource;

public class InvalidMonthException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String mensaje = MessageResource.getMessage("ex.mesinvalido");
	
	public InvalidMonthException() {
		super(mensaje);
	}
}
