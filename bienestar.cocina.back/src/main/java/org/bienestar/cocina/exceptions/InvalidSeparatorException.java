package org.bienestar.cocina.exceptions;

import org.bienestar.cocina.internationalization.MessageResource;

public class InvalidSeparatorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSeparatorException() {
		super(MessageResource.getInstance().getMessage("ex.invalidseparator"));
	}
}
