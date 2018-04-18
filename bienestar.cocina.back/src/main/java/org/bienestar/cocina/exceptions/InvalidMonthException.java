package org.bienestar.cocina.exceptions;

import org.bienestar.cocina.internationalization.MessageResource;

public class InvalidMonthException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMonthException() {
		super(MessageResource.getMessage("ex.mesinvalido"));
	}
}
