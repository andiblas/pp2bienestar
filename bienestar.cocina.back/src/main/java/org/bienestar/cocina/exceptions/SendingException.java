package org.bienestar.cocina.exceptions;

public class SendingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Contructor con el Mensaje de Error
     *
     * @param message Mensaje de Error
     */
    public SendingException(String message) {
        super(message);
    }

    /**
     * Contructor con el Mensaje de Error y la Causa de la Excepción
     *
     * @param message Mensaje de Error
     * @param cause Causa de la Excepción
     */
    public SendingException(String message, Throwable cause) {
        super(message, cause);
    }
}
