package org.bienestar.cocina.exceptions;

import org.bienestar.cocina.internationalization.MessageResource;

public class TooManySeparatorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TooManySeparatorException() {
		super(MessageResource.getInstance().getMessage("ex.oneseparator"));
	}
}
