package org.bienestar.cocina.excepciones;

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

    /**
     * Contructor con el Mensaje de Error y la Causa de la Excepción
     *
     * @param message Mensaje de Error
     * @param cause Causa de la Excepción
     */
    public ValidacionException(String message, Throwable cause) {
        super(message, cause);
    }

}
