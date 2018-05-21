package org.bienestar.cocina.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.bienestar.cocina.controller.base.Controller;
import org.bienestar.cocina.view.PlantillaDiariaView;

public class PlanillaDiariaController extends Controller<PlantillaDiariaView>{
	

	public PlanillaDiariaController(PlantillaDiariaView view) {
		super(view);
		view.asociarEnviarListener(new EnviarListener());
	}
	
	class EnviarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		}
    	
    }
}
