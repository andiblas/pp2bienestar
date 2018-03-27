package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.bienestar.cocina.model.Model;
import org.bienestar.cocina.view.View;

public class Controller {

	private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        model.addObserver(view);

        view.setMiListener(new MiListener());

    }

    class MiListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			model.incrementar();
		}
    	
    }
}
