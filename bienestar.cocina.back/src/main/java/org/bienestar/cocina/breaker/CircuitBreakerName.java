package org.bienestar.cocina.breaker;

public enum CircuitBreakerName {

	EJEMPLO("ejemplo");
	private String nombre;
	
	private CircuitBreakerName(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
}
