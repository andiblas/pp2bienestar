package org.bienestar.cocina.mensajes;

public class Mensaje {

	private String tipo;
	private String mensaje;
	
	
	public Mensaje(String tipo, String mensaje) {
		super();
		this.tipo = tipo;
		this.mensaje = mensaje;
	}
	
	public String getTipo() {
		return tipo;
	}
	public String getMensaje() {
		return mensaje;
	}
	
}
