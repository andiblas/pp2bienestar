package org.bienestar.cocina.validaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.bienestar.cocina.excepciones.ValidacionException;
import org.bienestar.cocina.mensajes.Mensaje;

public abstract class Validador extends Observable{

	protected List<Validacion> validaciones;
	
	public Validador() {
		this.validaciones = new ArrayList<Validacion>();
		//TODO hacer singleton de las validaciones
	}
	
	public void validar(Object param){
		try {
			validate(param);
		} catch (ValidacionException e) {
			setChanged();
			notifyObservers(new Mensaje("E", e.getMessage()));
		}
	}
	
	protected abstract void validate(Object param) throws ValidacionException;
	
	protected void agregarValidacion(Validacion validacion){
		this.validaciones.add(validacion);
	}
}
