package org.bienestar.cocina.validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.bienestar.cocina.exceptions.ValidacionException;
import org.bienestar.cocina.messages.Message;

public abstract class Validador extends Observable{

	protected List<Validator> validaciones;
	
	public Validador() {
		this.validaciones = new ArrayList<Validator>();
		//TODO hacer singleton de las validaciones
	}
	
	public void validar(Object param){
		try {
			for(Validator validacion : validaciones){
				validacion.execute(param);
			}
		} catch (ValidacionException e) {
			setChanged();
			notifyObservers(new Message("E", e.getMessage()));
		}
	}
	
	protected void agregarValidacion(Validator validacion){
		this.validaciones.add(validacion);
	}
}
