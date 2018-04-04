package org.bienestar.cocina.controller;

import org.bienestar.cocina.view.View;

public abstract class Controller<T extends View> {

	private T view;
	
	public Controller(T view) {
		this.view = view;
	}
	
	public T getView(){
		return view;
	}
}
