package org.bienestar.cocina.messages;

public class Message {

	private String tipo;
	private String mensaje;
	
	
	public Message(String tipo, String mensaje) {
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
