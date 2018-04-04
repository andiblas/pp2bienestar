package org.bienestar.cocina.excepciones;

public class ValidacionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoDeError;

    /**
     * Constructor sin Argumentos
     */
    public ValidacionException() {
        super();
    }

    /**
     * Contructor con el Mensaje de Error
     *
     * @param message Mensaje de Error
     */
    public ValidacionException(String message) {
        super(message);
    }

    /**
     * Contructor con la Causa de la Excepción
     *
     * @param cause Causa de la Excepción
     */
    public ValidacionException(Throwable cause) {
        super(cause);
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

    /**
     * Contructor con la Causa de la Excepción y el Código de Error
     *
     * @param cause Causa de la Excepción
     * @param codigoDeError Código de Error
     */
    public ValidacionException(Throwable cause, String codigoDeError) {
        super(cause);
        this.codigoDeError = codigoDeError;
    }

    /**
     * Contructor con el Mensaje de Error y el Código de Error
     *
     * @param message Mensaje de Error
     * @param codigoDeError Código de Error
     */
    public ValidacionException(String message, String codigoDeError) {
        super(message);
        this.codigoDeError = codigoDeError;
    }

    /**
     * Devuelve el Código de Error
     *
     * @return Devuelve el Código de Error
     */
    public String getCodigoDeError() {
        return codigoDeError;
    }

    /**
     * Setea el Código de Error
     *
     * @param codigoDeError Código de Error
     */
    public void setCodigoDeError(String codigoDeError) {
        this.codigoDeError = codigoDeError;
    }
}
