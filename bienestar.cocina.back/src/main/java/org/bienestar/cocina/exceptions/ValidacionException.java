package org.bienestar.cocina.exceptions;

public class ValidacionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * Contructor con el Mensaje de Error
     *
     * @param message Mensaje de Error
     */
    public ValidacionException(String message) {
        super(message);
    }

}
