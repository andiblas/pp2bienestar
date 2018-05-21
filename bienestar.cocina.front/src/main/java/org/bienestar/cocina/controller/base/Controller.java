package org.bienestar.cocina.controller.base;

import org.bienestar.cocina.view.base.View;

public abstract class Controller<T extends View> {

	private T view;
	
	public Controller(T view) {
		this.view = view;
	}
	
	public T getView(){
		return view;
	}
}
