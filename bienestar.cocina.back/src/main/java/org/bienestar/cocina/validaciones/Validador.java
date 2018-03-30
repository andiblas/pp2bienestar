package org.bienestar.cocina.validaciones;

import java.util.ArrayList;
import java.util.List;

import org.bienestar.cocina.excepciones.ValidacionException;

public abstract class Validador {

	protected List<Validacion> validaciones;
	
	public Validador() {
		this.validaciones = new ArrayList<Validacion>();
		//TODO hacer singleton de las validaciones
	}
	
	public abstract void validar(Object param) throws ValidacionException;
	
	protected void agregarValidacion(Validacion validacion){
		this.validaciones.add(validacion);
	}
}
