package org.bienestar.cocina.model;

import java.util.Observable;

public class Model extends Observable{

	private Integer currentTotal;

    public Model() {
        this.currentTotal = 0;
    }
    
    public void incrementar(){
    	currentTotal = currentTotal + 1;
    	setChanged();
    	Display display = new Display();
    	display.setValor(currentTotal);
    	notifyObservers(display);
    }
}
